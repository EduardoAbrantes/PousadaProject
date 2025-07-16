package controllers;

import models.Quarto;
import data.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {
    private Connection connection;

    public QuartoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserir(Quarto quarto) {
        String sql = "INSERT INTO quartos (tipo, disponivel, preco_diaria) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, quarto.getTipo());
            stmt.setBoolean(2, quarto.isDisponivel());
            stmt.setDouble(3, quarto.getPrecoDiaria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Quarto> listar() {
        List<Quarto> lista = new ArrayList<>();
        String sql = "SELECT * FROM quartos";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Quarto q = new Quarto(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getBoolean("disponivel"),
                    rs.getDouble("preco_diaria")
                );
                lista.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM quartos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

