use toyota;

-- qué coches tiene cada concesionario.

select concat(a.id_concesionario,' - ', a.concesionario) Concesionario, b.id_coche, b.modelo, b.color, b.num_plazas
from concesionarios a, coches b
where b.id_concesionario = a.id_concesionario
order by a.id_concesionario
;