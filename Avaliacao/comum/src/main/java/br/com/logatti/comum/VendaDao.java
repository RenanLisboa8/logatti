package br.com.logatti.comum;
//
//import br.com.p1.factory.ConnectionFactory;
//import br.com.p1.model.Venda;

import java.sql.*;
import java.util.ArrayList;

public class VendaDao {
    private Connection connection;

    public VendaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirVenda(Venda venda) {
        PreparedStatement stmt = null;

        String sql = "insert into vendas " +
                "(data, funcionarioId, clienteId) " +
                "values (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            stmt = connection.prepareStatement(sql);

            stmt.setDate(1, (Date) venda.getData());
            stmt.setInt(1, venda.getFuncionarioId());
            stmt.setInt(1, venda.getClienteId());

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

    public ArrayList<Venda> lisarVendas() {
        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Venda> vendas = null;

        try {
            connection.setAutoCommit(false);

            stmt = this.connection.prepareStatement("select * from vendas");

            rs = stmt.executeQuery();

            vendas = new ArrayList<Venda>();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getInt("vendaId"));
                venda.setData(rs.getDate("data"));
                venda.setClienteId(rs.getInt("clientId"));
                venda.setFuncionarioId(rs.getInt("funcionarioId"));
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
        return vendas;
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
