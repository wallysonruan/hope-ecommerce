CREATE SCHEMA IF NOT exists hope;

CREATE SEQUENCE produtos_seq;

CREATE TABLE produtos ( 
   id INT NOT NULL DEFAULT nextval('produtos_seq'),
   nome VARCHAR (150) NOT NULL,
   estoque INT NOT NULL,
   preco FLOAT NOT NULL,
   doacao FLOAT NOT NULL,
    PRIMARY KEY (
   id
    )
);

CREATE SEQUENCE clientes_sql;

CREATE TABLE clientes ( 
    id INT NOT NULL DEFAULT nextval('clientes_sql'),
   cpf VARCHAR (150) NOT NULL,
   nome VARCHAR (150) NOT NULL,
   email VARCHAR (150) NOT NULL,
   telefone VARCHAR (150) NOT NULL,
    PRIMARY KEY (
   id
    )
);

CREATE SEQUENCE ongs_sql;

CREATE TABLE ongs ( 
   id INT NOT null DEFAULT nextval('ongs_sql'),
   cnpj VARCHAR (150) NOT NULL,
   nome VARCHAR (150) NOT NULL,
   email VARCHAR (150) NOT NULL,
    PRIMARY KEY (
   id
    )
);

CREATE SEQUENCE pedidos_sql;

CREATE TABLE pedidos ( 
   id INT NOT NULL DEFAULT nextval('pedidos_sql'),
   cliente_id INT NOT NULL,
   ong_id INT NOT NULL,
   data DATE NOT NULL,
   forma_pagamento VARCHAR (150) NOT NULL,
   valor_total FLOAT NOT NULL,
   valor_doacao FLOAT NOT NULL,
    PRIMARY KEY (
   id
    )
);

CREATE TABLE inventario_pedidos_produtos ( 
   produto_id INT NOT NULL,
   pedido_id INT NOT NULL,
   quantidade INT NOT NULL
);
ALTER TABLE pedidos 
  ADD CONSTRAINT clientes_pedidos
  FOREIGN KEY ( 
   cliente_id
)   REFERENCES clientes( 
   id
) ;


ALTER TABLE pedidos 
  ADD CONSTRAINT ongs_pedidos
  FOREIGN KEY ( 
   ong_id
)   REFERENCES ongs( 
   id
) ;


ALTER TABLE inventario_pedidos_produtos 
  ADD CONSTRAINT produtos_inventario_pedidos_produtos
  FOREIGN KEY ( 
   produto_id
)   REFERENCES produtos( 
   id
) ;


ALTER TABLE inventario_pedidos_produtos 
  ADD CONSTRAINT pedidos_inventario_pedidos_produtos
  FOREIGN KEY ( 
   pedido_id
)   REFERENCES pedidos( 
   id
) ;