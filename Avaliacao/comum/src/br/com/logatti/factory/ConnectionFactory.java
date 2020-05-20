package src.br.com.logatti.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException {
        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "root");
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:/home/davi/Área de Trabalho/workspace/logatti/logatti/Avaliacao/loja.db");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
