/** 1- Crea solo dos tablas, con una relación de uno a muchos (por ejemplo, un canal de TV tiene muchos programas). 
       Rellena al menos 5 ó 7 campos, y asegúrate que hay nulls en ambas partes de esa relación (en el ejemplo, seria que hubiera canales de TV sin ningún 
       programa o programas sin canal asignado). Prueba a realizar INNER JOIN, LEFT JOIN y RIGHT JOIN y compara los resultados.
**/

use television;	

select *
from canales
inner join programas on canales.id_canal = programas.id_canal
order by 1, 3
;


select *
from canales
left join programas on canales.id_canal = programas.id_canal
order by 1, 3
;



