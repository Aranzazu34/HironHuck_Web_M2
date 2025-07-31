
-- El punto 1 y 2: creados desde Workbench por EER Diagram

   -- >> archivo: dbLibreria_Aranzazu.mwb
   -- >> archivo: Script_FE_to_BBDD_Crear_LIBRERIA_Aranzazu.sql, para crear en el visual el Schema y las tablas

-- 1- (2 ptos) Crea dos tablas: LIBROS y CLIENTES 
      -- La tabla libros contiene el id, titulo, autor y año de publicación
      -- La tabla clientes contiene id, nombre y e-mail
      
      
      
-- 2- (1 pto) Relaciona ambas tablas (un cliente, muchos libros)

-- 3- Rellena datos


-- Clientes

INSERT INTO `dblibreria`.`clientes` (`nombre`, `email`)
VALUES ('Asunta Serna','asunSerna@gmail.com');

INSERT INTO `dblibreria`.`clientes` (`nombre`, `email`)
VALUES ('Gabino Diego','gabiDiego@gva.com');

INSERT INTO `dblibreria`.`clientes` (`nombre`, `email`)
VALUES ('Maribel Verdú','mariVerdu@cet.com');

INSERT INTO `dblibreria`.`clientes` (`nombre`, `email`)
VALUES ('Nadjwa','nadjwa@gmail.com');

INSERT INTO `dblibreria`.`clientes` (`nombre`, `email`)
VALUES ('Eduardo Noriega','eduNoriega@gmail.com');

INSERT INTO `dblibreria`.`clientes` (`nombre`, `email`)
VALUES ('Antonio Banderas','antBanderas@urv.com');

-- Libros: he considerado que puede haber un libro sin asignar a un cliente

INSERT INTO `dblibreria`.`libros` (`titulo`,`autor`,`anio_publicacion`,`id_cliente`)
VALUES ('El instituto (edición serie)', 'Jara Pons Cerdà','2010',2);

INSERT INTO `dblibreria`.`libros` (`titulo`,`autor`,`anio_publicacion`,`id_cliente`)
VALUES ('April eye y los hermanos manos 4.', 'Cristobal Andrade Benavente','2023',3);

INSERT INTO `dblibreria`.`libros` (`titulo`,`autor`,`anio_publicacion`,`id_cliente`)
VALUES ('Malada madrina : un deseo con trampa', 'Eduardo Pérez Cuadrado','2015',4);

INSERT INTO `dblibreria`.`libros` (`titulo`,`autor`,`anio_publicacion`,`id_cliente`)
VALUES ('Matemáticas Discretas Ed. 2ª', 'Eduardo Pérez Cuadrado','2012',null);

INSERT INTO `dblibreria`.`libros` (`titulo`,`autor`,`anio_publicacion`,`id_cliente`)
VALUES ('Charlie i la fàbrica de xocolata', 'Vicenç Vives','2005',5);

INSERT INTO `dblibreria`.`libros` (`titulo`,`autor`,`anio_publicacion`,`id_cliente`)
VALUES ('Misterio en el barrio gótico','Jara Pons Cerdà',2012,2);

INSERT INTO `dblibreria`.`libros` (`titulo`,`autor`,`anio_publicacion`,`id_cliente`)
VALUES ('La vuelta al mundo en 80 días', 'Cristina Sostres Llamas','2005',1);

INSERT INTO `dblibreria`.`libros` (`titulo`,`autor`,`anio_publicacion`,`id_cliente`)
VALUES ('21 días de revelación', 'Pascual Manrique Tirado','2008',5);


--  4- (4 ptos) Realiza las siguientes consultas:

use dblibreria;

-- 4.1- Obtener los libros publicados después de 2005

select *
from libros
where anio_publicacion > 2005
order by anio_publicacion, titulo
;

-- 4.2- Obtener los clientes cuyo nombre contiene la letra “e”

select *
from clientes
where lower(nombre) like '%e%'
order by nombre
;

--  4.3- Contar el número total de libros

select count(*) "Total Libros" from libros;

-- 4.4- ¿Cuál es el título del libro con el ID 3?

select titulo from libros where id_libro = 3;

-- 4.5- ¿Cuántos clientes tienen una dirección de correo electrónico que termina en “@gmail.com”?
 
 select count(*) from clientes where email like '%gmail.com';
 
-- 4.6- ¿Cuál es el título del libro más antiguo?

-- realizada subconsulta para obtener el menor año de publicación
select a.* 
from libros a, ( select min(anio_publicacion) menor_anio from libros ) b
where a.anio_publicacion = b.menor_anio
;


-- 4.7- JOIN:  Obtener los libros junto con los nombres de los clientes que los poseen

-- sin descartar el libro sin tener cliente relacionado
select l.titulo, c.nombre
from libros l
left join clientes c on c.id_cliente = l.id_cliente
order by l.titulo, 2
;


-- escartando el libro que no tiene cliente relacionado
select l.titulo, c.nombre
from libros l
left join clientes c on c.id_cliente = l.id_cliente
where l.id_cliente is not null
order by l.titulo, 2
;

-- 4.8- JOIN: Obtener los clientes que no tienen libros

select c.*
from clientes c
left join libros l on l.id_cliente = c.id_cliente
where l.id_cliente is null
order by c.nombre
;

-- ---------------------------------------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------------------------------------

-- Para realizar los puntos 5 y 6, primero hemos creado la conexión JDBC (https://start.spring.io/)

	-- >> archivo: SpringInitializr_creada_conexion_JDBC.png, creada la conexión desde Spring initializr.
    -- >> carpeta: Aranzazu, desde Spring se ha generado y contiene toda la configuración para hacer uso desde para 
	--             para realizar la aplicación Java y que esta interactue con la BBDD Libreria
    
    -- Al abrir la carpeta en VS Code, se revisa:
    --  - el application.properties para enlazar la BBDD Libreria 
    --  - crear una clase para realizar las consultas, inserts o updates a la BBDD y sus tablas
    --  - ...
    
    -- En el código se verán reflejados el punto 5 y 6
    
    -- NOTA: Al ejecutar la aplicación me dió error de conexión. He tenido que añadir lo siguiente en el pom.xml (me lo dejé al crear la conexión en Spring):
    
    /*
    		<dependency>
			   <groupId>com.mysql</groupId>
			   <artifactId>mysql-connector-j</artifactId>
			   <scope>runtime</scope>
		    </dependency>
	*/
    
-- 5-(1 pto) JDBC: usa tu propia plantilla JDBC o la que te pase el profesor. Realiza una consulta para ver todos 
			    -- los titulos y los autores de todos los libros desde un statement normal directo. Del tipo:
                -- ResultSet resultado1 = stat1.executeQuery(“SELECT * FROM juegos”);
-- 6- (1 pto) JDBC. Sobre esa misma plantilla, realiza un insert con un PreparedStatement para registrar una 
				 -- nueva  la en en la tabla Clientes. Veri ca que aparece el nuevo cliente en la base de datos. Del tipo: 
                 -- String insert3 = “INSERT INTO juegos(juegoname, anio) VALUES(?, ?)”;