use toyota;

-- 1.
CREATE TABLE furgonetas AS
    SELECT modelo tipo, num_plazas plazas
    FROM coches
	where modelo like 'Proace%';     

-- DROP TABLE furgonetas;

-- 2. 

CREATE VIEW vw_furgos_en_concesionarios AS
    SELECT  b.id_coche, a.tipo, a.plazas, c.concesionario, c.direccion, c.telefono, c.provincia
    FROM toyota.furgonetas a, coches b, concesionarios c
    WHERE b.modelo = a.tipo AND
          c.id_concesionario = b.id_concesionario;

-- 3.  CTE (Common Table Expressions). Usando WITH:

-- necesité añadir el identificador del concesionario para la consulta CTE
ALTER VIEW vw_furgos_en_concesionarios AS
    SELECT  b.id_coche, a.tipo, a.plazas, c.id_concesionario, c.concesionario, c.direccion, c.telefono, c.provincia
    FROM toyota.furgonetas a, coches b, concesionarios c
    WHERE b.modelo = a.tipo AND
          c.id_concesionario = b.id_concesionario;

-- coger del concesionario de Alava (5), el numero de coches que no son furgonetas, y no son de BCN (el 3)/Alava (5)
WITH tipo_turismo AS (
 SELECT * FROM coches WHERE modelo not in ( select tipo from vw_furgos_en_concesionarios )
)
SELECT COUNT(*) FROM tipo_turismo
WHERE id_concesionario not in ( 3, 5 );	


--  ídem de arriba, pero que obtenga solo los turismos de color Azul

WITH tipo_turismo AS ( SELECT * FROM coches WHERE modelo not in ( select tipo from vw_furgos_en_concesionarios ) ),
     color_azul AS ( SELECT * FROM coches WHERE color = 'Azul' )
SELECT COUNT(*) 
FROM tipo_turismo a, color_azul b
WHERE a.id_concesionario not in ( 3, 5 )
  AND b.id_coche = a.id_coche;	