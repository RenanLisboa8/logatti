package br.com.p1.model;

public class VendaItem {

    public VendaItem(int vendaId, int produtoId, int quantidade, double total) {
        VendaId = vendaId;
        ProdutoId = produtoId;
        Quantidade = quantidade;
        Total = total;
    }

    private int Id;
    private int VendaId;
    private  int ProdutoId;
    private int Quantidade;
    private double Total;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getVendaId() {
        return VendaId;
    }

    public void setVendaId(int vendaId) {
        VendaId = vendaId;
    }

    public int getProdutoId() {
        return ProdutoId;
    }

    public void setProdutoId(int produtoId) {
        ProdutoId = produtoId;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
