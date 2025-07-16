CREATE DATABASE IF NOT EXISTS pousada;
USE pousada;

DROP TABLE IF EXISTS hospedes

CREATE TABLE hospedes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14),
    telefone VARCHAR(20),
    email VARCHAR(100)
);