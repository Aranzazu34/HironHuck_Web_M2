/** 2- Crea tres tablas relacionadas entre ellas. Inserta algunos datos, pongamos 5 registros en cada tabla, asegurándote que hay NULLs en algún caso en cada 
       foreign key (que es la que relaciona las tablas).
       autores
       Prueba a realizar INNER JOIN, LEFT JOIN y RIGHT JOIN con estas tablas. Obtienes los resultados esperados?
**/

use comics;

UPDATE comics.autores SET ID_PAIS = null WHERE ID_AUTOR = 3;
UPDATE comics.autores SET ID_PAIS = null WHERE ID_AUTOR = 5;


UPDATE comics.personajes_comics SET id_autor = null WHERE id_personaje = 3;
UPDATE comics.personajes_comics SET id_autor = null WHERE id_personaje = 5;


-- select

select a.id_autor, a.nombre autor, a.apellido, a.id_pais, b.pais,
       c.id_personaje, c.nombre personaje, c.especie, c.id_autor
from autores a
inner join paises b on a.id_pais = b.id_pais
inner join personajes_comics c on c.id_autor = a.id_autor
;


select a.id_autor, a.nombre autor, a.apellido, a.id_pais, b.pais,
       c.id_personaje, c.nombre personaje, c.especie, c.id_autor
from autores a
left join paises b on a.id_pais = b.id_pais
left join personajes_comics c on c.id_autor = a.id_autor
;



select a.id_autor, a.nombre autor, a.apellido, a.id_pais, b.pais,
       c.id_personaje, c.nombre personaje, c.especie, c.id_autor
from autores a
right join paises b on a.id_pais = b.id_pais
right join personajes_comics c on c.id_autor = a.id_autor
;



select a.id_autor, a.nombre autor, a.apellido, a.id_pais, b.pais,
       c.id_personaje, c.nombre personaje, c.especie, c.id_autor
from autores a
left join paises b on a.id_pais = b.id_pais
right join personajes_comics c on c.id_autor = a.id_autor
;


select a.id_autor, a.nombre autor, a.apellido, a.id_pais, b.pais,
       c.id_personaje, c.nombre personaje, c.especie, c.id_autor
from autores a
right join paises b on a.id_pais = b.id_pais
left join personajes_comics c on c.id_autor = a.id_autor
;