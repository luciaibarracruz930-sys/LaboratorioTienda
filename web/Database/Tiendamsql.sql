create database tienda ;

Use  tienda;

create table productos  (
  ID int Auto_increment primary key,
  Name varchar(255) NOT NULL,
  Precio Decimal(10,2) NOT NULL,
  Stock int NOT NULL
  );
  

INSERT INTO productos (Name, Precio, Stock)
 Values 
 ('Rubor' ,15000,10),
 ('Base Dior ',50000,5),
 ('Lip Glos',9000,8),
 ('Encrespador',7000,4),
 ('Polvos Compactos',12000,3);
 
 create table usuarios  (
  ID int Auto_increment primary key,
  usuario varchar(100) NOT NULL,
  password varchar(100) NOT NULL
  );
 
 insert Into usuarios(usuario,password)
 values ('admin', '1234');
 
 SELECT * FROM productos;
 select * from usuarios;