/**
2- Combinación de JOINS:

Respecto a consultas anteriores, prueba a realizar diferentes combinaciones de JOIN, en particular de INNER JOIN y LEFT JOIN. Qué ocurre? 
En qué casos obtienes los resultados esperados y en qué no?

**/

use podcasts;

 -- mostrar información sobre los podcasts descargados y ordenados por su identificador, usuario, fecha descarga, ... etc.
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


-- voy a utilizar JOINS con la consulta anterior

 select -- a.id_usuario, a.nombre,  
        -- c.id_podcast, e.podcast, 
        e.autores,
       GROUP_CONCAT(DISTINCT a.nombre SEPARATOR ', ') AS usuarios,
       GROUP_CONCAT(DISTINCT c.id_podcast SEPARATOR ' / ') AS podcasts
from usuarios a
 inner join usuarios_has_descargas b on b.ud_id_usuario = a.id_usuario
 left join descargas c on c.id_descarga = b.ud_id_descarga  and c.id_usuario = b.ud_id_usuario
 inner join descargas_has_podcasts d on d.dp_id_descarga = c.id_descarga and d.dp_id_podcast = c.id_podcast
 right join podcasts e on e.id_podcast = d.dp_id_podcast
GROUP BY e.autores
order by c.id_podcast, a.id_usuario
;


 select -- a.id_usuario, a.nombre,  
        -- c.id_podcast, e.podcast, 
        e.autores,
       GROUP_CONCAT(DISTINCT a.nombre SEPARATOR ', ') AS usuarios,
       GROUP_CONCAT(DISTINCT c.id_podcast SEPARATOR ' / ') AS podcasts
from usuarios a
 inner join usuarios_has_descargas b on b.ud_id_usuario = a.id_usuario
 right join descargas c on c.id_descarga = b.ud_id_descarga  and c.id_usuario = b.ud_id_usuario
 inner join descargas_has_podcasts d on d.dp_id_descarga = c.id_descarga and d.dp_id_podcast = c.id_podcast
 right join podcasts e on e.id_podcast = d.dp_id_podcast
GROUP BY e.autores
order by c.id_podcast, a.id_usuario
;

