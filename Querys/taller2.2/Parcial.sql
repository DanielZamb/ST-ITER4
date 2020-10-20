create table PARTIDO (
    cod_equipo1 number,
    cod_equipo2 number,
    fecha date,
    marcador varchar(10) not null,
    constraint pk_partido primary key (cod_equipo1,cod_equipo2,fecha)
)

alter table partido
add constraint fk_codEquipo1 
foreign key (cod_equipo1) references equipo(cod_equipo)
enable;

alter table partido
add constraint fk_codEquipo2 
foreign key (cod_equipo2) references equipo(cod_equipo)
enable;

alter table partido
add constraint ck_fecha 
check fecha like ('%%/%%/2020')
enable;

S,B,BEBIDAS


SELECT parranderos.bares.nombre,count(t1.id)
FROM parranderos.sirven, parranderos.bares, 
    (SELECT parranderos.bebidas.id
     FROM PARRANDEROS.SIRVEN, PARRANDERSO.BEBIDAS, 
     WHERE sirven.id_bebida = bebidas.id and bebidas.grado_alcohol < 10) t1
where sirven.id_bar = bares.id and t1.id = sirven.id_bebidas and bares.nombre like 'Medell%n' 
group by parranderos.bares.nombre
having count(t1.id) > 20
order by count(t1.id) DESC;

S,G,BEBEDORES,BEBIDAS


select parranderos.bebidas.nombre,parranderos.bebidas.id, count(parranderos.sirven.id_bar)
FROM PARRANDEROS.SIRVEN,PARRANDEROS.BEBIDAS
WHERE sirven.id_bebida = bebidas.id 
group by parranderos.bebidas.nombre,parranderos.bebidas.id
having count(parranderos.sirven.id_bar) > 10

select t2.nombre,count(parranderos.gustan.id_bebedor)
from parranderos.gustan,parranderos.bebedores, (
        select parranderos.bebidas.nombre,parranderos.bebidas.id, count(parranderos.sirven.id_bar)
        FROM PARRANDEROS.SIRVEN,PARRANDEROS.BEBIDAS
        WHERE sirven.id_bebida = bebidas.id 
        group by parranderos.bebidas.nombre,parranderos.bebidas.id
        having count(parranderos.sirven.id_bar) > 10
        )t2
where gustan.id_bebida = t2.id 
group by t2.nombre
having count (parranderos.gustan.id_bebedor) > 10
order by t2.nombre;