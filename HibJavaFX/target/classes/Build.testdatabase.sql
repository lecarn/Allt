-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: hibernate
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `konsert`
--

DROP TABLE IF EXISTS `konsert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konsert` (
  `idKonsert` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `artist` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idKonsert`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konsert`
--

LOCK TABLES `konsert` WRITE;
/*!40000 ALTER TABLE `konsert` DISABLE KEYS */;
INSERT INTO `konsert` VALUES (1,'2019-01-01','sean'),(2,'2001-05-15','sean ba'),(3,'2019-12-01','Test Artist'),(4,'2017-01-17','Mojje'),(5,'2019-07-07','Mackan');
/*!40000 ALTER TABLE `konsert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `konsert_personer`
--

DROP TABLE IF EXISTS `konsert_personer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konsert_personer` (
  `idPersoner` int NOT NULL,
  `idKonsert` int NOT NULL,
  PRIMARY KEY (`idPersoner`,`idKonsert`),
  KEY `fkKonsert_idx` (`idKonsert`),
  CONSTRAINT `fkKonsert` FOREIGN KEY (`idKonsert`) REFERENCES `konsert` (`idKonsert`),
  CONSTRAINT `fkPersoner` FOREIGN KEY (`idPersoner`) REFERENCES `personer` (`idpersoner`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konsert_personer`
--

LOCK TABLES `konsert_personer` WRITE;
/*!40000 ALTER TABLE `konsert_personer` DISABLE KEYS */;
INSERT INTO `konsert_personer` VALUES (1,1),(2,1),(2,2),(1,4),(2,4),(3,4),(4,4),(5,4);
/*!40000 ALTER TABLE `konsert_personer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personer`
--

DROP TABLE IF EXISTS `personer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personer` (
  `idpersoner` int NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idpersoner`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personer`
--

LOCK TABLES `personer` WRITE;
/*!40000 ALTER TABLE `personer` DISABLE KEYS */;
INSERT INTO `personer` VALUES (1,12,'maja'),(2,12,'Test Person'),(3,15,'Kalle Balle'),(4,37,'Mojje'),(5,45,'Fterent');
/*!40000 ALTER TABLE `personer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hibernate'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-12 14:00:53
