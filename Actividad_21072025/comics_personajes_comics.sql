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
-- Table structure for table `personajes_comics`
--

DROP TABLE IF EXISTS `personajes_comics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes_comics` (
  `id_personaje` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `especie` varchar(30) DEFAULT NULL,
  `frase` varchar(150) DEFAULT NULL,
  `id_autor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_personaje`,`nombre`),
  KEY `FK_AUTORES_PERSONAJE_idx` (`id_autor`),
  CONSTRAINT `FK_AUTORES_PERSONAJE` FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id_autor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci COMMENT='campos: id, nombre, especie y frase favorita';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes_comics`
--

LOCK TABLES `personajes_comics` WRITE;
/*!40000 ALTER TABLE `personajes_comics` DISABLE KEYS */;
INSERT INTO `personajes_comics` VALUES (1,'Monkey D. Luffy','Humano','Voy a ser el rey de los piratas',1),(2,'Naruto','Humano','¡Nunca me retracto de mi palabra, ese es mi camino ninja, mi nindo!',2),(3,'Trunk','Híbrido saiyajin y humano','Sé que tú eres mi padre, pero ahora eres mi maestro.',NULL),(4,'Wolwerine','Mutante','Soy el mejor en lo que hago, pero lo que hago no es muy agradable',5),(5,'Viuda Negra','Biónica','He vivido muchas vidas... pero he terminado de huir de mi pasado',NULL),(6,'Nosferatus','Vampiro','No soy yo. Es tu propia naturaleza.',7),(7,'Akira','Androide','El poder viene en respuesta a una necesidad, no a un deseo. Tienes que crear esa necesidad.',2),(14,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(16,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(19,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(21,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(23,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(25,'Rafaello','Tortuga Mutante','Pizza!',2),(26,'Michelangelo','Tortuga Mutante','Pizza!',2),(27,'salir','','',1),(28,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(30,'Rafaello','mutante','pizza',2),(31,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(33,'Rafaello','mutante','pizza!',2),(34,'Maya','Abeja','miel rica',1),(35,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(36,'Sherlock Holmes','Androide','Ele',NULL),(37,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(38,'Sherlock Holmes','Androide','Ele',NULL),(39,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(40,'Sherlock Holmes','Androide','Ele',NULL),(42,'Sherlock Holmes','Humano','Elemental, mi querido Watson',5),(43,'Sherlock Holmes','Androide','Ele',NULL);
/*!40000 ALTER TABLE `personajes_comics` ENABLE KEYS */;
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
