package br.com.p1.model;

import java.util.Date;

public class Venda {
    public Venda(Date data, int funcionarioId, int clienteId) {
        Data = data;
        FuncionarioId = funcionarioId;
        ClienteId = clienteId;
    }

    private int Id;
    private Date Data;
    private int FuncionarioId;
    private int ClienteId;


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
