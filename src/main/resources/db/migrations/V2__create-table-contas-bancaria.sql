CREATE TABLE contas_bancaria (
    id_conta BIGINT NOT NULL AUTO_INCREMENT,
    id_cliente BIGINT NOT NULL,
    Saldo DECIMAL(15, 2) DEFAULT 0,
    ind_ativo TINYINT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    PRIMARY KEY(id_conta)
);