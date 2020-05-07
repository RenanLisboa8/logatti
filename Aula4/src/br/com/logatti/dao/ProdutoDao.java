package br.com.logatti.dao;

import br.com.logatti.factory.ConnectionFactory;
import br.com.logatti.model.Produto;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDao {
    private Connection connection;

    public ProdutoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public ArrayList buscar(Produto produto) {
        try {
            String sql = "";
            if (!produto.getDescricao().isEmpty()) {
                sql = "SELECT * FROM Produto WHERE Descricao LIKE '%" + produto.getDescricao() + "%' ";

            } else if (!produto.getTipo().isEmpty()) {
                sql = "SELECT * FROM Produto WHERE Tipo LIKE '%" + produto.getTipo() + "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("Descricao"),
                        rs.getString("Tipo"),
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }

    }
}
