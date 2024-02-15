CREATE DATABASE formula_uno;
USE formula_uno;

-- MariaDB dump 10.19  Distrib 10.4.28-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: formula_uno
-- ------------------------------------------------------
-- Server version	10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `circuitos`
--

DROP TABLE IF EXISTS `circuitos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circuitos` (
  `longitud` double NOT NULL,
  `numeroCurvas` int(11) NOT NULL,
  `numeroVueltas` int(11) NOT NULL,
  `circuitoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`circuitoId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circuitos`
--

/*!40000 ALTER TABLE `circuitos` DISABLE KEYS */;
INSERT INTO `circuitos` VALUES (5554,1,55,1,'https://media.formula1.com/image/upload/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Abu_Dhabi_Circuit.png','Yas Marina Circuit','Abu Dhabi'),(5303,16,58,2,'https://upload.wikimedia.org/wikipedia/commons/0/0a/Albert_Park_Circuit_2021.svg','Albert Park Circuit','Australia'),(4318,10,71,3,'https://upload.wikimedia.org/wikipedia/commons/b/b2/Circuit_Red_Bull_Ring.svg','Red Bull Ring','Austria'),(6003,0,51,4,'https://upload.wikimedia.org/wikipedia/commons/f/f1/Baku_Formula_One_circuit_map.svg','Baku City Circuit','Azerbaijan'),(541,15,57,5,'https://upload.wikimedia.org/wikipedia/commons/2/29/Bahrain_International_Circuit--Grand_Prix_Layout.svg','Bahrain International Circuit','Bahrain'),(7004,19,44,6,'https://upload.wikimedia.org/wikipedia/commons/5/54/Spa-Francorchamps_of_Belgium.svg','Circuit de Spa-Francorchamps','Belgium'),(4309,15,71,7,'https://upload.wikimedia.org/wikipedia/commons/c/cf/Aut%C3%B3dromo_Jos%C3%A9_Carlos_Pace_%28AKA_Interlagos%29_track_map.svg','Autodromo Jose Carlos Pace','Brazil'),(4361,14,70,8,'https://upload.wikimedia.org/wikipedia/commons/2/21/Circuit_Gilles_Villeneuve.svg','Circuit Gilles-Villeneuve','Canada'),(5451,16,56,9,'https://upload.wikimedia.org/wikipedia/commons/1/14/Shanghai_International_Racing_Circuit_track_map.svg','Shanghai International Circuit','China'),(584,15,53,10,'https://upload.wikimedia.org/wikipedia/commons/d/d0/Circuit_Paul_Ricard_2020_layout_map.svg','Circuit Paul Ricard','France'),(4574,17,67,11,'https://upload.wikimedia.org/wikipedia/commons/e/e5/Hockenheim2012.svg','Hockenheimring','Germany'),(5891,18,5,12,'https://upload.wikimedia.org/wikipedia/commons/c/ca/Circuit_Silverstone_2011.svg','Silverstone Circuit','Great Britain'),(4381,14,70,13,'https://upload.wikimedia.org/wikipedia/commons/9/91/Hungaroring.svg','Hungaroring','Hungary'),(515,16,60,14,'https://upload.wikimedia.org/wikipedia/commons/d/d3/Buddh_Circuit_2.svg','Buddh International Circuit','India'),(5793,11,53,15,'https://upload.wikimedia.org/wikipedia/commons/f/f8/Monza_track_map.svg','Autodromo Nazionale Monza','Italy'),(5807,18,53,16,'https://upload.wikimedia.org/wikipedia/commons/e/ec/Suzuka_circuit_map--2005.svg','Suzuka International Racing Course','Japan'),(5543,15,56,17,'https://upload.wikimedia.org/wikipedia/commons/6/67/Sepang.svg','Sepang International Circuit','Malaysia'),(4304,17,71,18,'https://upload.wikimedia.org/wikipedia/commons/3/36/Aut%C3%B3dromo_Hermanos_Rodr%C3%ADguez_2015.svg','Autodromo Hermanos Rodriguez','Mexico'),(3337,19,78,19,'https://upload.wikimedia.org/wikipedia/commons/3/36/Monte_Carlo_Formula_1_track_map.svg','Circuit de Monaco','Monaco'),(5848,18,53,20,'https://upload.wikimedia.org/wikipedia/commons/d/d3/Circuit_Sochi.svg','Sochi Autodrom','Russia'),(5063,3,61,21,'https://upload.wikimedia.org/wikipedia/commons/8/8b/Marina_Bay_circuit_2023.svg','Marina Bay Street Circuit','Singapore'),(5615,3,55,22,'https://upload.wikimedia.org/wikipedia/commons/2/29/Korea_international_circuit_v3.svg','Korea International Circuit','South Korea'),(4655,16,66,23,'https://upload.wikimedia.org/wikipedia/commons/2/26/Formula1_Circuit_Catalunya_2021.svg','Circuit de Barcelona-Catalunya','Spain'),(5513,0,56,24,'https://upload.wikimedia.org/wikipedia/commons/a/a5/Austin_circuit.svg','Circuit of The Americas','United States');
/*!40000 ALTER TABLE `circuitos` ENABLE KEYS */;

--
-- Table structure for table `pilotos`
--

DROP TABLE IF EXISTS `pilotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pilotos` (
  `numero` int(11) NOT NULL,
  `pilotoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `equipo` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pilotoId`)
) ENGINE=InnoDB AUTO_INCREMENT=574 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pilotos`
--

/*!40000 ALTER TABLE `pilotos` DISABLE KEYS */;
INSERT INTO `pilotos` VALUES (15,543,'Force India Mercedes','https://upload.wikimedia.org/wikipedia/commons/e/e4/Adrian_Sutil.jpg','Adrian Sutil'),(20,544,'Caterham Renault','https://upload.wikimedia.org/wikipedia/commons/e/ef/Charles_Pic_Moscow_2013.jpg','Charles Pic'),(19,545,'STR Ferrari','https://upload.wikimedia.org/wikipedia/commons/2/24/Daniel_Ricciardo%2C_British_GP_2022_%2852382610448%29_%28cropped%29.jpg','Daniel Ricciardo'),(12,546,'Sauber Ferrari','https://upload.wikimedia.org/wikipedia/commons/d/df/Esteban_Guti%C3%A9rrez_en_el_Gran_Premio_de_Italia_2019_%28cropped%29.jpg','Esteban Gutierrez'),(4,547,'Ferrari','https://upload.wikimedia.org/wikipedia/commons/e/e7/Felipe_Massa.jpg','Felipe Massa'),(3,548,'Ferrari','https://upload.wikimedia.org/wikipedia/commons/0/0f/Fernando_Alonso_NASCAR_Media_Tour_2018.jpg','Fernando Alonso'),(21,549,'Caterham Renault','https://upload.wikimedia.org/wikipedia/commons/b/b7/Giedo_van_der_Garde.jpg','Giedo van der Garde'),(18,550,'STR Ferrari','https://upload.wikimedia.org/wikipedia/commons/2/2f/2023-04-23_Motorsport%2C_ABB_FIA_Formula_E_World_Championship%2C_Berlin_E-Prix_2023_1DX_1752_by_Stepro.jpg','Jean-Eric Vergne'),(5,551,'McLaren Mercedes','https://upload.wikimedia.org/wikipedia/commons/6/62/Jenson_button_%2852780850669%29_%28cropped%29.jpg','Jenson Button'),(22,552,'Marussia Cosworth','https://upload.wikimedia.org/wikipedia/commons/0/03/Jules_Bianchi_2012-1.JPG','Jules Bianchi'),(7,553,'Lotus Renault','https://upload.wikimedia.org/wikipedia/commons/2/27/Kimi_raikkonen_%2852780844274%29_%28cropped%29.jpg','Kimi Raikkonen'),(10,554,'Mercedes','https://upload.wikimedia.org/wikipedia/commons/a/ac/Lewis_Hamilton_2022_S%C3%A3o_Paulo_Grand_Prix_%2852498120773%29_%28cropped%29.jpg','Lewis Hamilton'),(2,555,'Red Bull Racing Renault','https://upload.wikimedia.org/wikipedia/commons/b/b2/Mark_Webber_2017_Malaysian_GP_podium.jpg','Mark Webber'),(23,556,'Marussia Cosworth','https://upload.wikimedia.org/wikipedia/commons/f/f8/Max_Chilton_2.jpg','Max Chilton'),(11,557,'Sauber Ferrari','https://upload.wikimedia.org/wikipedia/commons/d/de/2019_Formula_One_tests_Barcelona%2C_Hulkenberg_%2840287128313%29.jpg','Nico Hulkenberg'),(9,558,'Mercedes','https://upload.wikimedia.org/wikipedia/commons/4/41/Web_Summit_2018_-_Forum_-_Day_1%2C_November_6_SAM_9601_%2845023831104%29.jpg','Nico Rosberg'),(16,559,'Williams Renault','https://upload.wikimedia.org/wikipedia/commons/0/00/Pastor_Maldonado_2015_Malaysia.jpg','Pastor Maldonado'),(14,560,'Force India Mercedes','https://upload.wikimedia.org/wikipedia/commons/8/8a/United-autosports-le-mans-2018-scrutineering-033_%2842043926574%29.jpg','Paul di Resta'),(8,561,'Lotus Renault','https://upload.wikimedia.org/wikipedia/commons/e/ee/Romain_Grosjean_2022_Long_Beach.jpg','Romain Grosjean'),(1,562,'Red Bull Racing Renault','https://upload.wikimedia.org/wikipedia/commons/a/ad/Sebastian_Vettel_2015_Malaysia_podium_2.jpg','Sebastian Vettel'),(6,563,'McLaren Mercedes','https://upload.wikimedia.org/wikipedia/commons/f/f3/2019_Formula_One_tests_Barcelona%2C_P%C3%A9rez_%2847200017422%29.jpg','Sergio Perez'),(17,564,'Williams Renault','https://upload.wikimedia.org/wikipedia/commons/5/5f/Valtteri_Bottas_at_the_2022_Austrian_Grand_Prix.jpg','Valtteri Bottas'),(13,565,'Lotus Renault','https://upload.wikimedia.org/wikipedia/commons/2/29/Effect_20190609_091716.jpg','Heikki Kovalainen');
/*!40000 ALTER TABLE `pilotos` ENABLE KEYS */;

--
-- Table structure for table `resultados`
--

DROP TABLE IF EXISTS `resultados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resultados` (
  `posicionLlegada` int(11) NOT NULL,
  `posicionSalida` int(11) NOT NULL,
  `circuitoId` bigint(20) NOT NULL,
  `pilotoId` bigint(20) NOT NULL,
  PRIMARY KEY (`circuitoId`,`pilotoId`),
  KEY `FK7710pri2u0iiw8dc4ibkcwgce` (`pilotoId`),
  CONSTRAINT `FK7710pri2u0iiw8dc4ibkcwgce` FOREIGN KEY (`pilotoId`) REFERENCES `pilotos` (`pilotoId`),
  CONSTRAINT `FKr2294xwc9dc9o3ydr4nqhlues` FOREIGN KEY (`circuitoId`) REFERENCES `circuitos` (`circuitoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultados`
--

/*!40000 ALTER TABLE `resultados` DISABLE KEYS */;
INSERT INTO `resultados` VALUES (17,10,1,543),(19,19,1,544),(9,16,1,545),(16,13,1,546),(7,8,1,547),(10,5,1,548),(18,18,1,549),(13,17,1,550),(1,12,1,551),(1,20,1,552),(0,0,1,553),(4,7,1,554),(1,2,1,555),(0,21,1,556),(5,14,1,557),(3,3,1,558),(14,11,1,559),(11,6,1,560),(6,4,1,561),(0,1,1,562),(8,9,1,563),(15,15,1,564),(0,0,1,565),(1,7,2,543),(0,16,2,544),(14,0,2,545),(18,13,2,546),(4,4,2,547),(5,2,2,548),(1,18,2,549),(13,12,2,550),(10,9,2,551),(19,15,2,552),(7,1,2,553),(3,5,2,554),(0,6,2,555),(0,17,2,556),(11,0,2,557),(6,0,2,558),(17,0,2,559),(9,8,2,560),(8,10,2,561),(1,3,2,562),(15,11,2,563),(16,14,2,564),(7,1,2,565),(6,13,5,543),(18,17,5,544),(13,16,5,545),(0,18,5,546),(4,15,5,547),(3,8,5,548),(0,21,5,549),(16,0,5,550),(10,10,5,551),(19,19,5,552),(8,2,5,553),(9,5,5,554),(7,7,5,555),(1,20,5,556),(14,12,5,557),(1,9,5,558),(17,11,5,559),(5,4,5,560),(11,3,5,561),(0,1,5,562),(1,6,5,563),(15,14,5,564),(8,2,5,565),(1,9,6,543),(0,0,6,544),(19,10,6,545),(1,14,6,546),(10,7,6,547),(9,2,6,548),(14,16,6,549),(18,12,6,550),(6,6,6,551),(15,18,6,552),(8,0,6,553),(1,3,6,554),(3,5,6,555),(16,19,6,556),(11,13,6,557),(4,4,6,558),(17,17,6,559),(5,0,6,560),(7,8,6,561),(0,1,6,562),(13,11,6,563),(0,15,6,564),(8,0,6,565),(15,13,7,543),(18,0,7,544),(7,10,7,545),(17,12,7,546),(9,7,7,547),(3,3,7,548),(0,18,7,549),(8,15,7,550),(14,4,7,551),(1,17,7,552),(11,14,7,553),(5,9,7,554),(4,2,7,555),(0,19,7,556),(10,8,7,557),(0,5,7,558),(16,16,7,559),(1,11,7,560),(6,0,7,561),(1,1,7,562),(19,6,7,563),(13,0,7,564),(11,14,7,565),(8,10,8,543),(18,18,8,544),(11,15,8,545),(15,20,8,546),(16,8,8,547),(6,2,8,548),(1,0,8,549),(7,6,8,550),(14,12,8,551),(19,17,8,552),(10,9,8,553),(0,3,8,554),(5,4,8,555),(0,19,8,556),(9,0,8,557),(4,5,8,558),(13,16,8,559),(17,7,8,560),(0,13,8,561),(1,1,8,562),(1,11,8,563),(3,14,8,564),(10,9,8,565),(13,0,9,543),(0,16,9,544),(7,7,9,545),(17,0,9,546),(5,6,9,547),(3,1,9,548),(1,18,9,549),(15,12,9,550),(8,5,9,551),(18,15,9,552),(0,2,9,553),(1,3,9,554),(0,0,9,555),(19,17,9,556),(10,10,9,557),(4,0,9,558),(14,14,9,559),(11,8,9,560),(6,9,9,561),(9,4,9,562),(1,11,9,563),(16,13,9,564),(0,2,9,565),(15,13,11,543),(0,17,11,544),(6,12,11,545),(14,14,11,546),(7,0,11,547),(8,4,11,548),(0,18,11,549),(16,0,11,550),(9,6,11,551),(19,0,11,552),(4,2,11,553),(1,5,11,554),(3,7,11,555),(1,19,11,556),(10,10,11,557),(11,9,11,558),(18,15,11,559),(1,11,11,560),(5,3,11,561),(0,1,11,562),(13,8,11,563),(17,16,11,564),(4,2,11,565),(6,7,12,543),(18,15,12,544),(5,8,12,545),(17,14,12,546),(11,6,12,547),(9,3,12,548),(0,18,12,549),(1,0,12,550),(10,13,12,551),(19,16,12,552),(8,5,12,553),(1,4,12,554),(4,2,12,555),(0,17,12,556),(14,10,12,557),(0,1,12,558),(15,11,12,559),(1,9,12,560),(7,19,12,561),(3,0,12,562),(13,20,12,563),(16,12,12,564),(8,5,12,565),(11,0,13,543),(19,15,13,544),(8,13,13,545),(17,0,13,546),(7,8,13,547),(5,5,13,548),(0,14,13,549),(14,12,13,550),(13,7,13,551),(1,16,13,552),(6,2,13,553),(1,1,13,554),(10,4,13,555),(0,17,13,556),(1,11,13,557),(4,19,13,558),(15,10,13,559),(18,18,13,560),(3,6,13,561),(0,3,13,562),(9,9,13,563),(16,0,13,564),(6,2,13,565),(13,9,14,543),(1,0,14,544),(11,10,14,545),(16,15,14,546),(5,4,14,547),(8,11,14,548),(0,0,14,549),(14,13,14,550),(10,14,14,551),(19,18,14,552),(6,7,14,553),(3,6,14,554),(4,0,14,555),(0,17,14,556),(7,19,14,557),(0,2,14,558),(18,12,14,559),(1,8,14,560),(17,3,14,561),(1,1,14,562),(9,5,14,563),(15,16,14,564),(6,7,14,565),(17,16,15,543),(0,17,15,544),(7,7,15,545),(16,13,15,546),(4,4,15,547),(5,2,15,548),(19,18,15,549),(10,0,15,550),(9,10,15,551),(1,19,15,552),(11,11,15,553),(1,9,15,554),(0,3,15,555),(0,20,15,556),(3,5,15,557),(6,6,15,558),(14,14,15,559),(15,0,15,560),(13,8,15,561),(1,1,15,562),(8,12,15,563),(18,15,15,564),(11,11,15,565),(0,14,16,543),(0,18,16,544),(16,13,16,545),(14,7,16,546),(5,10,16,547),(8,4,16,548),(19,0,16,549),(17,12,16,550),(10,9,16,551),(1,0,16,552),(9,5,16,553),(3,0,16,554),(1,2,16,555),(18,19,16,556),(7,6,16,557),(6,8,16,558),(15,16,16,559),(1,11,16,560),(4,3,16,561),(0,1,16,562),(11,15,16,563),(13,17,16,564),(9,5,16,565),(8,0,17,543),(0,14,17,544),(13,18,17,545),(14,12,17,546),(0,5,17,547),(3,0,17,548),(0,15,17,549),(17,10,17,550),(7,17,17,551),(19,13,17,552),(10,7,17,553),(4,3,17,554),(5,2,17,555),(1,16,17,556),(1,8,17,557),(6,4,17,558),(16,0,17,559),(15,0,17,560),(11,6,17,561),(1,1,17,562),(9,9,17,563),(18,11,17,564),(10,7,17,565),(8,5,19,543),(18,0,19,544),(1,0,19,545),(19,13,19,546),(1,0,19,547),(6,7,19,548),(15,15,19,549),(10,8,19,550),(9,6,19,551),(0,0,19,552),(5,10,19,553),(0,4,19,554),(4,3,19,555),(0,14,19,556),(11,11,19,557),(1,1,19,558),(16,0,19,559),(17,9,19,560),(13,0,19,561),(3,2,19,562),(7,16,19,563),(14,12,19,564),(5,10,19,565),(15,10,21,543),(19,19,21,544),(9,0,21,545),(10,12,21,546),(6,6,21,547),(7,2,21,548),(0,16,21,549),(1,14,21,550),(8,7,21,551),(1,18,21,552),(13,3,21,553),(5,5,21,554),(4,15,21,555),(0,17,21,556),(11,9,21,557),(0,4,21,558),(18,11,21,559),(17,20,21,560),(3,0,21,561),(1,1,21,562),(14,8,21,563),(16,13,21,564),(13,3,21,565),(14,20,22,543),(19,14,22,544),(1,19,22,545),(8,11,22,546),(6,9,22,547),(5,6,22,548),(0,15,22,549),(16,18,22,550),(11,8,22,551),(0,16,22,552),(9,2,22,553),(0,5,22,554),(13,0,22,555),(1,17,22,556),(7,4,22,557),(4,7,22,558),(18,13,22,559),(15,0,22,560),(3,3,22,561),(1,1,22,562),(10,10,22,563),(17,12,22,564),(9,2,22,565),(13,13,23,543),(0,17,23,544),(11,10,23,545),(19,11,23,546),(9,3,23,547),(5,1,23,548),(18,0,23,549),(1,0,23,550),(14,8,23,551),(0,18,23,552),(4,2,23,553),(0,12,23,554),(7,5,23,555),(1,19,23,556),(15,15,23,557),(1,6,23,558),(17,14,23,559),(10,7,23,560),(6,0,23,561),(3,4,23,562),(8,9,23,563),(16,16,23,564),(4,2,23,565),(16,0,24,543),(0,20,24,544),(10,11,24,545),(0,13,24,546),(13,12,24,547),(6,5,24,548),(18,19,24,549),(14,16,24,550),(15,10,24,551),(19,18,24,552),(8,14,24,553),(5,4,24,554),(0,3,24,555),(1,21,24,556),(4,6,24,557),(1,9,24,558),(17,17,24,559),(11,15,24,560),(3,2,24,561),(1,1,24,562),(7,7,24,563),(9,8,24,564),(8,14,24,565);
/*!40000 ALTER TABLE `resultados` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-04 12:38:15
