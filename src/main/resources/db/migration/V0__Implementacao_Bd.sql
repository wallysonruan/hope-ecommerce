CREATE TABLE `produtos` ( 
   `id` INT NOT NULL AUTO_INCREMENT,
   `nome` VARCHAR (150) NOT NULL,
   `estoque` INT NOT NULL,
   `preco` FLOAT NOT NULL,
   `doacao` FLOAT NOT NULL,
    PRIMARY KEY (
   `id`
    )
);
CREATE TABLE `clientes` ( 
    `id` INT NOT NULL AUTO_INCREMENT,
   `cpf` VARCHAR (150) NOT NULL,
   `nome` VARCHAR (150) NOT NULL,
   `email` VARCHAR (150) NOT NULL,
   `telefone` VARCHAR (150) NOT NULL,
    PRIMARY KEY (
   `id`
    )
);
CREATE TABLE `ongs` ( 
   `id` INT NOT NULL AUTO_INCREMENT,
   `cnpj` VARCHAR (150) NOT NULL,
   `nome` VARCHAR (150) NOT NULL,
   `email` VARCHAR (150) NOT NULL,
    PRIMARY KEY (
   `id`
    )
);
CREATE TABLE `pedidos` ( 
   `id` INT NOT NULL AUTO_INCREMENT,
   `clientes_id` INT NOT NULL,
   `ongs_id` INT NOT NULL,
   `data` DATE NOT NULL,
   `forma_pagamento` VARCHAR (150) NOT NULL,
   `valor_total` FLOAT NOT NULL,
   `valor_doacao` FLOAT NOT NULL,
    PRIMARY KEY (
   `id`
    )
);
CREATE TABLE `inventario_pedidos_produtos` ( 
   `produtos_id` INT NOT NULL,
   `pedidos_id` INT NOT NULL,
   `quantidade` INT NOT NULL
);
ALTER TABLE `pedidos` 
  ADD CONSTRAINT `clientes-pedidos`
  FOREIGN KEY ( 
   `clientes_id`
)   REFERENCES `clientes`( 
   `id`
) ;


ALTER TABLE `pedidos` 
  ADD CONSTRAINT `ongs-pedidos`
  FOREIGN KEY ( 
   `ongs_id`
)   REFERENCES `ongs`( 
   `id`
) ;


ALTER TABLE `inventario_pedidos_produtos` 
  ADD CONSTRAINT `produtos-inventario_pedidos_produtos`
  FOREIGN KEY ( 
   `produtos_id`
)   REFERENCES `produtos`( 
   `id`
) ;


ALTER TABLE `inventario_pedidos_produtos` 
  ADD CONSTRAINT `pedidos-inventario_pedidos_produtos`
  FOREIGN KEY ( 
   `pedidos_id`
)   REFERENCES `pedidos`( 
   `id`
) ;