package br.com.logatti.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "root");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
