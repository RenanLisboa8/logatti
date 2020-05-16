package br.com.p1.model;

public class Funcionario {
//    public Funcionario(String nome, double salario, String cpf) {
//        Nome = nome;
//        Salario = salario;
//        Cpf = cpf;
//    }

    private int Id;
    private String Nome;
    private double Salario;
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

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }
}
