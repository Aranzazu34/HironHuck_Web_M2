-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbLibreria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbLibreria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbLibreria` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `dbLibreria` ;

-- -----------------------------------------------------
-- Table `dbLibreria`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbLibreria`.`clientes` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbLibreria`.`libros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbLibreria`.`libros` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `autor` VARCHAR(45) NULL,
  `anio_publicacion` INT NULL,
  `id_cliente` INT NULL,
  PRIMARY KEY (`id_libro`),
  INDEX `fk_libros_clientes_idx` (`id_cliente` ASC) ,
  CONSTRAINT `fk_libros_clientes`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `dbLibreria`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
