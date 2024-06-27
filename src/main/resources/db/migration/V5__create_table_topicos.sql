CREATE TABLE topicos(
   id BIGINT NOT NULL AUTO_INCREMENT,
   titulo VARCHAR(150) NOT NULL,
   mensaje VARCHAR(200) NOT NULL,
   fecha_creacion DATETIME NOT NULL,
   status char(1) NOT NULL,
   usuario_id BIGINT NOT NULL,
   curso_id BIGINT NOT NULL,
   PRIMARY KEY(id)
);