DROP TABLE "A_AFORO_MAXIMO" CASCADE CONSTRAINTS;
DROP TABLE "A_AFORO_ACTUAL" CASCADE CONSTRAINTS;
DROP TABLE "A_VISITAS" CASCADE CONSTRAINTS;
DROP TABLE "A_LECTOR_CARNET" CASCADE CONSTRAINTS;
DROP TABLE "A_VISITANTE" CASCADE CONSTRAINTS;
DROP TABLE "A_ESTABLECIMIENTO" CASCADE CONSTRAINTS;
DROP TABLE "A_CENTRO_COMERCIAL" CASCADE CONSTRAINTS;
DROP TABLE "A_ESPACIO" CASCADE CONSTRAINTS;
DROP TABLE "A_TIPO_LUGAR" CASCADE CONSTRAINTS;
DROP TABLE "A_TIPO_VISITANTE" CASCADE CONSTRAINTS;


--LIMPIAR BASE DE DATOS
DELETE FROM A_VISITAS;
DELETE FROM A_LECTOR_CARNET;
DELETE FROM A_VISITANTE;
DELETE FROM A_ESTABLECIMIENTO;
delete from a_centro_comercial;
Delete from a_espacio;
DELETE FROM A_TIPO_LUGAR;
DELETE FROM A_TIPO_VISITANTE;
commit;