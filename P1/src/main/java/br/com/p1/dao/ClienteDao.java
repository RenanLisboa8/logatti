package br.com.p1.dao;

import br.com.p1.factory.ConnectionFactory;

import java.sql.Connection;

public class ClienteDao {
    private Connection connection;

    public ClienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
}
