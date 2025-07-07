-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Toyota
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Toyota
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Toyota` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `Toyota` ;

-- -----------------------------------------------------
-- Table `Toyota`.`Concesionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Toyota`.`Concesionarios` (
  `id_concesionario` INT NOT NULL AUTO_INCREMENT,
  `concesionario` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(60) NULL,
  `telefono` VARCHAR(10) NULL,
  `num_trabajadores` VARCHAR(3) NULL,
  PRIMARY KEY (`id_concesionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Toyota`.`Coches`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Toyota`.`Coches` (
  `id_coches` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(60) NOT NULL,
  `color` VARCHAR(45) NULL,
  `num_plazas` INT(3) NULL,
  `id_concesionario` INT NULL,
  PRIMARY KEY (`id_coches`),
  INDEX `FK_CONCESIONARIO_COCHE_idx` (`id_concesionario` ASC),
  CONSTRAINT `FK_CONCESIONARIO_COCHE`
    FOREIGN KEY (`id_concesionario`)
    REFERENCES `Toyota`.`Concesionarios` (`id_concesionario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
