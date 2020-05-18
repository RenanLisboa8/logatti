package br.com.logatti.model;

import java.util.Date;

public class Venda {
    private int Id;
    private Date Data;
    private int FuncionarioId;
    private int ClienteId;
    private double Total;

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public int getFuncionarioId() {
        return FuncionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        FuncionarioId = funcionarioId;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int clienteId) {
        ClienteId = clienteId;
    }
}
