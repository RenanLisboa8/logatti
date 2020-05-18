package br.com.logatti.dao;

import br.com.logatti.comum.IVendaDao;
import br.com.logatti.factory.ConnectionFactory;
import br.com.logatti.model.Venda;
import br.com.logatti.model.VendaItem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class VendaDao extends UnicastRemoteObject implements IVendaDao {
    private static final long serialVersionUID = 6006315725771594101L;
    private Connection connection;

    public VendaDao() throws RemoteException {
        this.connection = new ConnectionFactory().getConnection();
    }

    private void inserirVendaItem(Connection con, ArrayList<VendaItem> produtosComprados, int vendaId) {
        PreparedStatement ps = null;

        String sql = "insert into itensVenda "
                + "(vendaId, produtoId) "
                + "values (?, ?, ?)";

        try {
            con.setAutoCommit(false);

            ps = con.prepareCall(sql);

            for (VendaItem vi : produtosComprados) {
                ps.setInt(1, vendaId);
                ps.setInt(2, vi.getProdutoId());

                ps.executeUpdate();

                con.commit();
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
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

    public void inserirVenda(ArrayList<VendaItem> itensComprados, Venda v) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int codigoVendaInserido;

        String sql = "insert into venda "
                + "(clienteId, dataManutencao, valorTotal) "
                + "values (?, ?, ?) ";

        try {
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, v.getClienteId());
            ps.setDate(2, new java.sql.Date(v.getData().getTime()));
            ps.setDouble(3, v.getTotal());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            rs.next();
            codigoVendaInserido = rs.getInt(1);

            inserirVendaItem(connection, itensComprados, codigoVendaInserido);

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            dispose(ps, rs, connection);
        }
    }

    public ArrayList<Venda> lisarVendas(Date dataInicial, Date dataFinal) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Venda> vendas = null;

        try {
            connection.setAutoCommit(false);

            ps = this.connection.prepareStatement("select v.vendaId, v.dataVenda, v.valorTotal "
                    + "from venda v, cliente c "
                    + "where v.clienteId = c.clienteId "
                    + "and v.dataVenda between ? and ? "
                    + "order by v.vendaId asc");

            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);

            rs = ps.executeQuery();

            vendas = new ArrayList<Venda>();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getInt("vendaId"));
                venda.setData(rs.getDate("dataVenda"));
                venda.setTotal(rs.getDouble("valorTotal"));

                vendas.add(venda);

                connection.commit();
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            dispose(ps, rs, connection);
        }
        return vendas;
    }

    private void dispose(PreparedStatement stmt, ResultSet rs, Connection c) {
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

    private void dispose(PreparedStatement stmt, Connection c) {
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
