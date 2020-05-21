CREATE DATABASE avaliacao;

USE avaliacao;

CREATE TABLE Cliente(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100),
    Cpf VARCHAR(15)
);

SELECT * FROM avaliacao.cliente;