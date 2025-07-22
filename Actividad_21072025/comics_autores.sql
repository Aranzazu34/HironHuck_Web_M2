CREATE DATABASE  IF NOT EXISTS `comics` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `comics`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: comics
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
-- Table structure for table `autores`
--

DROP TABLE IF EXISTS `autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autores`
--

LOCK TABLES `autores` WRITE;
/*!40000 ALTER TABLE `autores` DISABLE KEYS */;
INSERT INTO `autores` VALUES (1,'Masashi','Kishimoto','1974-11-08','2025-07-02 19:36:45','2025-07-07 16:54:50',1),(2,'Eiichiro','Oda','1975-01-01','2025-07-02 19:37:50','2025-07-07 16:54:50',1),(3,'Akira','Toriyama','1955-04-05','2025-07-02 19:38:00','2025-07-14 19:17:51',NULL),(4,'Len','Wein','1948-06-12','2025-07-02 19:39:23','2025-07-07 16:54:50',3),(5,'Stan','Lee','1922-12-28','2025-07-02 19:41:05','2025-07-14 19:17:51',NULL),(6,'Don','Rico','1912-09-26','2025-07-02 19:41:28','2025-07-07 16:54:50',5),(7,'Henrik','Galeen','1881-01-07','2025-07-02 19:41:02','2025-07-07 16:54:50',4),(8,'Cassandra','Evans','1965-03-18','2025-07-02 19:41:02','2025-07-02 19:41:02',NULL);
/*!40000 ALTER TABLE `autores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-22 20:56:40
