package models;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private String nomeHospede;
    private int numeroQuarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorTotal;

    public Reserva(int id, String nomeHospede, int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida, double valorTotal) {
        this.id = id;
        this.nomeHospede = nomeHospede;
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
    }

    public Reserva(String nomeHospede, int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida, double valorTotal) {
        this(0, nomeHospede, numeroQuarto, dataEntrada, dataSaida, valorTotal);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Reserva #" + id +
               "\nHóspede: " + nomeHospede +
               "\nQuarto Nº: " + numeroQuarto +
               "\nEntrada: " + dataEntrada +
               "\nSaída: " + dataSaida +
               "\nTotal: R$ " + valorTotal;
    }
}

