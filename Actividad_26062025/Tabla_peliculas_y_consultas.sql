-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-06-2025 a las 21:21:30
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mysql`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id` int(7) NOT NULL,
  `titulo` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `protagonista` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `anyo` int(4) NOT NULL,
  `genero` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `recaudacion` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion`) VALUES
(1, 'El abogado del Diablo', 'Charlize Theron', 1997, 'Thriller', 3000000.00),
(2, 'Monstruo', 'Charlize Theron', 2003, 'Drama', 15000000.00),
(3, 'Mad Max: Fury Road', 'Charlize Theron', 2015, 'Acción', 0.00),
(4, 'Noviembre Dulce', 'Charlize Theron', 2001, 'Romántico/Drama', 7000000.00),
(5, 'El Club de los Poetas Muertos', 'Ethan Hawke', 1985, 'Drama', 3000000.00),
(6, 'Gatacca', 'Ethan Hawke', 1997, 'Drama/Ciencia Ficción', 8000000.00),
(7, 'La Purga', 'Ethan Hawke', 2013, 'Thriller', 18000000.00),
(8, 'Aliens el regreso', 'Sigourney Weaver', 1987, 'Ciencia Ficción/Terror', 5000000.00),
(9, 'Gorilas en la niebla', 'Sigourney Weaver', 1989, 'Biografía', 5000000.00),
(10, 'El maestro jardinero', 'Sigourney Weaver', 2022, 'Drama/Thriller', 10000000.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




/******************CONSULTAS SQL*****************************/

-- Ver solo titulo y año
SELECT `titulo`, `anyo`
FROM `peliculas` 
WHERE 1
order by 2, 1;


-- Todas las películas producidas a partir de cierto año, en orden ascendente o descendente
SELECT `id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion` 
FROM `peliculas` 
WHERE anyo >= 2004
ORDER by 4, 2;


-- Ordenar por titulo
SELECT `id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion` 
FROM `peliculas`
order by `titulo`;


-- Ver solo las pelis con recaudación menor que X
SELECT `id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion` 
FROM `peliculas` 
WHERE NVL(recaudacion,0) < 4000000;



-- Ver películas entre un año y otro de producción
SELECT `id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion` 
FROM `peliculas` 
WHERE ANYO BETWEEN 1996 AND 2006
ORDER BY ANYO;


-- Ver cuantas pelis hay en la lista
SELECT COUNT(*) FROM `peliculas`; 


-- Ver la suma de todas las recaudaciones
SELECT SUM(`recaudacion`) AS TOTAL_RECAUDACIONES FROM `peliculas`;


-- Ver la media de las recaudaciones
SELECT AVG(`recaudacion`) AS AVG_RECAUDACIONES FROM `peliculas`;



-- Acuerdate de renombrar las columnas cuando creas necesario (AS)
SELECT `id` AS ID_PELICULA, `titulo` AS PELICULA, `protagonista`, `anyo` AS "AÑO", `genero`, `recaudacion` 
FROM `peliculas` ;


-- Mostrar los títulos de las películas del género 'Acción'.
SELECT `id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion` 
FROM `peliculas`
WHERE genero like '%Acci%n%';
;


-- Listar todas las películas protagonizadas por Keanu Reeves.
SELECT `id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion` 
FROM `peliculas` 
WHERE protagonista = 'Charlize Theron'
order by anyo, genero, titulo
;


-- Mostrar las películas que recaudaron más de 100 millones.
SELECT `id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion` 
FROM `peliculas` WHERE recaudacion > 100000000;



-- Listar las películas cuyo título comienza con "El". 
SELECT * 
FROM `peliculas` 
WHERE titulo like 'El%'
;


-- Ordenar las películas por recaudación de forma descendente.
SELECT * 
FROM `peliculas` 
order by recaudacion DESC;



-- Mostrar las películas ordenadas alfabéticamente por protagonista.
SELECT * 
FROM `peliculas` 
order by protagonista, titulo
;



-- Listar los géneros de películas sin repetir (distinct)
SELECT DISTINCT genero FROM `peliculas`
WHERE 1
order by 1
;


-- Mostrar todos los protagonistas sin duplicados (distinct)
SELECT DISTINCT protagonista FROM `peliculas`
WHERE 1
order by 1
;


-- Contar cuántas películas del género drama existen.
SELECT COUNT(*)
FROM `peliculas` 
WHERE genero like '%Drama%'
;


-- Mostrar las películas que no tienen recaudación registrada.
SELECT * 
FROM `peliculas` 
WHERE recaudacion = 0
ORDER by titulo
;



-- Mostrar las películas de ciencia ficción ordenadas por año de forma descendente.
SELECT * 
FROM `peliculas` 
WHERE genero like '%Ciencia Fic%'
ORDER by anyo DESC
;



-- Mostrar las películas cuyo título contiene la letra "i" y se estrenaron después del año 2000.
SELECT * 
FROM `peliculas` 
WHERE titulo like '%i%' and anyo > 2000
ORDER by anyo DESC
;


-- Mostrar la recaudación total de las películas protagonizadas por Ethan Hawke.
SELECT `protagonista` as Actor,  SUM(`recaudacion`) as "Total Recaudado"
FROM `peliculas` 
WHERE protagonista = 'Ethan Hawke'
GROUP by protagonista
;



-- Calcular el promedio de recaudación agrupado por género de película
SELECT `genero`, AVG(`recaudacion` ) as "Promedio Recaudacion"
FROM `peliculas` 
group by genero
;







-- Agrupar por género
SELECT `id`, `titulo`, `protagonista`, `anyo`, `genero`, `recaudacion` 
FROM `peliculas` 
group by `genero`
;


-- Agrupar por género 2
SELECT `genero`, count(*)
FROM `peliculas` 
group by `genero`
;



