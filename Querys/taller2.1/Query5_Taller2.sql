WITH tbl AS 
(
SELECT TIPO_BEBIDA.nombre, BEBEDORES.ciudad, COUNT(*) AS BEBEDORES_QUE_LA_TOMAN
FROM PARRANDEROS.gustan, PARRANDEROS.tipo_bebida, PARRANDEROS.bebidas, PARRANDEROS.bebedores
WHERE gustan.id_bebida = bebidas.id AND bebidas.tipo = tipo_bebida.id AND gustan.id_bebedor = bebedores.id
GROUP BY TIPO_BEBIDA.nombre,BEBEDORES.ciudad
)

SELECT t.ciudad, t.nombre, t.BEBEDORES_QUE_LA_TOMAN
FROM (
        (
            SELECT t1.nombre, t1.ciudad, t1.BEBEDORES_QUE_LA_TOMAN FROM tbl t1 
            INNER JOIN
            ( --ciclo que itera sobre la tabla y saca top 3 encontrando al 3er elemento del top
                SELECT t2.nombre, t2.ciudad, t2.BEBEDORES_QUE_LA_TOMAN
                FROM tbl t2
                WHERE 2=( 
                    SELECT COUNT(DISTINCT(t3.BEBEDORES_QUE_LA_TOMAN))
                    FROM tbl t3 
                    WHERE t3.BEBEDORES_QUE_LA_TOMAN>t2.BEBEDORES_QUE_LA_TOMAN AND t2.ciudad=t3.ciudad
                )
            )t4
            ON t1.ciudad=t4.ciudad
            WHERE t1.BEBEDORES_QUE_LA_TOMAN>=t4.BEBEDORES_QUE_LA_TOMAN
        )
    UNION ALL
        ( --parte que une las ciudades con menos de 3 valores distintos para BEBEDORES_QUE_LA_TOMAN 
        SELECT t5.nombre,t5.ciudad, t5.BEBEDORES_QUE_LA_TOMAN FROM tbl t5 
        WHERE t5.ciudad IN (SELECT t6.ciudad
        FROM tbl t6
        GROUP BY t6.ciudad HAVING COUNT(1)<3)
        )
)t
ORDER BY t.ciudad ASC,t.BEBEDORES_QUE_LA_TOMAN DESC