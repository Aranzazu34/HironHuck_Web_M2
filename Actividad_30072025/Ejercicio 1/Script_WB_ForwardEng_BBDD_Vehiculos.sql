-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbVehiculos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbVehiculos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbVehiculos` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `dbVehiculos` ;

-- -----------------------------------------------------
-- Table `dbVehiculos`.`mecanicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVehiculos`.`mecanicos` (
  `id_mecanico` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `especialidad` VARCHAR(200) NULL COMMENT 'especialidad (Motor, Transmisión, Frenos, Suspensión, Neumáticos, etc)',
  PRIMARY KEY (`id_mecanico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbVehiculos`.`vehiculos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVehiculos`.`vehiculos` (
  `id_vehiculo` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `anio_fabricacion` INT NULL,
  `id_mecanico` INT NOT NULL,
  PRIMARY KEY (`id_vehiculo`),
  INDEX `fk_vehiculos_mecanicos_idx` (`id_mecanico` ASC) ,
  CONSTRAINT `fk_vehiculos_mecanicos`
    FOREIGN KEY (`id_mecanico`)
    REFERENCES `dbVehiculos`.`mecanicos` (`id_mecanico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
