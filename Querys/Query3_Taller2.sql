--AUTHOR: C.10 (DE.ZAMBRANO,AF.RINCON) PTO 3
WITH T5 AS( SELECT BEBEDORES.nombre,BEBEDORES.id AS id_bebedor, BEBEDORES.ciudad,BARES.id AS id_bar, BARES.nombre AS nombre_bar,  BARES.ciudad AS ciudad_bar, FRECUENTAN.fecha_ultima_visita
FROM PARRANDEROS.frecuentan, PARRANDEROS.bebedores, PARRANDEROS.bares, PARRANDEROS.gustan, PARRANDEROS.bebidas 
WHERE frecuentan.id_bebedor = bebedores.id AND frecuentan.id_bar = BARES.id 
ORDER BY FRECUENTAN.fecha_ultima_visita DESC)

SELECT *
FROM T5