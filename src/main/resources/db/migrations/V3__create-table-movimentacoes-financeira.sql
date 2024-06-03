CREATE TABLE movimentacoes_financeira (
    id_movimentacao BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_conta_origem BIGINT NOT NULL,
    id_conta_destino BIGINT NOT NULL,
    valor DECIMAL(15, 2) NOT NULL,
    data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descricao VARCHAR(255),
    FOREIGN KEY (id_conta_origem) REFERENCES contas_bancaria(id_conta),
    FOREIGN KEY (id_conta_destino) REFERENCES contas_bancaria(id_conta),
    PRIMARY KEY(id_movimentacao)
);