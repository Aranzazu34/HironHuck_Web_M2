/**
1- GROUP_CONCAT()

Selecciona algunas de tus consultas anteriores con JOINS (o sin joins) y prueba  agrupar resultados con GROUP_CONCAT() y GROUP BY()

Recuerda que es posible cambiar el SEPARATOR por defecto por otro que tú quieras.

Y que puedes hacer más de un GROUP_CONCAT a  la vez. Ejemplo:

GROUP_CONCAT(DISTINCT a.titulo SEPARATOR ', ') AS articulos,
GROUP_CONCAT(DISTINCT com.texto SEPARATOR '  ·  ') AS comentarios
**/

-- con GROUP_CONCAT y GROUP BY se pueden mostrar las asignaturas de cada alumno, una fila por alumno

use comics;

select a.id_autor, a.nombre autor, a.apellido, a.id_pais, b.pais,
       c.id_personaje, c.nombre personaje, c.especie, c.id_autor,
       GROUP_CONCAT(DISTINCT c.nombre SEPARATOR ', ') AS personajes,
       GROUP_CONCAT(DISTINCT a.nombre SEPARATOR '  ·  ') AS autores
from autores a
right join paises b on a.id_pais = b.id_pais
left join personajes_comics c on c.id_autor = a.id_autor
GROUP BY c.id_personaje, a.id_autor
;



use toyota;

    SELECT  b.id_coche, a.tipo, a.plazas, c.id_concesionario, c.concesionario, c.provincia,
           /*GROUP_CONCAT(DISTINCT a.tipo SEPARATOR ', ') AS tipos,*/
           GROUP_CONCAT(DISTINCT a.plazas SEPARATOR '  ·  ') AS num_plazas
    FROM toyota.furgonetas a
    inner join coches b on b.modelo = a.tipo
    inner join concesionarios c on c.id_concesionario = b.id_concesionario
    GROUP BY c.id_concesionario, c.provincia
    ;
    
    
    SELECT  b.id_coche, a.tipo, a.plazas, c.id_concesionario, c.concesionario, c.provincia,
           GROUP_CONCAT(DISTINCT a.tipo SEPARATOR ', ') AS tipos,
           GROUP_CONCAT(DISTINCT a.plazas SEPARATOR '  ·  ') AS num_plazas
    FROM toyota.furgonetas a
    inner join coches b on b.modelo = a.tipo
    right join concesionarios c on c.id_concesionario = b.id_concesionario
    GROUP BY c.id_concesionario
    ;
    
    SELECT  b.id_coche, a.tipo, a.plazas, c.id_concesionario, c.concesionario, c.provincia,
		   GROUP_CONCAT(DISTINCT c.provincia SEPARATOR ', ') AS provincias,
           GROUP_CONCAT(DISTINCT a.tipo SEPARATOR ', ') AS tipos,
           GROUP_CONCAT(DISTINCT a.plazas SEPARATOR '  ·  ') AS num_plazas
    FROM toyota.furgonetas a
    inner join coches b on b.modelo = a.tipo
    left join concesionarios c on c.id_concesionario = b.id_concesionario
    GROUP BY c.id_concesionario
    ;
    
    
    SELECT  b.id_coche, a.tipo, a.plazas, c.id_concesionario, c.concesionario, c.provincia,
           GROUP_CONCAT(DISTINCT a.tipo SEPARATOR ', ') AS tipos,
           GROUP_CONCAT(DISTINCT c.id_concesionario SEPARATOR '/') AS codigo_concesionarios
    FROM toyota.furgonetas a
    right join coches b on b.modelo = a.tipo
    right join concesionarios c on c.id_concesionario = b.id_concesionario
    GROUP BY c.concesionario
    ;