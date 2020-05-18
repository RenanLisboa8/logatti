package br.com.logatti.comum;


//import br.com.p1.factory.ConnectionFactory;
//import package br.com.logatti.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDao {
    private Connection connection;

    public FuncionarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirFuncionario(Funcionario funcionario) {

        PreparedStatement stmt = null;

        String sql = "insert into funcionarios " +
                "(nome, salario, cpf) " +
                "values (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setDouble(1, funcionario.getSalario());
            stmt.setString(1, funcionario.getCpf());

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

    public void atualizarFuncionar(Funcionario funcionario) {

        PreparedStatement stmt = null;

        String sql = "update funcionarios "
                + "set nome=?, salario=?, cpf=? "
                + "where funcionarioId=? ";

        try {
            connection.setAutoCommit(false);


            stmt = connection.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setDouble(1, funcionario.getSalario());
            stmt.setString(1, funcionario.getCpf());

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

    public void excluirFuncionario(Funcionario funcionario) {
        PreparedStatement stmt = null;

        String sql = "delete from funcionarios " +
                "where funcionarioId=?";

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, funcionario.getId());

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

    public ArrayList<Funcionario> listarFuncionarios() {
        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Funcionario> funcionarios = null;

        try {
            connection.setAutoCommit(false);

            stmt = this.connection.prepareStatement("select * from funcionarios");

            rs = stmt.executeQuery();

            funcionarios = new ArrayList<Funcionario>();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(rs.getInt("funcionarioId"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setCpf(rs.getString("cpf"));
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
        return funcionarios;
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
