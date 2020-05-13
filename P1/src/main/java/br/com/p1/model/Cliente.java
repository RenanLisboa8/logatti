package br.com.p1.model;

public class Cliente {
    public Cliente(String nome, String cpf) {
        Nome = nome;
        Cpf = cpf;
    }

    private int Id;
    private String Nome;
    private String Cpf;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }
}
