package models;

public class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private int jornada;

    public Funcionario(int id, String nome, String cargo, int jornada) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.jornada = jornada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", jornada=" + jornada +
                '}';
    }
}
