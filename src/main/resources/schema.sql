CREATE TABLE Categoria
(
    id_categoria SERIAL PRIMARY KEY,
    nome VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Produto
(
    id_produto SERIAL PRIMARY KEY,
    id_categoria INT,
    nome VARCHAR(255) NOT NULL,
    preco_custo NUMERIC(10, 2) NOT NULL,
    preco_venda NUMERIC(10, 2) NOT NULL,
    descricao TEXT NOT NULL,
    ativo BOOLEAN NOT NULL
);

CREATE TABLE Fornecedor
(
    id_fornecedor SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    cnpj VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE Venda
(
    id_venda SERIAL PRIMARY KEY,
    id_cliente INT,
    data_venda TIMESTAMP NOT NULL,
    desconto NUMERIC(10, 2) NOT NULL,
    total NUMERIC(10, 2) NOT NULL
);

CREATE TABLE Cliente
(
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE,
    telefone VARCHAR(13)
);

CREATE TABLE fornece
(
    id_fornecedor INT,
    id_produto INT,
    PRIMARY KEY(id_fornecedor, id_produto)

);

CREATE TABLE Item_Venda
(
    id_item_venda SERIAL PRIMARY KEY,
    id_venda INT NOT NULL,
    id_produto INT NOT NULL,
    preco_unitario NUMERIC(10, 2) NOT NULL,
    subtotal NUMERIC(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    UNIQUE(id_venda, id_produto)
);

CREATE TABLE Estoque
(
    id_estoque SERIAL PRIMARY KEY,
    id_produto INT UNIQUE NOT NULL,
    estoque_atual NUMERIC(10, 2) NOT NULL,
    estoque_minimo NUMERIC(10, 2) NOT NULL
);

CREATE TABLE Movimentacao_estoque
(
    id_movimentacao_estoque SERIAL PRIMARY KEY,
    id_estoque INT NOT NULL,
    id_venda INT,
    quantidade INT NOT NULL,
    motivo TEXT,
    tipo VARCHAR(20) NOT NULL,
    criado_em TIMESTAMP NOT NULL
);



ALTER TABLE Produto ADD FOREIGN KEY(id_categoria) REFERENCES Categoria (id_categoria);
ALTER TABLE Venda ADD FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente);
ALTER TABLE fornece ADD FOREIGN KEY(id_fornecedor) REFERENCES Fornecedor (id_fornecedor);
ALTER TABLE fornece ADD FOREIGN KEY(id_produto) REFERENCES Produto (id_produto);
ALTER TABLE Item_Venda ADD FOREIGN KEY(id_venda) REFERENCES Venda (id_venda);
ALTER TABLE Item_Venda ADD FOREIGN KEY(id_produto) REFERENCES Produto (id_produto);
ALTER TABLE Estoque ADD FOREIGN KEY(id_produto) REFERENCES Produto(id_produto);
ALTER TABLE Movimentacao_estoque ADD FOREIGN KEY(id_estoque) REFERENCES Estoque(id_estoque);
ALTER TABLE Movimentacao_estoque ADD FOREIGN KEY(id_venda) REFERENCES Venda(id_venda);
ALTER TABLE Movimentacao_estoque ADD CONSTRAINT ck_movimentacao_tipo CHECK ( tipo in ('ENTRADA', 'SAIDA', 'AJUSTE', 'DEVOLUCAO'));
ALTER TABLE Movimentacao_estoque ADD CONSTRAINT ck_movimentacao_quantidade CHECK (
    (tipo IN ('ENTRADA', 'DEVOLUCAO') AND quantidade > 0)
        OR (tipo = 'SAIDA' AND quantidade < 0)
        OR (tipo = 'AJUSTE' AND quantidade <> 0));