use podcasts;

ALTER TABLE DESCARGAS MODIFY ( FECHA_DESCARGA TIMESTAMP() ); 



--
insert usuarios_has_descargas
        ( select id_usuario, id_descarga
               from descargas
		);
        

-- 
insert descargas_has_podcasts 
        ( select id_descarga, id_podcast
               from descargas
		);

22:25:17	insert descargas_has_podcasts -- ( dp_id_descarga, dp_id_podcast )          
( select id_descarga, id_podcast                from descargas   )	
rror Code: 1452. Cannot add or update a child row: a foreign key constraint fails 
(`podcasts`.`descargas_has_podcasts`, CONSTRAINT `fk_descargas_has_podcasts_podcasts1` FOREIGN KEY (`dp_id_podcast`) REFERENCES `podcasts` (`id_podcast`) 
 DELETE NO ACTION ON UPDATE NO ACTION)	0.000 sec
 
 
 
 -- queries
 
 -- mostrar información sobre los podcasts descargados y ordenador por su identificador, usuario, fecha descarga, ... etc.
 select a.id_usuario, a.nombre, 
	   c.id_descarga, c.fecha_descarga, c.id_podcast, 
       e.podcast, e.autores, e.fecha_creacion, e.duracion_minutos
from usuarios a, usuarios_has_descargas b, descargas c, descargas_has_podcasts d,  podcasts e
where b.ud_id_usuario = a.id_usuario
  and c.id_descarga = b.ud_id_descarga  
  and c.id_usuario = b.ud_id_usuario
  and d.dp_id_descarga = c.id_descarga
  and d.dp_id_podcast = c.id_podcast
  and e.id_podcast = d.dp_id_podcast
order by c.id_podcast, a.id_usuario, c.fecha_descarga, e.fecha_creacion, e.duracion_minutos  
;


-- contador de descargar de cada podcast

select c.id_podcast, e.podcast, count(c.id_podcast) veces_descargado
from  descargas c, descargas_has_podcasts d,  podcasts e
where d.dp_id_descarga = c.id_descarga
  and d.dp_id_podcast = c.id_podcast
  and e.id_podcast = d.dp_id_podcast
group by c.id_podcast, e.podcast 
order by 1
;


-- usuario/s con más descargas

-- NO FUNCIONA (INICIAL)

SELECT u.nombre, t.total_descargas
FROM (  select a.id_usuario, count(b.ud_id_descarga) total_descargas
		from usuarios a, usuarios_has_descargas b
		where b.ud_id_usuario = a.id_usuario
		group by a.id_usuario
     ) t,
    (
	 SELECT MAX(total_descargas) AS max_descargas
     FROM (select a.id_usuario, count(b.ud_id_descarga) total_descargas
		   from usuarios a, usuarios_has_descargas b
		   where b.ud_id_usuario = a.id_usuario
		   group by a.id_usuario)
    ) m,
    usuarios u
where t.total_descargas = m.max_descargas
  and u.id_usuario = t.id_usuario
;



--  FUNCIONA
WITH totales AS (
        select a.id_usuario, count(b.ud_id_descarga) total_descargas
		from usuarios a, usuarios_has_descargas b
		where b.ud_id_usuario = a.id_usuario
		group by a.id_usuario
),
maximo AS (
  SELECT MAX(total_descargas) AS max_descargas
  FROM totales
)
SELECT
  u.nombre,
  t.total_descargas
FROM totales t
JOIN maximo m
  ON t.total_descargas = m.max_descargas
JOIN usuarios u
  ON u.id_usuario = t.id_usuario;
  
  

-- en el ERR modelo Diagram2, es muy redundante lo del id_usuario. Quise realizar relaciones N .. M entre usuarios, descargas y podcasts.
  




        