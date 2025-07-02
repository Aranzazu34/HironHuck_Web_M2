-- CREATE----------------------------------------------------------------------------------------------------------

-- Crear base de datos
CREATE DATABASE Cimas;

USE Cimas;

-- Crear tabla con columnas y clave primaria
CREATE TABLE Mountains (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  altitud INT,
  pais   VARCHAR(100)  
);

-- Insertar datos
INSERT INTO Mountains (nombre, altitud, pais) VALUES ('Pica d Estats', 3143, 'España');
INSERT INTO Mountains (nombre, altitud, pais) VALUES ('Pico Veleta', 3398, 'España');
INSERT INTO Mountains (nombre, altitud, pais) VALUES ('Garmo Negro', 3066, 'España');
INSERT INTO Mountains (nombre, altitud, pais) VALUES ('Annapurna', 8091, 'Nepal');
INSERT INTO Mountains (nombre, altitud, pais) VALUES ('Marmolada', 3342, 'Italia');

-- READ -------------------------------------------------------------------------------------------------------------

-- Leer datos (SELECT)
SELECT * FROM Mountains order by 3;

-- UPDATE----------------------------------------------------------------------------------------------------------

-- Modificar estructura de la tabla

-- Agregar columna:
ALTER TABLE Mountains ADD Tipo_K VARCHAR(2);

-- Modificar tipo de columna:
ALTER TABLE Mountains MODIFY pais VARCHAR(50);

-- Renombrar tabla:
RENAME TABLE Mountains TO macizos;


-- Modificar datos (UPDATE)
UPDATE macizos SET nombre = 'Pica d''Estats' WHERE id = 1;

-- Eliminar datos (DELETE)
-- Eliminar un registro:
DELETE FROM macizos WHERE nombre = 'Pico Veleta';


select * from macizos;

-- DELETE ----------------------------------------------------------------------------------------------------------

-- Eliminar todos los registros:
DELETE FROM macizos; 

-- Eliminar tabla
DROP TABLE macizos;

-- Eliminar base de datos
DROP DATABASE Cimas;