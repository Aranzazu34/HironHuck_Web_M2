==> 1- TABLA EMPLEADOS (1) - discoduroderoer

1. SELECT * FROM `empleados`;

2. SELECT * FROM `departamentos`;

3. Obtener los datos de los empleados con cargo ‘Secretaria’.

   SELECT * FROM `empleados` WHERE cargoE = 'Secretaria';


4. Obtener el nombre y salario de los empleados.

   SELECT `nomEmp`, `salEmp` FROM `empleados`;

5. Obtener los datos de los empleados vendedores, ordenado por nombre.

   select * from empleados where cargoE='Vendedor' Order by nomEmp;


6. Listar el nombre de los departamentos.

   select nombreDpto from departamentos;

7. Obtener el nombre y cargo de todos los empleados, ordenado por salario.

   select nomEmp, cargoE, salemp from empleados order by salemp;

8. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión.

   select salemp, comisione from empleados where codDepto = 2000 order by comisione;

9. Listar todas las comisiones.

   select distinct comisione from empleados order by comisione;


10. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una bonificación de 500.000, en orden alfabético del empleado

   select sum(salemp) + 500000 total_pagar from empleados where codDepto = 3000;


11. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.

    select * from empleados where comisionE > salEmp order by 2;


12. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.

    select * from empleados where comisionE <= (salEmp*0.30) order by 2;

13. Elabore un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo para cada empleado.

    SELECT `nomEmp` Nombre, `cargoE` Cargo FROM `empleados`;

14. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad es superior al ‘19.709.802’.

    SELECT `nDIEmp`, `salEmp`, `comisionE` FROM `empleados` WHERE nDIEmp > '19709802';

15. Muestra los empleados cuyo nombre empiece entre las letras J y Z (rango). Liste estos empleados y su cargo por orden alfabético.

    SELECT `nomEmp`, `cargoE` FROM `empleados` WHERE substr(nomEmp,1,1) BETWEEN 'J' and 'Z' order by 1;

16. Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del empleado y nombre, de aquellos empleados que tienen comisión superior a 1.000.000, ordenar el informe por el número del documento de identidad

    SELECT  `salEmp`, `comisionE`, (`salEmp` + `comisionE`) salario_total, `nDIEmp`, `nomEmp` 
    FROM `empleados` WHERE `comisionE` > 1000000 order by `nDIEmp`;


17. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión

    SELECT  `salEmp`, `comisionE`, (`salEmp` + `comisionE`) salario_total, `nDIEmp`, `nomEmp` 
    FROM `empleados` WHERE nvl(`comisionE`,0) = 0 order by `nDIEmp`;


18. Hallar los empleados cuyo nombre no contiene la cadena «MA»

    SELECT * FROM `empleados` WHERE UPPER(`nomEmp`) not like '%MA%' ORDER BY `nDIEmp`;


- sueltos: 24,25, 27, 28, 31

24. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado entre la mitad de la comisión la propia comisión.

    SELECT `nomEmp`,`salEmp`,`comisionE` FROM `empleados` WHERE `salEmp` BETWEEN (`comisionE`/2) and `comisionE`;

25. Mostrar el salario más alto de la empresa.

    SELECT max(`salEmp`) salario_maximo FROM `empleados`;

27. Mostrar el nombre del último empleado de la lista por orden alfabético.

    SELECT nomEmp ultimo_empleado FROM `empleados` order by nomEmp desc limit 1;


28. Hallar el salario más alto, el más bajo y la diferencia entre ellos.

    SELECT max(`salEmp`) salario_max, min(`salEmp`) salario_min, (max(`salEmp`) - min(`salEmp`)) diferencia_max_min  FROM `empleados`;


31. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.

    SELECT `nDIEmp`, `salEmp` FROM empleados WHERE salEmp >= (select AVG(salEmp) FROM empleados) order by codDepto;




==> 2- TABLA EMPLEADOS (2) - "SQL fácil"

EJERCICIOS cap 5:

1- Cree una consulta SQL que devuelva las personas que son altas, o bien son rubias con gafas (usar paréntesis)

SELECT *
FROM PERSONAS
WHERE ( ALTA = 'S' OR (RUBIA = 'S' AND GAFAS = 'S') )

2- Cree una consulta SQL que devuelva los empleados que son mujer y cobran más de 1300 euros
(en la tabla de empleados se guarda una 'H' en el campo SEXO para indicar que es hombre, o una 'M' para indicar que es mujer.

SELECT *
FROM EMPLEADOS
WHERE SEXO = 'M' AND SALARIO > 1300

3- De la tabla personas: usando solo expresiones (ALTA='S'), (RUBIA='S'), (GAFAS='S') combinadas con el operador NOT resuelva:
¿Quién es quién? Lleva gafas y no es alta ni rubia.

SELECT *
FROM PERSONAS
WHERE ( ALTA NOT IN ('S') ) AND ( RUBIA NOT IN ('S') ) AND ( GAFAS = 'S' )


EJERCICIOS cap 6:

1- Construya una consulta, donde necesitará establecer una condición en la claúsula WHERE, que devuelva el salario medio de los empleados que son hombres. Renombre la cabecera del resultado con un título que deje claro qué dato se está mostrando.

SELECT AVG(SALARIO) "SALARIO MEDIO HOMBRES"
FROM EMPLEADOS
WHERE SEXO = 'H'

2- Cree una consulta que devuelva en la misma fila el salario minimo y máximo de entre todos los empleados. Renombre la cabecera del resultado con un título que deje claro qué datos se está mostrando.

SELECT MIN(SALARIO) "SALARIO MÍNIMO", MAX(SALARIO) "SALARIO MÁXIMO"
FROM EMPLEADOS

3- De la tabla empleados: cree una consulta que responda a lo siguiente: ¿qué cuesta pagar a todas las mujeres en total? Renombre la cabecera del resultado con un título que deje claro qué dato se está mostrando.

SELECT SUM(SALARIO) "TOTAL PAGO MUJERES"
FROM EMPLEADOS
WHERE SEXO = 'M'