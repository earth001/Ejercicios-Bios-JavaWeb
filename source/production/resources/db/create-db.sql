-- DROP TABLE contacto IF EXISTS;

CREATE TABLE contacto (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  nombre VARCHAR(30),
  apellido VARCHAR(30),
  direccion VARCHAR(50),
  celular VARCHAR(30),
  email VARCHAR(50)
);                 