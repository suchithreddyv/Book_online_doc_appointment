-- MySQL dump 10.13  Distrib 5.6.49, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cl_project
-- ------------------------------------------------------
-- Server version	5.6.49-log

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
-- Table structure for table `book_appointment`
--

DROP TABLE IF EXISTS `book_appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_appointment` (
  `name` varchar(20) NOT NULL,
  `concern` varchar(150) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `mobileno` bigint(20) DEFAULT NULL,
  `doctorname` varchar(50) DEFAULT NULL,
  `Id` int(11) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_appointment`
--

LOCK TABLES `book_appointment` WRITE;
/*!40000 ALTER TABLE `book_appointment` DISABLE KEYS */;
INSERT INTO `book_appointment` VALUES ('Veera raju','mild heart concerns and stunt operation','2020-09-10',8205478596,'Dr.Aman Krishna',1000,NULL),('Balaram naidu','serious heart failure,need to get admitted','2020-09-17',9236547805,'Dr.Aman Krishna',1001,'cancelled'),('Surekha','skin rashes and ichiness','2020-09-24',8749562401,'Dr.Madhuri Reddy',1002,NULL),('preethi sharma','Itching','2020-09-23',7015785496,'Dr.Madhuri Reddy',1003,'confirmed'),('Parth','Laproscopy','2020-09-08',9951888827,'Dr.Suchith Reddy',1004,NULL),('Bharghav ','Thyroid Surgery','2020-09-23',7658402551,'Dr.Suchith Reddy',1005,'confirmed'),('manish','dental ache and bleeding gums','2020-09-15',9015470085,'Dr.Rajashekhar Reddy',1006,'cancelled'),('saloni ','stomach ache','2020-09-17',8015479655,'Dr.Manjula',1007,NULL),('Mahesh goud','paralysis attack','2020-09-30',9604180405,'Dr.Vikram kumar',1008,NULL),('Sunila','Bubbles formation','2020-10-08',9674852401,'Dr.Madhuri Reddy',1009,NULL);
/*!40000 ALTER TABLE `book_appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctorinfo`
--

DROP TABLE IF EXISTS `doctorinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctorinfo` (
  `name` varchar(50) DEFAULT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `education` varchar(50) DEFAULT NULL,
  `exp` int(11) DEFAULT NULL,
  `mobileno` bigint(20) DEFAULT NULL,
  `clinicaladdress` varchar(300) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `specialisation` varchar(50) DEFAULT NULL,
  `Hospitalname` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctorinfo`
--

LOCK TABLES `doctorinfo` WRITE;
/*!40000 ALTER TABLE `doctorinfo` DISABLE KEYS */;
INSERT INTO `doctorinfo` VALUES ('Dr.Aman Krishna','1982-05-21','MBBS',12,8106188668,'Banjara hills','amank@gmail.com','aman0987','Cardiologist','Care Hospital'),('Dr.Vikram kumar','1978-03-08','MBBS',15,9951888828,'secunderabad','vikram@gmail.com','vikram1234','Neurologist','Yashoda hospital'),('Dr.Neelam khanna','1986-10-23','MBBS',7,9856321407,'Panjagutta','neelam@gmail.com','khanna1234','Cardiologist','KIMS hospital'),('Dr.Parwesh agarwal','1979-03-18','MBBS',17,8579641022,'Begumpet','pagarwal@gmail.com','agarwal0987','Neurologist','NIMS Hospital'),('Dr.Ishaan Awasthi','1982-05-30','BDS',10,9657481202,'kukatpally','ishaan@gmail.com','awasthi123','Dentist','Sunshine Hospital'),('Dr.Mamatha Benerjee','1991-02-01','MD',8,8759641023,'Gandipet','mamatha@gmail.com','mamatha1234','Gynacologist','Yashoda hospital'),('Dr.Suchith Reddy','1991-09-30','MBBS',10,9010561888,'Kompally','suchithreddy@gmail.com','reddy1234','General Surgeon','Russh Hospital'),('Dr.Madhuri Reddy','1992-09-04','MD',8,8596412037,'Lothkunta','madhuri@gmail.com','madhuri1234','dermatologist','Suraksha Hospital'),('Dr.Lavanya Reddy','1983-04-29','MD',9,7013695482,'DilshukNagar','lavanya@gmail.com','lavanya1234','Opthamologist','NIMS Hospital'),('Dr.Vikas reddy','1993-06-08','MBBS',8,9685812424,'Uppal','vikas@gmail.com','vikas1234','Physiotherapist','Sunshine Hospital'),('Dr.Virat Raj','1988-08-17','MBBS',11,8741236955,'Manikonda','virat@gmail.com','viratkohli','General Surgeon','NIMS Hospital'),('Dr.Anushka Sharma','1989-05-19','MD',9,9246995768,'ECIL','anushka@gmail.com','sharma0987','Pediatrician','Trinity hospital'),('Dr.Rajashekhar Reddy','1980-03-12','BDS',13,8475962135,'LB Nagar','rajashekhar@gmail.com','reddy0987','Dentist','Kamineni Hospital'),('Dr.Vinod Rathod','1989-09-25','MBBS',11,9325478236,'Ramanthapur','vinod@gmail.com','rathod1234','Pyscologist','Apollo Hospital'),('Dr.Manjula','1984-12-17','MD',9,7036412589,'Sainikpuri','manjula@gmail.com','manju1234','Gynacologist','KIMS hospital');
/*!40000 ALTER TABLE `doctorinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patientinfo`
--

DROP TABLE IF EXISTS `patientinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientinfo` (
  `name` varchar(50) DEFAULT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobileno` bigint(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientinfo`
--

LOCK TABLES `patientinfo` WRITE;
/*!40000 ALTER TABLE `patientinfo` DISABLE KEYS */;
INSERT INTO `patientinfo` VALUES ('Raju ','1992-11-09','raju@gmail.com',9547566212,'raju0987'),('mohan','1989-08-08','mohan@yahoo.com',7015864958,'mohan0987'),('Krishna','1999-04-07','krishna@gmail.com',8547921036,'krish0987'),('jahnavi ','2003-12-22','jahnavi@gmail.com',8546921753,'janu0987'),('meghana reddy','1995-03-28','meghana@gmail.com',9547236114,'megh0987'),('sarthak raj','1992-05-28','sraj@gmail.com',9621487550,'rajsarthak0987'),('mukundh swamy','1987-01-06','mukundh@gmail.com',8546217002,'swamy0987'),('Bharghavi','2006-07-30','bharghavi@gmail.com',7158620335,'bhargavi098'),('Nihar','1999-02-28','nihar@gmail.com',9010156888,'nihar0987'),('priya','1996-02-18','priya@gmail.com',9412035504,'priya0987'),('Balram naidu','1980-05-08','balram@gmail.com',9236547805,'Naidu0987'),('Veera raju','1987-08-16','veera@gmail.com',8205478596,'veera1234'),('Surekha','1979-10-10','surekha@gmail.com',8749562401,'surekha1234'),('preethi sharma','1989-01-31','sharma@gmail.com',7015785496,'preethi0987'),('parth','1991-08-27','parth@gmail.com',9951888827,'parth0987'),('Bharghav','1985-12-07','bhargav@gmail.com',7658402551,'bhargav123'),('manish','1989-02-12','manish@gmail.com',9015470085,'manish123'),('saloni','1990-04-29','saloni@gmail.com',8015479655,'saloni0987'),('Mahesh goud','1980-07-14','mahesh@gmail.com',9604180405,'goud0987');
/*!40000 ALTER TABLE `patientinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating_review`
--

DROP TABLE IF EXISTS `rating_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating_review` (
  `rating` int(11) DEFAULT NULL,
  `review` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating_review`
--

LOCK TABLES `rating_review` WRITE;
/*!40000 ALTER TABLE `rating_review` DISABLE KEYS */;
INSERT INTO `rating_review` VALUES (3,'Good Service'),(3,'Easy Way of booking appointments');
/*!40000 ALTER TABLE `rating_review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-07 15:14:43
