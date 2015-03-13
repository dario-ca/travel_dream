CREATE DATABASE  IF NOT EXISTS `travelDream` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `travelDream`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: travelDream
-- ------------------------------------------------------
-- Server version	5.6.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ACCOMMODATION`
--

DROP TABLE IF EXISTS `ACCOMMODATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACCOMMODATION` (
  `IDACCOMMODATION` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `CHECKINDATE` date DEFAULT NULL,
  `CHECKOUTDATE` date DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `RATING` int(11) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`IDACCOMMODATION`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACCOMMODATION`
--

LOCK TABLES `ACCOMMODATION` WRITE;
/*!40000 ALTER TABLE `ACCOMMODATION` DISABLE KEYS */;
INSERT INTO `ACCOMMODATION` VALUES (1,'via del mare 18','2014-08-01','2014-08-07','Hotel miramare',549.9,5,1),(2,'Main st, 109, NewYork City','2014-08-05','2014-01-13','Hotel NY',490,3,1),(3,'Via del corso 16, Roma','2014-12-29','2015-01-03','Hotel Caput Mundi',450,5,1),(4,'Via risparmio 32, Roma','2014-12-29','2015-01-03','Hotel Tiburtina',130,1,1),(5,'Vorovskogo, 36, Sochi, Russia','2014-02-07','2014-02-14','Hotel mar Nero',480,5,1),(6,'Volsko 10, Sochi, Russia','2014-02-07','2014-02-14','Hotel GrandSochi',215,2,1),(7,'Corso Roma 44, Gallipoli, Lecce','2014-08-10','2014-08-20','Hotel La baia verde',500,4,1),(8,'First Street 88, San Francisco, California ','2014-06-01','2014-06-08','Hotel Mirage',650,4,1),(9,'Fourth Avenue 12, LA, California ','2014-06-08','2014-06-15','Motel SkyFree',460,3,1),(10,'Beijing, Beilishi Rd','2014-03-20','2014-03-30','Hotel Mao',350,4,1),(11,'S Alley Xicheng, Beijing','2014-03-20','2014-03-30','Hotel Tse-tung',460,5,1),(12,'1 Sheikh Mohammed - Dubai','2014-04-01','2014-01-08','Burj Khalifa',10450,5,1),(13,'via dei tappeti volanti 5','2014-09-10','2014-09-17','Hotel Aladdin',450,4,1),(14,'Janpath 8, New Delhi','2014-09-10','2014-09-17','Ostello Delisi',190,1,1),(15,'Via del chiaccio 1','2014-11-10','2014-11-18','Accampamento',100,1,1);
/*!40000 ALTER TABLE `ACCOMMODATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACCOMMODATIONOPTIONS`
--

DROP TABLE IF EXISTS `ACCOMMODATIONOPTIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACCOMMODATIONOPTIONS` (
  `PACKAGEID` int(11) NOT NULL,
  `ACCOMMODATIONID` int(11) NOT NULL,
  PRIMARY KEY (`PACKAGEID`,`ACCOMMODATIONID`),
  KEY `FK_ACCOMMODATIONOPTIONS_ACCOMMODATIONID` (`ACCOMMODATIONID`),
  CONSTRAINT `FK_ACCOMMODATIONOPTIONS_ACCOMMODATIONID` FOREIGN KEY (`ACCOMMODATIONID`) REFERENCES `ACCOMMODATION` (`IDACCOMMODATION`),
  CONSTRAINT `FK_ACCOMMODATIONOPTIONS_PACKAGEID` FOREIGN KEY (`PACKAGEID`) REFERENCES `PACKAGETD` (`IDPACKAGETD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACCOMMODATIONOPTIONS`
--

LOCK TABLES `ACCOMMODATIONOPTIONS` WRITE;
/*!40000 ALTER TABLE `ACCOMMODATIONOPTIONS` DISABLE KEYS */;
INSERT INTO `ACCOMMODATIONOPTIONS` VALUES (1,3),(7,3),(8,3),(1,4),(7,4),(8,4),(2,5),(9,5),(13,5),(2,6),(9,6),(13,6),(3,7),(10,7),(4,8),(15,8),(5,9),(11,9),(12,9),(6,10),(14,10),(6,11),(14,11),(16,12),(17,13),(17,14),(18,15);
/*!40000 ALTER TABLE `ACCOMMODATIONOPTIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PACKAGETD`
--

DROP TABLE IF EXISTS `PACKAGETD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PACKAGETD` (
  `IDPACKAGETD` int(11) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `ONOFFER` tinyint(1) DEFAULT '0',
  `PERSONALIZED` tinyint(1) DEFAULT '0',
  `PRICE` double DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT '0',
  `USEREMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDPACKAGETD`),
  KEY `FK_PACKAGETD_USEREMAIL` (`USEREMAIL`),
  CONSTRAINT `FK_PACKAGETD_USEREMAIL` FOREIGN KEY (`USEREMAIL`) REFERENCES `USER` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PACKAGETD`
--

LOCK TABLES `PACKAGETD` WRITE;
/*!40000 ALTER TABLE `PACKAGETD` DISABLE KEYS */;
INSERT INTO `PACKAGETD` VALUES (1,'Roma','Italia','Hai mai visitato Roma d\'inverno? questa e\' la tua occasione! La capitale d\'Italia ti aspetta a capodanno!','Capodanno nella capitale!',1,0,139,1,NULL),(2,'Sochi','Russia','Cappello sciarpa e guanti! Ti portiamo alle Olimpiadi invernali di Sochi! ','Olimpiadi invernali',0,0,200,1,NULL),(3,'Gallipoli','Italia','Se cerchi una meta turistica e allo stesso tempo economica per passare in spiaggia il tuo Ferragosto questo pacchetto fa al caso tuo! Ti invitiamo a trascorrere le tue vacanze in una delle piu\' belle citta\' del Salento!','Ferragosto a Gallipoli',1,0,90,1,NULL),(4,'San Francisco','USA','Vuoi scoprire la California? inizia da San Francisco! Il pacchetto offre varie attivita\' da svolgere, scegli quelle piu\' adatte a te.','San Francisco ti aspetta!',0,0,250,1,NULL),(5,'Los Angeles','USA','Passa l\'estate in California! Ti portiamo in una delle citta\' piu\' famosa di questa bellissimo angolo del mondo. Due fantastiche esperienze ti aspettano, non perdere tempo! Parti!','Hollywood e Disneyland per te!',1,0,299,1,NULL),(6,'Pechino','Cina','Mai stato in oriente? Con questo pacchetto sarai completamente immerso nella tradizione cinese ed entrerai a contatto con una cultura millenaria. Non farti sfuggire questa esperienza unica!','Alla scoperta della Cina!',0,0,399,1,NULL),(7,'Roma','Italia','Hai mai visitato Roma d\'inverno? questa e\' la tua occasione! La capitale d\'Italia ti aspetta a capodanno!','Capodanno nella capitale!',1,1,139,1,'utente1@gmail.com'),(8,'Roma','Italia','Hai mai visitato Roma d\'inverno? questa e\' la tua occasione! La capitale d\'Italia ti aspetta a capodanno!','Capodanno nella capitale!',1,1,139,0,'utente1@gmail.com'),(9,'Sochi','Russia','Cappello sciarpa e guanti! Ti portiamo alle Olimpiadi invernali di Sochi! ','Olimpiadi invernali',1,1,200,1,'utente1@gmail.com'),(10,'Gallipoli','Italia','Se cerchi una meta turistica e allo stesso tempo economica per passare in spiaggia il tuo Ferragosto questo pacchetto fa al caso tuo! Ti invitiamo a trascorrere le tue vacanze in una delle pi?? belle citta\' del Salento!','Ferragosto a Gallipoli',1,1,90,1,'utente1@gmail.com'),(11,'Los Angeles','USA','Passa l\'estate in California! Ti portiamo in una delle citta\' piu\' famosa di questa bellissimo angolo del mondo. Due fantastiche esperienze ti aspettano, non perdere tempo! Parti!','Hollywood e Disneyland per te!',1,1,299,1,'utente1@gmail.com'),(12,'Los Angeles','USA','Passa l\'estate in California! Ti portiamo in una delle citta\' piu\' famosa di questa bellissimo angolo del mondo. Due fantastiche esperienze ti aspettano, non perdere tempo! Parti!','Hollywood e Disneyland per te!',1,1,299,1,'utente1@gmail.com'),(13,'Sochi','Russia','Cappello sciarpa e guanti! Ti portiamo alle Olimpiadi invernali di Sochi! ','Olimpiadi invernali',1,1,200,1,'utente2@gmail.com'),(14,'Pechino','Cina','Mai stato in oriente? Con questo pacchetto sarai completamente immerso nella tradizione cinese ed entrerai a contatto con una cultura millenaria. Non farti sfuggire questa esperienza unica!','Alla scoperta della Cina!',1,1,399,1,'utente2@gmail.com'),(15,'San Francisco','USA','Vuoi scoprire la California? inizia da San Francisco! Il pacchetto offre varie attivita\' da svolgere, scegli quelle piu\' adatte a te.','San Francisco ti aspetta!',1,1,250,1,'utente2@gmail.com'),(16,'Dubai','Emirati Arabi','Concediti una vacanza immerso nel lusso della nuova meta turistica! Molte esclusive attrazioni ti aspettano.','Luxury Dubai',0,0,4500,1,NULL),(17,'Nuova Dehli','India','L\'India e\' una nazione fantastica e incredibile che merita di essere visitata almeno una volta nella vita. Offriamo questo pacchetto esclusivo ad un prezzo molto conveniente, inclusa la visita al mausoleo seicentesco simbolo della nazione.','Incredible India',1,0,290,1,NULL),(18,'Villa Las Estrellas','Antartide','Viaggio estremo per persone estreme. In regalo un bagno nelle acque gelide dell\'antartire!','Antartide che passione',0,0,100,0,NULL);
/*!40000 ALTER TABLE `PACKAGETD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PURCHASEDPACKAGE`
--

DROP TABLE IF EXISTS `PURCHASEDPACKAGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PURCHASEDPACKAGE` (
  `IDPURCHASEDPACKAGE` int(11) NOT NULL AUTO_INCREMENT,
  `NUMPEOPLE` int(11) DEFAULT NULL,
  `TOTPRICE` int(11) DEFAULT NULL,
  `PACKAGEID` int(11) DEFAULT NULL,
  `USEREMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDPURCHASEDPACKAGE`),
  KEY `FK_PURCHASEDPACKAGE_PACKAGEID` (`PACKAGEID`),
  KEY `FK_PURCHASEDPACKAGE_USEREMAIL` (`USEREMAIL`),
  CONSTRAINT `FK_PURCHASEDPACKAGE_PACKAGEID` FOREIGN KEY (`PACKAGEID`) REFERENCES `PACKAGETD` (`IDPACKAGETD`),
  CONSTRAINT `FK_PURCHASEDPACKAGE_USEREMAIL` FOREIGN KEY (`USEREMAIL`) REFERENCES `USER` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PURCHASEDPACKAGE`
--

LOCK TABLES `PURCHASEDPACKAGE` WRITE;
/*!40000 ALTER TABLE `PURCHASEDPACKAGE` DISABLE KEYS */;
INSERT INTO `PURCHASEDPACKAGE` VALUES (1,2,90,3,'utente1@gmail.com'),(2,2,200,9,'utente1@gmail.com'),(3,4,399,6,'utente1@gmail.com'),(4,6,299,5,'utente1@gmail.com'),(5,5,200,9,'utente1@gmail.com'),(6,2,139,1,'utente2@gmail.com'),(7,3,250,15,'utente2@gmail.com');
/*!40000 ALTER TABLE `PURCHASEDPACKAGE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SELECTEDACCOMMODATION`
--

DROP TABLE IF EXISTS `SELECTEDACCOMMODATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SELECTEDACCOMMODATION` (
  `IDSELECTEDACCOMMODATION` int(11) NOT NULL AUTO_INCREMENT,
  `ACCOMMODATIONID` int(11) DEFAULT NULL,
  `PACKAGEID` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDSELECTEDACCOMMODATION`),
  KEY `FK_SELECTEDACCOMMODATION_ACCOMMODATIONID` (`ACCOMMODATIONID`),
  KEY `FK_SELECTEDACCOMMODATION_PACKAGEID` (`PACKAGEID`),
  CONSTRAINT `FK_SELECTEDACCOMMODATION_ACCOMMODATIONID` FOREIGN KEY (`ACCOMMODATIONID`) REFERENCES `ACCOMMODATION` (`IDACCOMMODATION`),
  CONSTRAINT `FK_SELECTEDACCOMMODATION_PACKAGEID` FOREIGN KEY (`PACKAGEID`) REFERENCES `PACKAGETD` (`IDPACKAGETD`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SELECTEDACCOMMODATION`
--

LOCK TABLES `SELECTEDACCOMMODATION` WRITE;
/*!40000 ALTER TABLE `SELECTEDACCOMMODATION` DISABLE KEYS */;
INSERT INTO `SELECTEDACCOMMODATION` VALUES (1,4,1),(2,6,2),(3,7,3),(4,8,4),(5,9,5),(6,11,6),(7,3,7),(8,4,8),(9,5,9),(10,7,10),(11,9,11),(12,9,12),(13,5,13),(14,11,14),(15,8,15),(16,12,16),(17,14,17),(18,15,18);
/*!40000 ALTER TABLE `SELECTEDACCOMMODATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SELECTEDTRANSPORTATIONMEAN`
--

DROP TABLE IF EXISTS `SELECTEDTRANSPORTATIONMEAN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SELECTEDTRANSPORTATIONMEAN` (
  `IDSELECTEDTRANSPORTATION` int(11) NOT NULL AUTO_INCREMENT,
  `PACKAGEID` int(11) DEFAULT NULL,
  `TRANSPORTATIONID` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDSELECTEDTRANSPORTATION`),
  KEY `FK_SELECTEDTRANSPORTATIONMEAN_TRANSPORTATIONID` (`TRANSPORTATIONID`),
  KEY `FK_SELECTEDTRANSPORTATIONMEAN_PACKAGEID` (`PACKAGEID`),
  CONSTRAINT `FK_SELECTEDTRANSPORTATIONMEAN_PACKAGEID` FOREIGN KEY (`PACKAGEID`) REFERENCES `PACKAGETD` (`IDPACKAGETD`),
  CONSTRAINT `FK_SELECTEDTRANSPORTATIONMEAN_TRANSPORTATIONID` FOREIGN KEY (`TRANSPORTATIONID`) REFERENCES `TRANSPORTATIONMEAN` (`IDTRANSPORTATION`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SELECTEDTRANSPORTATIONMEAN`
--

LOCK TABLES `SELECTEDTRANSPORTATIONMEAN` WRITE;
/*!40000 ALTER TABLE `SELECTEDTRANSPORTATIONMEAN` DISABLE KEYS */;
INSERT INTO `SELECTEDTRANSPORTATIONMEAN` VALUES (15,5,14),(16,5,16),(19,1,3),(20,1,2),(21,7,3),(22,7,2),(23,8,3),(24,8,2),(25,9,8),(26,9,6),(27,10,9),(28,10,10),(29,11,14),(30,11,16),(31,12,16),(32,12,14),(33,3,9),(34,3,10),(35,13,8),(36,13,7),(37,14,18),(38,14,19),(39,15,15),(40,15,13),(41,16,21),(42,16,20),(43,17,22),(44,17,23),(45,18,24),(46,18,25),(47,2,6),(48,2,8),(49,4,15),(50,4,13),(51,6,17),(52,6,19);
/*!40000 ALTER TABLE `SELECTEDTRANSPORTATIONMEAN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SELECTEDTRIP`
--

DROP TABLE IF EXISTS `SELECTEDTRIP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SELECTEDTRIP` (
  `IDSELECTEDTRIP` int(11) NOT NULL AUTO_INCREMENT,
  `PACKAGEID` int(11) DEFAULT NULL,
  `TRIPID` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDSELECTEDTRIP`),
  KEY `FK_SELECTEDTRIP_TRIPID` (`TRIPID`),
  KEY `FK_SELECTEDTRIP_PACKAGEID` (`PACKAGEID`),
  CONSTRAINT `FK_SELECTEDTRIP_PACKAGEID` FOREIGN KEY (`PACKAGEID`) REFERENCES `PACKAGETD` (`IDPACKAGETD`),
  CONSTRAINT `FK_SELECTEDTRIP_TRIPID` FOREIGN KEY (`TRIPID`) REFERENCES `TRIP` (`IDTRIP`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SELECTEDTRIP`
--

LOCK TABLES `SELECTEDTRIP` WRITE;
/*!40000 ALTER TABLE `SELECTEDTRIP` DISABLE KEYS */;
INSERT INTO `SELECTEDTRIP` VALUES (8,5,12),(9,5,13),(11,1,5),(12,7,4),(13,8,4),(14,9,6),(15,10,7),(16,11,12),(17,12,12),(18,3,8),(19,13,6),(20,14,14),(21,15,10),(22,16,15),(23,17,17),(24,18,18),(25,2,6),(26,4,11),(27,6,14);
/*!40000 ALTER TABLE `SELECTEDTRIP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRANSPORTATIONMEAN`
--

DROP TABLE IF EXISTS `TRANSPORTATIONMEAN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRANSPORTATIONMEAN` (
  `IDTRANSPORTATION` int(11) NOT NULL AUTO_INCREMENT,
  `ARRIVALDATE` datetime DEFAULT NULL,
  `DEPARTUREDATE` datetime DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `NOTES` varchar(255) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`IDTRANSPORTATION`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRANSPORTATIONMEAN`
--

LOCK TABLES `TRANSPORTATIONMEAN` WRITE;
/*!40000 ALTER TABLE `TRANSPORTATIONMEAN` DISABLE KEYS */;
INSERT INTO `TRANSPORTATIONMEAN` VALUES (1,'2014-08-05 20:00:00','2014-08-05 09:00:00','Milano-NewYork','RyanAir',499,1),(2,'2014-12-29 11:00:00','2014-12-29 08:00:00','Milano-Roma','Trenitalia',45,1),(3,'2015-01-03 11:00:00','2015-01-03 09:00:00','Roma-Milano','Trenitalia',55,1),(4,'2014-08-25 19:00:00','2014-08-13 08:00:00','NewYork-Milano','American Airlines',789,1),(5,'2015-01-03 13:00:00','2015-01-03 12:00:00','Roma-Milano','Alitalia',200,1),(6,'2014-01-25 13:30:00','2014-02-07 07:00:00','Roma-Sochi','Rossiya Airlines',210,1),(7,'2014-01-25 15:22:00','2014-02-07 09:35:00','Roma-Sochi','Alitalia',250,1),(8,'2014-02-14 15:22:00','2014-02-14 09:00:00','Sochi-Roma','Rossiya Airlines',199,1),(9,'2014-08-10 22:00:00','2014-08-10 10:00:00','Milano-Lecce','Trenitalia',90,1),(10,'2014-08-10 20:00:00','2014-08-10 08:00:00','Lecce-Milano','Trenitalia',90,1),(11,'2014-08-10 19:00:00','2014-08-10 12:00:00','Roma-Lecce','Italo',50,1),(12,'2014-08-26 19:00:00','2014-08-20 10:00:00','Lecce-Roma','Trenitalia',40,1),(13,'2014-06-01 20:21:00','2014-06-01 08:10:00','Roma-San Francisco','Alitalia',660,1),(14,'2014-06-08 23:00:00','2014-06-08 11:15:00','Roma-Los Angeles','American Airlines',590,1),(15,'2014-06-08 23:31:00','2014-06-08 11:18:00','San Francisco-Roma','American Airlines',680,1),(16,'2014-06-15 19:29:00','2014-06-15 07:00:00','Los Angeles-Roma','American Airlines ',700,1),(17,'2014-03-20 20:00:00','2014-03-20 13:00:00','Milano-Beijing','Air China',470,1),(18,'2014-01-20 13:20:00','2014-03-20 08:30:00','Milano-Beijing','Alitalia',590,1),(19,'2014-04-01 06:00:00','2014-03-30 15:00:00','Beijing-Milano','Air China',460,1),(20,'2014-04-01 16:00:00','2014-04-01 10:00:00','Milano-Dubai','Emirates Airlines',1670,1),(21,'2014-01-28 17:00:00','2014-04-08 11:00:00','Dubai-Milano','Emirates Airlines',1500,1),(22,'2014-09-10 17:00:00','2014-09-10 07:00:00','Roma-New Delhi','India Airlines',700,1),(23,'2014-09-17 20:00:00','2014-09-17 08:00:00','New Delhi-Roma','Alitalia',850,1),(24,'2014-11-13 07:00:00','2014-11-11 08:00:00','Civitavecchia-Villa Las Estrellas','Costa Crociere',200,1),(25,'2014-11-20 06:00:00','2014-11-18 07:00:00','Villa Las Estrellas-Civitavecchia','Costa Crociere',340,1);
/*!40000 ALTER TABLE `TRANSPORTATIONMEAN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRANSPORTATIONMEANOPTIONS`
--

DROP TABLE IF EXISTS `TRANSPORTATIONMEANOPTIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRANSPORTATIONMEANOPTIONS` (
  `PACKAGEID` int(11) NOT NULL,
  `TRANSPORTATIONID` int(11) NOT NULL,
  PRIMARY KEY (`PACKAGEID`,`TRANSPORTATIONID`),
  KEY `FK_TRANSPORTATIONMEANOPTIONS_TRANSPORTATIONID` (`TRANSPORTATIONID`),
  CONSTRAINT `FK_TRANSPORTATIONMEANOPTIONS_PACKAGEID` FOREIGN KEY (`PACKAGEID`) REFERENCES `PACKAGETD` (`IDPACKAGETD`),
  CONSTRAINT `FK_TRANSPORTATIONMEANOPTIONS_TRANSPORTATIONID` FOREIGN KEY (`TRANSPORTATIONID`) REFERENCES `TRANSPORTATIONMEAN` (`IDTRANSPORTATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRANSPORTATIONMEANOPTIONS`
--

LOCK TABLES `TRANSPORTATIONMEANOPTIONS` WRITE;
/*!40000 ALTER TABLE `TRANSPORTATIONMEANOPTIONS` DISABLE KEYS */;
INSERT INTO `TRANSPORTATIONMEANOPTIONS` VALUES (1,2),(7,2),(8,2),(1,3),(7,3),(8,3),(1,5),(7,5),(8,5),(2,6),(9,6),(13,6),(2,7),(9,7),(13,7),(2,8),(9,8),(13,8),(3,9),(10,9),(3,10),(10,10),(3,11),(10,11),(3,12),(10,12),(4,13),(15,13),(5,14),(11,14),(12,14),(4,15),(15,15),(5,16),(11,16),(12,16),(6,17),(14,17),(6,18),(14,18),(6,19),(14,19),(16,20),(16,21),(17,22),(17,23),(18,24),(18,25);
/*!40000 ALTER TABLE `TRANSPORTATIONMEANOPTIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRIP`
--

DROP TABLE IF EXISTS `TRIP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRIP` (
  `IDTRIP` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT '0',
  `TRIPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`IDTRIP`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRIP`
--

LOCK TABLES `TRIP` WRITE;
/*!40000 ALTER TABLE `TRIP` DISABLE KEYS */;
INSERT INTO `TRIP` VALUES (2,'Visita guidata al capolavoro di Leonardo Da Vinci','Visita al cenacolo di Leonardo Da Vinci',25,0,'2014-01-09 08:00:00'),(3,'Gita in barca a vela con istruttore','Gita in barca a vela',140,1,'2014-04-16 10:00:00'),(4,'Visita al capolavoro di Michelangelo','Visita Cappella sistina',13.5,1,'2014-12-30 10:00:00'),(5,'Visita al Colosseo con guida che spieghera\' la sua millenaria storia','Scopri il Colosseo',15,1,'2015-01-01 15:00:00'),(6,'Visita guidata al lago','Escursione sul Mar Nero',35,1,'2014-02-09 20:00:00'),(7,'Visita delle pi?? suggestive masserie salentine','Visita Masserie salentine',30,1,'2014-08-15 10:00:00'),(8,'Ingresso al Riobo per festeggiare Ferragosto','Discoteca Ferragosto',40,1,'2014-08-15 22:00:00'),(9,'Surf nella baia di SF, ma attenti agli squali!','Surf nella baia',25,1,'2014-06-03 09:00:00'),(10,'Visita guidata all\'interno del carcere piu\' famoso del mondo!','Visita Alcatraz',55,1,'2014-06-05 08:00:00'),(11,'Visita alle piu\' importanti aziende informatiche della Silicon Valley','Visita Silicon Valley',100,1,'2014-06-06 10:00:00'),(12,'Visita agli studi cinematografici piu\' famosi del mondo!','Visita Hollywood',40,1,'2014-06-10 08:00:00'),(13,'Ingresso nel parco divertimenti','Ingresso Disneyland',70,1,'2014-06-11 08:30:00'),(14,'Visita guidata alla citta\' proibita di Pechino','Visita Citta\' proibita',12,1,'2014-03-25 12:00:00'),(15,'Visita al Ferrari World si Abu Dhabi','Visita Ferrari World',50,1,'2014-04-02 10:00:00'),(16,'Visita al palazzo vela Burj Al Arab','Visita Burj Al Arab',30,1,'2014-04-04 14:00:00'),(17,'Visita al famosissmo mausoleo Taj Mahal','Visita Taj Mahal',15,1,'2014-09-08 08:00:00'),(18,'Rigenerante bagno nelle acque dell\'antartide','Bagno al fresco',0,1,'2014-11-14 15:00:00');
/*!40000 ALTER TABLE `TRIP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRIPOPTIONS`
--

DROP TABLE IF EXISTS `TRIPOPTIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRIPOPTIONS` (
  `PACKAGEID` int(11) NOT NULL,
  `TRIPID` int(11) NOT NULL,
  PRIMARY KEY (`PACKAGEID`,`TRIPID`),
  KEY `FK_TRIPOPTIONS_TRIPID` (`TRIPID`),
  CONSTRAINT `FK_TRIPOPTIONS_PACKAGEID` FOREIGN KEY (`PACKAGEID`) REFERENCES `PACKAGETD` (`IDPACKAGETD`),
  CONSTRAINT `FK_TRIPOPTIONS_TRIPID` FOREIGN KEY (`TRIPID`) REFERENCES `TRIP` (`IDTRIP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRIPOPTIONS`
--

LOCK TABLES `TRIPOPTIONS` WRITE;
/*!40000 ALTER TABLE `TRIPOPTIONS` DISABLE KEYS */;
INSERT INTO `TRIPOPTIONS` VALUES (1,4),(7,4),(8,4),(1,5),(7,5),(8,5),(2,6),(9,6),(13,6),(3,7),(10,7),(3,8),(10,8),(4,10),(15,10),(4,11),(15,11),(5,12),(11,12),(12,12),(5,13),(11,13),(12,13),(6,14),(14,14),(16,15),(16,16),(17,17),(18,18);
/*!40000 ALTER TABLE `TRIPOPTIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `EMAIL` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `SURNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES ('impiegato@gmail.com','indirizzo','mario','5f4dcc3b5aa765d61d8327deb882cf99','3333333333','rossi'),('utente1@gmail.com','Brescia','Dario','5f4dcc3b5aa765d61d8327deb882cf99','030','Ca'),('utente2@gmail.com','Puglia','Ale','5f4dcc3b5aa765d61d8327deb882cf99','2013','Ch');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS_GROUPS`
--

DROP TABLE IF EXISTS `USERS_GROUPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS_GROUPS` (
  `EMAIL` varchar(255) DEFAULT NULL,
  `GROUPNAME` varchar(255) DEFAULT NULL,
  KEY `FK_USERS_GROUPS_EMAIL` (`EMAIL`),
  CONSTRAINT `FK_USERS_GROUPS_EMAIL` FOREIGN KEY (`EMAIL`) REFERENCES `USER` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS_GROUPS`
--

LOCK TABLES `USERS_GROUPS` WRITE;
/*!40000 ALTER TABLE `USERS_GROUPS` DISABLE KEYS */;
INSERT INTO `USERS_GROUPS` VALUES ('impiegato@gmail.com','EMPLOYEE'),('utente1@gmail.com','USER'),('utente2@gmail.com','USER');
/*!40000 ALTER TABLE `USERS_GROUPS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-28 17:54:58
