package models;

public class Quarto {
    private int id;
    private String tipo;      // Ex: simples, duplo, suíte
    private boolean disponivel;
    private double precoDiaria;

    public Quarto(int id, String tipo, boolean disponivel, double precoDiaria) {
        this.id = id;
        this.tipo = tipo;
        this.disponivel = disponivel;
        this.precoDiaria = precoDiaria;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    @Override
    public String toString() {
        return "Quarto [id=" + id +
                ", tipo=" + tipo +
                ", disponível=" + (disponivel ? "Sim" : "Não") +
                ", preço por diária=R$" + precoDiaria + "]";
    }
}

