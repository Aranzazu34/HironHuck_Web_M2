CREATE DATABASE  IF NOT EXISTS `dbvehiculos` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `dbvehiculos`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: dbvehiculos
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mecanicos`
--

DROP TABLE IF EXISTS `mecanicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanicos` (
  `id_mecanico` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `especialidad` varchar(200) DEFAULT NULL COMMENT 'especialidad (Motor, Transmisión, Frenos, Suspensión, Neumáticos, etc)',
  PRIMARY KEY (`id_mecanico`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanicos`
--

LOCK TABLES `mecanicos` WRITE;
/*!40000 ALTER TABLE `mecanicos` DISABLE KEYS */;
INSERT INTO `mecanicos` VALUES (1,'Antonio García','Motor, Suspensión'),(2,'Sandra Román','Frenos, Transmisión, Embrague'),(3,'Juan Perelló','Neumáticos, Aire Acondicionado, Motor'),(4,'Manuel Fernández','Transmisión, Frenos, Camperizar'),(9,'Alejo Sedaví','Tapicería, Camperizar, Suspensión');
/*!40000 ALTER TABLE `mecanicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietarios_vehiculos`
--

DROP TABLE IF EXISTS `propietarios_vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propietarios_vehiculos` (
  `id_propietario` int(11) NOT NULL AUTO_INCREMENT,
  `propietario` varchar(45) NOT NULL,
  `id_vehiculo` int(11) NOT NULL,
  PRIMARY KEY (`id_propietario`),
  KEY `FK_VEHICULOS_PROPIETARIO_idx` (`id_vehiculo`),
  CONSTRAINT `FK_VEHICULOS_PROPIETARIO` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`id_vehiculo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietarios_vehiculos`
--

LOCK TABLES `propietarios_vehiculos` WRITE;
/*!40000 ALTER TABLE `propietarios_vehiculos` DISABLE KEYS */;
INSERT INTO `propietarios_vehiculos` VALUES (1,'Andrés Civit',3),(2,'Maria Sánchez',1),(3,'Santiago Montes',2),(4,'Santiago Montes',8),(5,'Macarena López',4),(6,'Fabían Miralles',6),(7,'Raúl Xivert',5),(8,'Raúl Xivert',7);
/*!40000 ALTER TABLE `propietarios_vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `anio_fabricacion` int(11) DEFAULT NULL,
  `id_mecanico` int(11) NOT NULL,
  PRIMARY KEY (`id_vehiculo`),
  KEY `fk_vehiculos_mecanicos_idx` (`id_mecanico`),
  CONSTRAINT `fk_vehiculos_mecanicos` FOREIGN KEY (`id_mecanico`) REFERENCES `mecanicos` (`id_mecanico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (1,'Renault','Kangoo Maxi TDi 1.9',2001,3),(2,'Kia','Picanto 1.0 CVVT Basic',2011,2),(3,'Seat','León 1.5 TSI ',2024,1),(4,'Ford','Tourneo Courier',2024,2),(5,'Tesla','Model 3',2024,4),(6,'Toyota','Proace City',2022,2),(7,'Ford','Puma',2020,3),(8,'Mitsubishsi','Eclipse 95GS',1995,4);
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-30 22:01:52
