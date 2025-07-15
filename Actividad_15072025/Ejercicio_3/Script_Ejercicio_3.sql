/**
3- Libreria:

En una libreria, tienes tabla autores, tabla libros y una tercera que sea datos del autor, o categoria, o editoriales. No hace falta hacer una de pedidos.

(son tablas de uno a muchos, o de uno a uno, pero no hay de mucho a muchos)

Genera visualmente o mediante código estas tablas. Con al menos tres de ellas, relaciónalas con diferentes tipos de joins y observa los resultados.
**/

CREATE DATABASE libreria;

CREATE TABLE `libreria`.`autores` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `autor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE `libreria`.`libros` (
  `isbn` VARCHAR(30) NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `edicion_anyo` INT(4) NULL,
  PRIMARY KEY (`isbn`));
  
ALTER TABLE `libreria`.`libros` 
ADD COLUMN `id_editorial` INT(5) NULL AFTER `edicion_anyo`,
ADD COLUMN `id_autor` INT(11) NULL AFTER `id_editorial`;

-- -- --

CREATE TABLE `libreria`.`editoriales` (
  `id_editorial` INT(11) NOT NULL,
  `editorial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_editorial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

ALTER TABLE `libreria`.`editoriales` 
CHANGE COLUMN `id_editorial` `id_editorial` INT(11) NOT NULL AUTO_INCREMENT ;

-- -- --

ALTER TABLE `libreria`.`libros` 
ADD INDEX `FK_EDITORIAL_LIBRO_idx` (`id_editorial` ASC) ,
ADD INDEX `FK_AUTOR_LIBRO_idx` (`id_autor` ASC) ;
;

ALTER TABLE `libreria`.`libros` 
ADD CONSTRAINT `FK_EDITORIAL_LIBRO`
  FOREIGN KEY (`id_editorial`)
  REFERENCES `libreria`.`editoriales` (`id_editorial`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_AUTOR_LIBRO`
  FOREIGN KEY (`id_autor`)
  REFERENCES `libreria`.`autores` (`id_autor`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;  
 
-- -- --

-- introducir datos
  
-- autores
INSERT INTO `libreria`.`autores` (`id_autor`, `autor`) VALUES ('1', 'Eduardo Pérez Cuadrado');
INSERT INTO `libreria`.`autores` (`id_autor`, `autor`) VALUES ('2', 'Jara Pons Cerdà');
INSERT INTO `libreria`.`autores` (`id_autor`, `autor`) VALUES ('3', 'Cristina Sostres Llamas');
INSERT INTO `libreria`.`autores` (`id_autor`, `autor`) VALUES ('4', 'Cristobal Andrade Benavente');
INSERT INTO `libreria`.`autores` (`id_autor`, `autor`) VALUES ('5', 'Vicenç Vives');

-- editoriales
INSERT INTO `libreria`.`editoriales` (`id_editorial`, `editorial`) VALUES ('1', 'ANAYA');
INSERT INTO `libreria`.`editoriales` (`id_editorial`, `editorial`) VALUES ('2', 'SANTILLANA');
INSERT INTO `libreria`.`editoriales` (`id_editorial`, `editorial`) VALUES ('3', 'TEIDE');
INSERT INTO `libreria`.`editoriales` (`id_editorial`, `editorial`) VALUES ('4', 'GRUPO PLANETA');
INSERT INTO `libreria`.`editoriales` (`editorial`) VALUES ('ALFAGUARA');  -- PUSO 0
INSERT INTO `libreria`.`editoriales` (`id_editorial`, `editorial`) VALUES ('5', 'EDELVIVES');

-- libros
INSERT INTO `libreria`.`libros` (`isbn`, `titulo`, `edicion_anyo`, `id_editorial`, `id_autor`) VALUES 
('9788411489720', 'Matemáticas Discretas Ed. 2ª', '2012', '5', null);

INSERT INTO `libreria`.`libros` (`isbn`, `titulo`, `edicion_anyo`, `id_editorial`, `id_autor`) VALUES 
('9788410489776', 'Charlie i la fàbrica de xocolata', '2018', '2', 5);
INSERT INTO `libreria`.`libros` (`isbn`, `titulo`, `edicion_anyo`, `id_editorial`, `id_autor`) VALUES 
('9788466388542', 'El instituto (edición serie)', '2001', null,  null);
INSERT INTO `libreria`.`libros` (`isbn`, `titulo`, `edicion_anyo`, `id_editorial`, `id_autor`) VALUES 
('9788410190184', 'La vuelta al mundo en 80 días', '2005', '2', 4);
INSERT INTO `libreria`.`libros` (`isbn`, `titulo`, `edicion_anyo`, `id_editorial`, `id_autor`) VALUES 
('9788408305910', 'Misterio en el barrio gótico', '2012', '5', 1);
INSERT INTO `libreria`.`libros` (`isbn`, `titulo`, `edicion_anyo`, `id_editorial`, `id_autor`) VALUES 
('9788414339961', 'April eye y los hermanos manos 4.', '2023', null, 3 );
INSERT INTO `libreria`.`libros` (`isbn`, `titulo`, `edicion_anyo`, `id_editorial`, `id_autor`) VALUES 
('9788414061824', 'Malada madrina : un deseo con trampa', '2015', '5', 4);


-- Con al menos tres de ellas, relaciónalas con diferentes tipos de joins y observa los resultados.

use libreria;

select a.isbn, a.titulo, b.editorial, c.autor
from libros a
right join editoriales b on b.id_editorial = a.id_editorial -- así muestra todas las editoriales si se vinculan con libros
-- inner join autores c on c.id_autor = a.id_autor  -- mostrará los libros que se relacionan con un autor
-- left join autores c on c.id_autor = a.id_autor  -- mostrará todas las editoriales, tengan libro relacionado o no, así como que el libro tenga autor o no
right join autores c on c.id_autor = a.id_autor  -- mostrará los libros que se vinculan a una editorial, así como los autores que no tienen relación con un libro 
order by 3
;



