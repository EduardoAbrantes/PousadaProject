package controllers;

import data.ConnectionFactory;
import models.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private Connection connection;

    public ReservaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserir(Reserva reserva) {
        try {
            // Buscar o preço da diária do quarto
            double precoDiaria = obterPrecoDoQuarto(reserva.getNumeroQuarto());

            // Calcular valor total
            reserva.calcularValorTotal(precoDiaria);

            // Inserir reserva
            String sql = "INSERT INTO reservas (nomeHospede, numeroQuarto, dataEntrada, dataSaida, valorTotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, reserva.getNomeHospede());
            stmt.setInt(2, reserva.getNumeroQuarto());
            stmt.setDate(3, Date.valueOf(reserva.getDataEntrada()));
            stmt.setDate(4, Date.valueOf(reserva.getDataSaida()));
            stmt.setDouble(5, reserva.getValorTotal());
            stmt.executeUpdate();

            // Atualizar status do quarto
            marcarQuartoComoOcupado(reserva.getNumeroQuarto());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private double obterPrecoDoQuarto(int numeroQuarto) {
        String sql = "SELECT preco FROM quartos WHERE numero = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, numeroQuarto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("preco");
            } else {
                throw new SQLException("Quarto não encontrado: " + numeroQuarto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar preço do quarto: " + e.getMessage());
        }
    }

    private void marcarQuartoComoOcupado(int numeroQuarto) {
        String sql = "UPDATE quartos SET status = 'ocupado' WHERE numero = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, numeroQuarto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reserva> listar() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id"),
                        rs.getString("nomeHospede"),
                        rs.getInt("numeroQuarto"),
                        rs.getDate("dataEntrada").toLocalDate(),
                        rs.getDate("dataSaida").toLocalDate(),
                        rs.getDouble("valorTotal")
                );
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

