-- 1- Crea dos tablas: productos y categorías. Inserta al menos 6 productos y al menos 3 categorías.

CREATE DATABASE comercio;

USE comercio;

CREATE TABLE `comercio`.`productos` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `producto` VARCHAR(45) NOT NULL,
  `precio_unidad` FLOAT NULL,
  PRIMARY KEY (`idproducto`));
  
  
ALTER TABLE `comercio`.`categorias` 
ADD INDEX `FK_CATE_PRODUCTO_idx` (`idproducto` ASC) ;


ALTER TABLE `comercio`.`categorias` 
ADD CONSTRAINT `FK_CATE_PRODUCTO`
  FOREIGN KEY (`idproducto`)
  REFERENCES `comercio`.`productos` (`idproducto`)
  ON DELETE CASCADE
  ON UPDATE SET NULL;


-- Una categoría contiene varios productos. ¿A partir de aquí, cómo las relacionarías? (tema libre)

-- +EXTRA: probar a ver qué ocurre con los diferentes settings de ON UPDATE y ON DELETE de la clave foranea.


-- inserts

INSERT INTO `comercio`.`productos` (`producto`, `precio_unidad`) VALUES ('Libreta 80N', '5.83');
INSERT INTO `comercio`.`productos` (`producto`, `precio_unidad`) VALUES ('Pack 10 bolis azules', '3.45');
INSERT INTO `comercio`.`productos` (`producto`, `precio_unidad`) VALUES ('Paquete Hojas D4 80gr', '8');
INSERT INTO `comercio`.`productos` (`producto`, `precio_unidad`) VALUES ('Estuche Gris Cremalleras', '9.65');
INSERT INTO `comercio`.`productos` (`producto`, `precio_unidad`) VALUES ('Mochila con refuerzo espalda', '32');


INSERT INTO `comercio`.`categorias` (`idcategoria`, `categorias`, `idproducto`) VALUES ('1', 'categoria 1', '2');
INSERT INTO `comercio`.`categorias` (`idcategoria`, `categorias`, `idproducto`) VALUES ('1', 'categoria 1', '6');
INSERT INTO `comercio`.`categorias` (`idcategoria`, `categorias`, `idproducto`) VALUES ('2', 'categoria 2', '1');
INSERT INTO `comercio`.`categorias` (`idcategoria`, `categorias`, `idproducto`) VALUES ('3', 'categoria 3', '3');
INSERT INTO `comercio`.`categorias` (`idcategoria`, `categorias`, `idproducto`) VALUES ('3', 'categoria 3', '4');
INSERT INTO `comercio`.`categorias` (`idcategoria`, `categorias`, `idproducto`) VALUES ('3', 'categoria 3', '5');




2- Relacionar las tablas de la base de datos de cómics (autor, país y personaje)

Ahora que ya conoces un poco las claves foráneas, retoma las tablas de la BD de comics y prueba a relacionarlas si es posible:

Algún autor que puedas relacionar con uno o más personajes?

Y con un país?


-- claves FK creadas:


-- esta primera la cree por script y le cambié el nombre
CREATE TABLE `autores` (
  `id_autor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `alta_registro` timestamp NULL DEFAULT current_timestamp(),
  `modificacion_registro` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_pais` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_autor`),
  UNIQUE KEY `autores_unique` (`nombre`,`apellido`,`fecha_nacimiento`),
  KEY `index_pais` (`id_pais`),
  CONSTRAINT `FK_PAISES_AUTOR` FOREIGN KEY (`id_pais`) REFERENCES `paises` (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci COMMENT='campos: id, nombre, apellido, fecha de nacimiento, alta de registro y modificación de registro';

  
CREATE TABLE `paises` (
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,
  `pais` varchar(100) NOT NULL,
  `capital` varchar(100) DEFAULT NULL,
  `pib` float DEFAULT NULL,
  PRIMARY KEY (`id_pais`,`pais`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci COMMENT='campos: id, nombre país, capital e índice de riqueza';


CREATE TABLE `personajes_comics` (
  `id_personaje` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `especie` varchar(30) DEFAULT NULL,
  `frase` varchar(150) DEFAULT NULL,
  `id_autor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_personaje`,`nombre`),
  KEY `FK_AUTORES_PERSONAJE_idx` (`id_autor`),
  CONSTRAINT `FK_AUTORES_PERSONAJE` FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id_autor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci COMMENT='campos: id, nombre, especie y frase favorita';


-- Todavía más:

-- Cómo podrías mostrar los resultados del tipo: este autor, que nació en Francia, creó este personaje?

-- (tip: implica usar un AND en el WHERE)

select concat(a.nombre, ' ', a.apellido) as autor,
	   c.pais,
       b.nombre personaje       
from autores a, personajes_comics b, paises c
where b.id_autor = a.id_autor and
      a.id_pais = c.id_pais;
	  
	  

-- Puedes probar a crear diferentes consultas y relaciones y ver qué ocurre (no te frustres, no es tan sencillo como pudiera parecer).
select *
from comics.autores
where year(fecha_nacimiento) between 1975 and 1990
;

select round(avg(pib),2) media_PIB
from comics.paises
;


-- obtener los personajes de dos autores, no he querido hacer el join a nivel de FROM. Quise probar subconsultas

SELECT a.*,
       ( select concat(nombre, ' ', apellido) from comics.autores where id_autor = a.id_autor ) Autor
FROM comics.personajes_comics a
where id_autor in ( select id_autor from comics.autores where apellido = 'Lee' or apellido = 'Oda');


