CREATE SEQUENCE aforo_sequence; 

--tablas 
CREATE TABLE a_tipo_visitante 
  ( 
     id             NUMBER, 
     tipo_visitante VARCHAR(255) NOT NULL, 
     horario        VARCHAR(30) NOT NULL, 
     CONSTRAINT a_tipo_visitante_pk PRIMARY KEY(id) 
  ); 

CREATE TABLE a_tipo_lugar 
  ( 
     id         NUMBER, 
     tipo_lugar VARCHAR(255) NOT NULL, 
     cons_aforo VARCHAR(30) NOT NULL, 
     CONSTRAINT a_tipo_lugar_pk PRIMARY KEY(id) 
  ); 

--ALTER TABLE a_tipo_lugar 
--ADD CONSTRAINT ck_cons_aforo 
--CHECK(cons_aforo>=0) 
--ENABLE; 

CREATE TABLE a_espacio 
  ( 
     id                 NUMBER, 
     capacidad_original NUMBER NOT NULL, 
     hora_apertura      VARCHAR(10) NOT NULL, 
     hora_cierre        VARCHAR(10) NULL, 
     descripcion        VARCHAR2(255 byte), 
     tipo_lugar         NUMBER, 
     CONSTRAINT a_espacio_pk PRIMARY KEY (id) 
  ); 

ALTER TABLE a_espacio 
ADD CONSTRAINT fk_tipo_lugar 
FOREIGN KEY (tipo_lugar) 
REFERENCES a_tipo_lugar(ID) 
ENABLE; 

ALTER TABLE a_espacio 
ADD CONSTRAINT ck_capacidad 
CHECK (capacidad_original >=0) 
ENABLE; 

CREATE TABLE a_centro_comercial 
  ( 
     id        NUMBER, 
     ciudad    VARCHAR2(255 byte) NOT NULL, 
     direccion VARCHAR2(255 byte) NOT NULL, 
     CONSTRAINT a_centrocomercial_pk PRIMARY KEY (id) 
  ); 

ALTER TABLE a_centro_comercial 
ADD CONSTRAINT fk_cc_espacio 
FOREIGN KEY (id) 
REFERENCES a_espacio(id) ENABLE; 

CREATE TABLE a_establecimiento 
  ( 
     id      NUMBER, 
     area    NUMBER NOT NULL, 
     nombre  VARCHAR2(255 byte), 
     cerrado CHAR(1), 
     id_cc   NUMBER, 
     CONSTRAINT a_establecimiento_pk PRIMARY KEY (id) 
  ); 

ALTER TABLE a_establecimiento 
ADD CONSTRAINT fk_establecimiento_espacio 
FOREIGN KEY (id) 
REFERENCES a_espacio(id) ENABLE; 

ALTER TABLE a_establecimiento 
ADD CONSTRAINT ck_area 
CHECK (area >=0)
ENABLE; 

ALTER TABLE a_establecimiento 
ADD CONSTRAINT ck_cerrado 
CHECK (cerrado IN ('1', '0')) 
ENABLE; 

ALTER TABLE a_establecimiento 
ADD CONSTRAINT fk_establecimiento_cc 
FOREIGN KEY(id_cc) 
REFERENCES a_centro_comercial(id)
ENABLE; 

CREATE TABLE a_visitante 
  ( 
     id                  NUMBER, 
     tipo_identificacion VARCHAR(10) NOT NULL, 
     nombre              VARCHAR2(255 byte) NOT NULL, 
     correo              VARCHAR2(255 byte), 
     telefono            VARCHAR(255) NOT NULL, 
     nombre_contacto     VARCHAR2(255 byte) NOT NULL, 
     telefono_contacto   VARCHAR(255), 
     tipo                NUMBER, 
     CONSTRAINT a_visitante_pk PRIMARY KEY (id) 
  ); 

ALTER TABLE a_visitante 
ADD CONSTRAINT fk_tipo_visitante 
FOREIGN KEY(tipo) 
REFERENCES a_tipo_visitante(id) ENABLE; 

ALTER TABLE a_visitante 
ADD CONSTRAINT ck_telefono 
CHECK(telefono >=0) 
ENABLE; 

ALTER TABLE a_visitante 
ADD CONSTRAINT ck_telefonocontacto 
CHECK(telefono_contacto >=0) 
ENABLE; 

CREATE TABLE a_lector_carnet 
  ( 
     id         NUMBER, 
     id_espacio NUMBER, 
     CONSTRAINT a_lector_carnet_pk PRIMARY KEY (id) 
  ); 

ALTER TABLE a_lector_carnet 
ADD CONSTRAINT fk_lector_espacio 
FOREIGN KEY (id_espacio) 
REFERENCES a_espacio(id) ENABLE; 

CREATE TABLE a_visitas 
  ( 
     id_lector_carnet NUMBER, 
     id_visitante     NUMBER, 
     hora_ingreso     VARCHAR(10) NOT NULL, 
     hora_salida      VARCHAR(10) NOT NULL, 
     CONSTRAINT a_visitas_pk PRIMARY KEY (id_lector_carnet, id_visitante) 
  ); 

ALTER TABLE a_visitas 
  ADD CONSTRAINT fk_lector_carnet 
  FOREIGN KEY (id_lector_carnet) 
  REFERENCES a_lector_carnet(id) ENABLE; 

ALTER TABLE a_visitas 
  ADD CONSTRAINT fk_visitante 
  FOREIGN KEY (id_visitante) 
  REFERENCES a_visitante(id) ENABLE; 

CREATE TABLE a_aforo_maximo 
  ( 
     tipo_espacio VARCHAR(20), 
     aforo_maximo NUMBER NOT NULL,
     id_espacio   NUMBER, 
     CONSTRAINT a_aforomaximo_pk PRIMARY KEY (tipo_espacio) 
  ); 

ALTER TABLE a_aforo_maximo 
ADD CONSTRAINT ck_aforo_maximo 
CHECK (aforo_maximo >= 0) 
ENABLE; 

ALTER TABLE a_aforo_maximo 
ADD CONSTRAINT fk_aforo_maximo_espacio 
FOREIGN KEY (id_espacio) 
REFERENCES a_espacio(id) ENABLE; 

CREATE TABLE a_aforo_actual 
  ( 
     num_visitantes NUMBER NOT NULL, 
     hora_actual    VARCHAR(20), 
     id_espacio     NUMBER, 
     CONSTRAINT a_aforoactual_pk PRIMARY KEY (num_visitantes, id_espacio) 
  ); 

ALTER TABLE a_aforo_actual 
ADD CONSTRAINT ck_visitantes 
CHECK (num_visitantes >=0) 
ENABLE; 

ALTER TABLE a_aforo_actual 
ADD CONSTRAINT fk_aforo_actual_espacio 
FOREIGN KEY (id_espacio)
REFERENCES a_espacio(id) ENABLE; 
COMMIT; 


