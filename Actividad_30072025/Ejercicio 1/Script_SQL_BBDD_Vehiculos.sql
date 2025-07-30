-- inserción de mecánicos

INSERT INTO `dbvehiculos`.`mecanicos` (`nombre`, `especialidad`) VALUES ('Antonio García', 'Motor, Suspensión');
INSERT INTO `dbvehiculos`.`mecanicos` (`nombre`, `especialidad`) VALUES ('Sandra Román', 'Frenos, Transmisión, Embrague');
INSERT INTO `dbvehiculos`.`mecanicos` (`nombre`, `especialidad`) VALUES ('Juan Perelló', 'Neumáticos, Aire Acondicionado, Motor');
INSERT INTO `dbvehiculos`.`mecanicos` (`nombre`, `especialidad`) VALUES ('Manuel Fernández', 'Transmisión, Frenos, Camperizar');

INSERT INTO `dbvehiculos`.`mecanicos` (`nombre`, `especialidad`) VALUES ('Alejo Sedaví', 'Tapicería, Camperizar, Suspensión');


-- inserción de vehículos

INSERT INTO `dbvehiculos`.`vehiculos` (`marca`, `modelo`, `anio_fabricacion`, `id_mecanico`) VALUES ('Renault', 'Kangoo Maxi TDi 1.9', '2001', '3');
INSERT INTO `dbvehiculos`.`vehiculos` (`marca`, `modelo`, `anio_fabricacion`, `id_mecanico`) VALUES ('Kia', 'Picanto 1.0 CVVT Basic', '2011', '2');
INSERT INTO `dbvehiculos`.`vehiculos` (`marca`, `modelo`, `anio_fabricacion`, `id_mecanico`) VALUES ('Seat', 'León 1.5 TSI ', '2024', '1');
INSERT INTO `dbvehiculos`.`vehiculos` (`marca`, `modelo`, `anio_fabricacion`, `id_mecanico`) VALUES ('Ford', 'Tourneo Courier', '2024', '2');
INSERT INTO `dbvehiculos`.`vehiculos` (`marca`, `modelo`, `anio_fabricacion`, `id_mecanico`) VALUES ('Tesla', 'Model 3', '2024', '4');
INSERT INTO `dbvehiculos`.`vehiculos` (`marca`, `modelo`, `anio_fabricacion`, `id_mecanico`) VALUES ('Toyota', 'Proace City', '2022', '2');
INSERT INTO `dbvehiculos`.`vehiculos` (`marca`, `modelo`, `anio_fabricacion`, `id_mecanico`) VALUES ('Ford', 'Puma', '2020', '3');
INSERT INTO `dbvehiculos`.`vehiculos` (`marca`, `modelo`, `anio_fabricacion`, `id_mecanico`) VALUES ('Mitsubishsi', 'Eclipse 95GS', '1995', '4');


-------------------------

use dbvehiculos;

-- ------------------------------------------
-- Realiza las siguientes consultas:
-- ------------------------------------------

-- Cuál es el vehículo más antiguo (el de menor año de fabricación)?

select *
from vehiculos
where anio_fabricacion in (  select min(anio_fabricacion) from vehiculos )
;

-- Cuántos mecánicos tienen como especialidad "motor" ?

select count(*) mecanicos_Motor
from mecanicos
where upper(especialidad) like upper('%motor%')
;

-- Cuál es el modelo del vehículo con id = 3?

select modelo
from vehiculos
where id_vehiculo = 3
;

-- Contar cuántos vehículos hay en total

select count(*) as "Total_Vehiculos"
from vehiculos
;

-- Obtener los mecánicos cuyo nombre contiene la letra "a"

select *
from mecanicos
where lower(nombre) like '%a%'
;

-- Obtener los vehículos fabricados después de 2015

select *
from vehiculos
where anio_fabricacion > 2015
;

-- JOIN: Obtener los vehículos junto con el nombre del mecánico que los repara

select v.*, m.nombre as mecanico
from vehiculos v
join mecanicos m on m.id_mecanico = v.id_mecanico
order by m.nombre, v.id_vehiculo
;


-- JOIN: Obtener los mecánicos que no tienen vehículos asignados

-- tiene que aparecer   9	Alejo Sedaví	Tapicería, Camperizar, Suspensión
SELECT m.*
FROM mecanicos m
LEFT JOIN vehiculos v ON m.id_mecanico = v.id_mecanico
WHERE v.id_vehiculo IS NULL;


-- +EXTRA:

-- Añadir la tabla propietarios_vehiculos 

CREATE TABLE `dbvehiculos`.`propietarios_vehiculos` (
  `id_propietario` INT NOT NULL AUTO_INCREMENT,
  `propietario` VARCHAR(45) NOT NULL,
  `id_vehiculo` INT NOT NULL,
  PRIMARY KEY (`id_propietario`),
  INDEX `FK_VEHICULOS_PROPIETARIO_idx` (`id_vehiculo` ASC) ,
  CONSTRAINT `FK_VEHICULOS_PROPIETARIO`
    FOREIGN KEY (`id_vehiculo`)
    REFERENCES `dbvehiculos`.`vehiculos` (`id_vehiculo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-- inserción de registros de propietarios + vehiculos

INSERT INTO `dbvehiculos`.`propietarios_vehiculos` (`propietario`, `id_vehiculo`) VALUES ('Andrés Civit', '3');
INSERT INTO `dbvehiculos`.`propietarios_vehiculos` (`propietario`, `id_vehiculo`) VALUES ('Maria Sánchez', '1');
INSERT INTO `dbvehiculos`.`propietarios_vehiculos` (`propietario`, `id_vehiculo`) VALUES ('Santiago Montes', '2');
INSERT INTO `dbvehiculos`.`propietarios_vehiculos` (`propietario`, `id_vehiculo`) VALUES ('Santiago Montes', '8');
INSERT INTO `dbvehiculos`.`propietarios_vehiculos` (`propietario`, `id_vehiculo`) VALUES ('Macarena López', '4');
INSERT INTO `dbvehiculos`.`propietarios_vehiculos` (`propietario`, `id_vehiculo`) VALUES ('Fabían Miralles', '6');
INSERT INTO `dbvehiculos`.`propietarios_vehiculos` (`propietario`, `id_vehiculo`) VALUES ('Raúl Xivert', '5');
INSERT INTO `dbvehiculos`.`propietarios_vehiculos` (`propietario`, `id_vehiculo`) VALUES ('Raúl Xivert', '7');

-- y realizar consultas a partir de ella:

-- qué coche/s tiene cada propietario
select p.propietario, v.marca, v.modelo, v.anio_fabricacion
from propietarios_vehiculos p, vehiculos v
where v.id_vehiculo = p.id_vehiculo
order by p.propietario, v.anio_fabricacion, v.marca, v.modelo 
;


--  con qué propietarios ha tratado cada mecánico

select p.propietario, m.nombre
from propietarios_vehiculos p, vehiculos v, mecanicos m
where v.id_vehiculo = p.id_vehiculo and
	  m.id_mecanico = v.id_mecanico
order by p.propietario, m.nombre
;

    