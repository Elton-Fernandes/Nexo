CREATE TABLE Categoria
(
    id_categoria SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE Produto
(
    id_produto SERIAL PRIMARY KEY,
    id_categoria INT,
    nome VARCHAR(255) NOT NULL,
    preco_custo NUMERIC(10, 2) NOT NULL,
    preco_venda NUMERIC(10, 2) NOT NULL,
    estoque INT NOT NULL,
    descricao TEXT NOT NULL,
    ativo BOOLEAN NOT NULL,
    estoque_minimo INT NOT NULL
);

CREATE TABLE Fornecedor
(
    id_fornecedor SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    cnpj VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE Venda
(
    id_venda SERIAL PRIMARY KEY,
    id_cliente INT,
    data_venda DATE NOT NULL
);

CREATE TABLE Cliente
(
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    telefone VARCHAR(13) NOT NULL
);

CREATE TABLE fornece
(
    id_fornecedor INT,
    id_produto INT,
    PRIMARY KEY(id_fornecedor, id_produto)

);

CREATE TABLE Item_Venda
(
    id_venda INT,
    id_produto INT,
    preco_unitario NUMERIC(10, 2) NOT NULL,
    subtotal NUMERIC(10, 2) NOT NULL,
    desconto NUMERIC(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY(id_venda, id_produto)
);

ALTER TABLE Produto ADD FOREIGN KEY(id_categoria) REFERENCES Categoria (id_categoria);
ALTER TABLE Venda ADD FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente);
ALTER TABLE fornece ADD FOREIGN KEY(id_fornecedor) REFERENCES Fornecedor (id_fornecedor);
ALTER TABLE fornece ADD FOREIGN KEY(id_produto) REFERENCES Produto (id_produto);
ALTER TABLE Item_Venda ADD FOREIGN KEY(id_venda) REFERENCES Venda (id_venda);
ALTER TABLE Item_Venda ADD FOREIGN KEY(id_produto) REFERENCES Produto (id_produto);