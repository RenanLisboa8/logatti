package br.com.logatti.dao;

import br.com.logatti.factory.ConnectionFactory;
import br.com.logatti.model.Pedido;
import br.com.logatti.model.Pedido;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDao {

    private Connection connection;

    public PedidoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public ArrayList buscar(Pedido pedido) {
        try {
            String sql = "";
            if (pedido.getNumPedido() != 0) {
                sql = "SELECT * FROM Pedido WHERE NumPedido = " + pedido.getNumPedido() + "";

            } else if (!pedido.getDescricao().isEmpty()) {
                sql = "SELECT * FROM Pedido WHERE Tipo LIKE '%" + pedido.getDescricao() + "%' ";
            }

            ArrayList<Pedido> dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Pedido(rs.getInt("NumPedido"),
                        rs.getString("Descricao"),
                        rs.getDate("dtcompra"),
                        rs.getString("status"),
                        null)
                );

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
