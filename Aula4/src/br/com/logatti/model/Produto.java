package br.com.logatti.model;

public class Produto {
    private int Id;
    private String Descricao;
    private String Tipo;

    public Produto(int id, String descricao, String tipo) {
        Id = id;
        Descricao = descricao;
        Tipo = tipo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
