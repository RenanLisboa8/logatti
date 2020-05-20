package src.br.com.logatti.factory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class ConnectionFactory {
    private Statement statement;
    private Connection connection;


    public void getConnection() throws ClassNotFoundException {
        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "root");
//            Class.forName("org.sqlite.JDBC");
            Class.forName("org.sqlite.JDBC");
            //TO DO - mudar o path do banco
            DriverManager.getConnection("jdbc:sqlite:/home/davi/Área de Trabalho/workspace/logatti/logatti/Avaliacao/loja.db");
            statement = connection.createStatement();
            System.out.println("conectou!");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
