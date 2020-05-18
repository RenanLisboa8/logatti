package br.com.logatti.comum;
//
//import br.com.p1.factory.ConnectionFactory;
//import br.com.logatti.model.Venda;
//import br.com.logatti.model.VendaItem;

import java.sql.*;
import java.util.ArrayList;

public class VendaItemDao {
    private Connection connection;

    public VendaItemDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirVendaItem(VendaItem vendaItem) {
        PreparedStatement stmt = null;

        String sql = "insert into vendaItem " +
                "(vendaId, produtoId, quantidadde, total) " +
                "values (?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, vendaItem.getVendaId());
            stmt.setInt(1, vendaItem.getProdutoId());
            stmt.setInt(1, vendaItem.getQuantidade());
            stmt.setDouble(1, vendaItem.getTotal());

            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            dispose(stmt, connection);
        }
    }

    public ArrayList<VendaItem> lisarVendaItens() {
        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<VendaItem> vendaItems = null;

        try {
            connection.setAutoCommit(false);

            stmt = this.connection.prepareStatement("select * from vendaItem");

            rs = stmt.executeQuery();

            vendaItems = new ArrayList<VendaItem>();

            while (rs.next()) {
                VendaItem vendaItem = new VendaItem();

                vendaItem.setId(rs.getInt("vendaId"));
                vendaItem.setProdutoId(rs.getInt("produtoId"));
                vendaItem.setVendaId(rs.getInt("vendaId"));
                vendaItem.setQuantidade(rs.getInt("quantidade"));
                vendaItem.setTotal(rs.getDouble("total"));
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            dispose(stmt, rs, connection);
        }
        return vendaItems;
    }

    public void dispose(PreparedStatement stmt, ResultSet rs, Connection c) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void dispose(PreparedStatement stmt, Connection c) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
