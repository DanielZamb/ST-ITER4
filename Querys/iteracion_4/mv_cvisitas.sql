CREATE materialized VIEW cvisitas 
AS SELECT a_visitante.id           AS visitante_id, 
          a_visitante.tipo_identificacion, 
          a_visitante.temperatura, 
          a_visitante.correo, 
          a_visitante.telefono, 
          a_visitante.nombre_contacto, 
          a_visitante.telefono_contacto, 
          a_visitante.positivo, 
          a_visitante.color        AS visiatnte_color, 
          a_visitante.tipo, 
          a_visitas.id_lector_carnet, 
          a_visitas.id_visitante, 
          a_visitas.hora_ingreso, 
          a_visitas.hora_salida, 
          a_espacio.id             AS espacio_id, 
          a_espacio.capacidad_original, 
          a_espacio.hora_apertura, 
          a_espacio.hora_cierre, 
          a_espacio.descripcion, 
          a_espacio.color          AS espacio_color, 
          a_tipo_lugar.id          AS tipo_lugar_id, 
          a_tipo_lugar.tipo_lugar, 
          a_tipo_lugar.cons_aforo, 
          a_establecimiento.id     AS establecimiento_id, 
          a_establecimiento.area, 
          a_establecimiento.nombre AS establecimiento_nombre, 
          a_establecimiento.cerrado, 
          a_establecimiento.tipo_establecimiento, 
          a_establecimiento.id_cc 
   FROM   a_visitante, 
          a_visitas, 
          a_lector_carnet, 
          a_espacio, 
          a_establecimiento, 
          a_tipo_lugar 
   WHERE  a_visitante.id = a_visitas.id_visitante 
          AND a_visitas.id_lector_carnet = a_lector_carnet.id 
          AND a_lector_carnet.id_espacio = a_espacio.id 
          AND a_espacio.id = a_establecimiento.id 
          AND a_espacio.tipo_lugar = a_tipo_lugar.id; 

SELECT * 
FROM   a_visitante, 
       a_visitas, 
       a_lector_carnet, 
       a_espacio, 
       a_establecimiento, 
       a_tipo_lugar 
WHERE  a_visitante.id = a_visitas.id_visitante 
       AND a_visitas.id_lector_carnet = a_lector_carnet.id 
       AND a_lector_carnet.id_espacio = a_espacio.id 
       AND a_espacio.id = a_establecimiento.id 
       AND a_espacio.tipo_lugar = a_tipo_lugar.id 
       AND a_visitante.tipo_identificacion = 'TI' 
       AND a_visitante.temperatura BETWEEN 35.5 AND 36; 

SELECT * 
FROM   cvisitas; 

DROP materialized VIEW cvisitas; 

SELECT * 
FROM   cvisitas 
WHERE  cvisitas.tipo_identificacion = 'TI' 
       AND cvisitas.temperatura BETWEEN 35.5 AND 36; 