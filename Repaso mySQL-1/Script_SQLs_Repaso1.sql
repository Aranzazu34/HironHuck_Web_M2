--1 ---- Sobre la web sql-facil realiza las siguientes consultas:

--1.1- Intente hallar una consulta que devuelva el nombre, apellidos y 
--la fecha de nacimiento de aquellos empleados que cobren más de 1350 euros.

select NOMBRE, APELLIDOS, F_NACIMIENTO
from EMPLEADOS
where SALARIO > 1350
;


--1.2-  Cree una consulta SQL que devuelva las personas que son altas, 
--o bien son rubias con gafas.
select ID_PERSONA,	NOMBRE,	RUBIA,	ALTA,	GAFAS
from personas
where ALTA = 'S' OR ( RUBIA = 'S' AND GAFAS = 'S' )


--1.3- Cree una consulta SQL que devuelva los empleados que son mujer y 
--cobran más de 1300 euros.
SELECT ID_EMPLEADO,	NOMBRE,	APELLIDOS,	F_NACIMIENTO,	SEXO,	CARGO,	SALARIO
FROM EMPLEADOS
WHERE SEXO = 'M' AND SALARIO > 1300


--1.4- Construya una consulta, donde necesitará establecer una condición en 
--la claúsula WHERE, que devuelva el salario medio de los empleados que son 
--hombres. Renombre la cabecera del resultado con un título que deje claro 
--qué dato se está mostrando.
select avg(salario) SALARIO_MEDIO_HOMBRES
from empleados
where sexo = 'H'


--1.5- Cree una consulta que devuelva en la misma fila el salario minimo y 
--máximo de entre todos los empleados. Renombre la cabecera del resultado 
--con un título que deje claro qué datos se está mostrando.
SELECT MIN(SALARIO) SALARIO_MIN, MAX(SALARIO) SALARIO_MAX
FROM EMPLEADOS


--1.6- De la tabla empleados: cree una consulta que responda a lo siguiente: 
--¿qué cuesta pagar a todas las mujeres en total? Renombre la cabecera del 
--resultado con un título que deje claro qué dato se está mostrando.
SELECT SUM(SALARIO) TOTAL_SALARIO_MUJERES
FROM EMPLEADOS
WHERE SEXO = 'M'



--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

--2--- Sobre la web sql-practice realiza sólo el primer nivel (Easy)

SELECT
  first_name,
  last_name,
  gender
FROM patients
WHERE gender = 'M';


SELECT
  first_name,
  last_name
FROM patients
WHERE allergies IS NULL;

SELECT first_name
FROM patients
where first_name LIKE 'C%'

SELECT first_name, last_name
FROM patients
where weight between 100 AND 120

update patients SET allergies = 'NKA'
where allergies IS NULL

select first_name ||' '|| last_name full_name
from patients

select first_name, last_name, province_name
from patients p
LEFT JOIN province_names pr ON pr.province_id =  p.province_id

select count(*) num_nacidos_2010
from patients
where year(birth_date) = 2010

select first_name, last_name, max(height) max_altura
from patients

select *
from patients
where patient_id in ( 1,45,534,879,1000 )

select count(*) total_admissions
from admissions

select *
from admissions
where admission_date = discharge_date

select patient_id, count(*)
from admissions
where patient_id = 579
group by patient_id

select DISTINCT city unique_cities
from patients
where province_id = 'NS'

select first_name, last_name, birth_date
from patients
where height > 160 AND weight > 70

select first_name, last_name, allergies
from patients
where allergies IS NOT NULL 
  AND city = 'Hamilton'
  
  
