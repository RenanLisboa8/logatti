package br.com.logatti.dao;

import br.com.logatti.comum.IClienteDao;
import br.com.logatti.factory.ConnectionFactory;
import br.com.logatti.model.Cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao extends UnicastRemoteObject implements IClienteDao {
    private static final long serialVersionUID = 162862048043243627L;
    private Connection connection;

    public ClienteDao() throws RemoteException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirCliente(Cliente cliente) {
        PreparedStatement stmt = null;

        String sql = "insert into cliente " +
                "(nome, cpf) " +
                "values (?, ?)";

        try {
            connection.setAutoCommit(false);

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());

            stmt.executeUpdate();

            connection.commit();
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

    public void atualizarCliente(Cliente cliente) {

        PreparedStatement stmt = null;

        String sql = "update cliente "
                + "set nome=?, cpf=? "
                + "where clienteId=? ";
        try {
            connection.setAutoCommit(false);

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getCpf());
            stmt.setString(1, cliente.getNome());

            stmt.executeUpdate();

            connection.commit();
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

    public void excluirCliente(Cliente cliente) {
        PreparedStatement stmt = null;

        String sql = "delete from cliente " +
                "where clienteId=? ";

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, cliente.getId());

            stmt.executeUpdate();
            connection.commit();
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

    public ArrayList<Cliente> listarClientes() {
        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Cliente> clientes = null;

        try {
            connection.setAutoCommit(false);

            stmt = this.connection.prepareStatement("select * from cliente");

            rs = stmt.executeQuery();

            clientes = new ArrayList<Cliente>();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("produtoId"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));

                clientes.add(cliente);

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
            dispose(stmt, rs, connection);
        }
        return clientes;
    }

    public  ArrayList<Cliente> buscarClientes(String busca) {
        PreparedStatement stmt = null;

        ResultSet rs = null;
        ArrayList<Cliente> clientes = null;

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement("select * from cliente where cpf like ?");
            stmt.setString(1, busca + "%");

            rs = stmt.executeQuery();

            clientes = new ArrayList<Cliente>();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("clienteId"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));

                clientes.add(cliente);
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
        return clientes;
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
