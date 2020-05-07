package br.com.logatti.model;

import java.util.Date;

public class Pedido {
    private int NumPedido;
    private String Descricao;
    private Date DtCompra;
    private String Status;
    private Produto Produto;

    public int getNumPedido() {
        return NumPedido;
    }

    public void setNumPedido(int numPedido) {
        NumPedido = numPedido;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Date getDtCompra() {
        return DtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        DtCompra = dtCompra;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public br.com.logatti.model.Produto getProduto() {
        return Produto;
    }

    public void setProduto(br.com.logatti.model.Produto produto) {
        Produto = produto;
    }

    public Pedido(int numPedido, String descricao, Date dtCompra, String status, br.com.logatti.model.Produto produto) {
        NumPedido = numPedido;
        Descricao = descricao;
        DtCompra = dtCompra;
        Status = status;
        Produto = produto;
    }
}
