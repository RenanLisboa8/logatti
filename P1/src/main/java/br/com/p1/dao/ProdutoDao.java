package br.com.p1.dao;

import br.com.p1.factory.ConnectionFactory;
import br.com.p1.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutoDao {
    private Connection connection;

    public ProdutoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void diminuirEstoque(int produtoId, int quantidade) {


        String sql = "update Produto "
                + "set estoque = (estoque - ?) "
                + "where codProduto = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, quantidade);
            stmt.setInt(2, produtoId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void entradaEstoque(int produtoId, int estoque) {


        String sql = "update Produto "
                + "set estoque = (estoque + ?) "
                + "where produtoId = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, estoque);
            stmt.setInt(2, produtoId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }


    public void inserirProduto(Produto produto) {
        PreparedStatement stmt = null;

        String sql = "insert into produto " +
                "(descricao, estoque, valor) " +
                "values (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());

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

    public void alterarProduto(Produto produto) {
        PreparedStatement stmt = null;

        String sql = "update produto " +
                "set descricao=?, estoque=?, valor=? " +
                "where produtoId=?";

        try {
            connection.setAutoCommit(false);

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());
            stmt.setInt(4, produto.getId());

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

    public void excluirProduto(Produto produto) {
        PreparedStatement stmt = null;


        String sql = "delete from produto " +
                "where produtoId=? ";

        try {
            connection.setAutoCommit(false);

            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, produto.getId());

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

    public ArrayList<Produto> listarProdutos() {
        PreparedStatement stmt = null;

        ResultSet rs = null;
        ArrayList<Produto> produtos = null;

        try {
            connection.setAutoCommit(false);

            stmt = this.connection.prepareStatement("select * from produto");

            rs = stmt.executeQuery();

            produtos = new ArrayList<Produto>();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getInt("produtoId"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("Estoque"));
                produto.setValor(rs.getDouble("valor"));

                produtos.add(produto);

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
        return produtos;
    }

    public ArrayList<Produto> buscarProdutos(String busca) {
        PreparedStatement stmt = null;

        ResultSet rs = null;
        ArrayList<Produto> produtos = null;

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement("select * from produto where descricao like ?");
            stmt.setString(1, busca + "%");

            rs = stmt.executeQuery();

            produtos = new ArrayList<Produto>();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getInt("produtoId"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("estoque"));
                produto.setValor(rs.getDouble("valor"));

                produtos.add(produto);
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
        return produtos;
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
