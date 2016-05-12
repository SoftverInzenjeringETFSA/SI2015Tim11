-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2016 at 10:48 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dms_old`
--
CREATE DATABASE IF NOT EXISTS `dms` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dms`;

-- --------------------------------------------------------

--
-- Table structure for table `basedbmodel`
--

CREATE TABLE IF NOT EXISTS `basedbmodel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `dokument`
--

CREATE TABLE IF NOT EXISTS `dokument` (
  `DokumentID` int(11) NOT NULL AUTO_INCREMENT,
  `FolderID` int(11) DEFAULT NULL,
  `DokumentNaziv` varchar(200) DEFAULT NULL,
  `Ekstenzija` varchar(15) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`DokumentID`),
  KEY `fk_Dokument_Folder1_idx` (`FolderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `dokumentverzija`
--

CREATE TABLE IF NOT EXISTS `dokumentverzija` (
  `DokumentVerzijaID` int(11) NOT NULL AUTO_INCREMENT,
  `DokumentID` int(11) DEFAULT NULL,
  `PostavioKorisnikID` int(11) DEFAULT NULL,
  `DokumentVerzijaStatusID` int(11) DEFAULT NULL,
  `Sadrzaj` blob,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`DokumentVerzijaID`),
  KEY `fk_DokumentVerzija_Dokument1_idx` (`DokumentID`),
  KEY `fk_DokumentVerzija_Korisnik1_idx` (`PostavioKorisnikID`),
  KEY `fk_DokumentVerzija_DokumentVerzijaStatus1_idx` (`DokumentVerzijaStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `dokumentverzijastatus`
--

CREATE TABLE IF NOT EXISTS `dokumentverzijastatus` (
  `DokumentVerzijaStatusID` int(11) NOT NULL AUTO_INCREMENT,
  `DokumentVerzijaStatusNaziv` varchar(100) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`DokumentVerzijaStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `folder`
--

CREATE TABLE IF NOT EXISTS `folder` (
  `FolderID` int(11) NOT NULL AUTO_INCREMENT,
  `FolderNaziv` varchar(100) DEFAULT NULL,
  `KreiraoKorisnikID` int(11) DEFAULT NULL,
  `RoditeljFolderID` int(11) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`FolderID`),
  KEY `fk_Folder_Korisnik1_idx` (`KreiraoKorisnikID`),
  KEY `fk_Folder_Folder1_idx` (`RoditeljFolderID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `folder`
--
-- --------------------------------------------------------

--
-- Table structure for table `folderxgrupa`
--

CREATE TABLE IF NOT EXISTS `folderxgrupa` (
  `FolderXGrupaID` int(11) NOT NULL AUTO_INCREMENT,
  `GrupaID` int(11) DEFAULT NULL,
  `FolderID` int(11) DEFAULT NULL,
  `PravoSkidanja` bit(1) DEFAULT NULL,
  `PravoDodavanja` bit(1) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`FolderXGrupaID`),
  KEY `fk_FolderXGrupa_Grupa1_idx` (`GrupaID`),
  KEY `fk_FolderXGrupa_Folder1_idx` (`FolderID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `folderxgrupa`
--
-- --------------------------------------------------------

--
-- Table structure for table `grupa`
--

CREATE TABLE IF NOT EXISTS `grupa` (
  `GrupaID` int(11) NOT NULL AUTO_INCREMENT,
  `GrupaNaziv` varchar(300) DEFAULT NULL,
  `OdgovorniKorisnikID` int(11) DEFAULT NULL,
  `DatumKreiranja` datetime DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`GrupaID`),
  KEY `fk_Grupa_Korisnik1_idx` (`OdgovorniKorisnikID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `grupa`
--

-- --------------------------------------------------------

--
-- Table structure for table `grupaxkorisnik`
--

CREATE TABLE IF NOT EXISTS `grupaxkorisnik` (
  `GrupaXKorisnikID` int(11) NOT NULL AUTO_INCREMENT,
  `GrupaID` int(11) DEFAULT NULL,
  `KorisnikID` int(11) DEFAULT NULL,
  `DatumPristupa` datetime DEFAULT NULL,
  `DatumZadnjeIzmjene` datetime DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`GrupaXKorisnikID`),
  KEY `fk_GrupaXKorisnik_Grupa1_idx` (`GrupaID`),
  KEY `fk_GrupaXKorisnik_Korisnik1_idx` (`KorisnikID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `grupaxkorisnik`
--

-- --------------------------------------------------------

--
-- Table structure for table `komentar`
--

CREATE TABLE IF NOT EXISTS `komentar` (
  `KomentarID` int(11) NOT NULL AUTO_INCREMENT,
  `KorisnikID` int(11) DEFAULT NULL,
  `DokumentVerzijaID` int(11) DEFAULT NULL,
  `Komentar` varchar(400) DEFAULT NULL,
  `DatumVrijemeKomentara` datetime DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`KomentarID`),
  KEY `fk_Komentar_DokumentVerzija1_idx` (`DokumentVerzijaID`),
  KEY `fk_Komentar_Korisnik1_idx` (`KorisnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
  `KorisnikID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(50) DEFAULT NULL,
  `Prezime` varchar(50) DEFAULT NULL,
  `Adresa` varchar(200) DEFAULT NULL,
  `DatumRodjenja` datetime DEFAULT NULL,
  `Username` varchar(200) DEFAULT NULL,
  `Password` varchar(300) DEFAULT NULL,
  `KorisnikTipID` int(11) DEFAULT NULL,
  `KorisnikPozicijaID` int(11) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`KorisnikID`),
  KEY `fk_Korisnik_KorisnikTip_idx` (`KorisnikTipID`),
  KEY `fk_Korisnik_KorisnikPozicija1_idx` (`KorisnikPozicijaID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `korisnik`
--
-- --------------------------------------------------------

--
-- Table structure for table `korisnikpozicija`
--

CREATE TABLE IF NOT EXISTS `korisnikpozicija` (
  `KorisnikPozicijaID` int(11) NOT NULL AUTO_INCREMENT,
  `KorisnikPozicijaNaziv` varchar(200) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`KorisnikPozicijaID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `korisnikpozicija`
--
-- --------------------------------------------------------

--
-- Table structure for table `korisniktip`
--

CREATE TABLE IF NOT EXISTS `korisniktip` (
  `KorisnikTipID` int(11) NOT NULL AUTO_INCREMENT,
  `KorisnikTipNaziv` varchar(200) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`KorisnikTipID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `korisniktip`
--
-- --------------------------------------------------------

--
-- Table structure for table `zahtjev`
--

CREATE TABLE IF NOT EXISTS `zahtjev` (
  `ZahtjevID` int(11) NOT NULL AUTO_INCREMENT,
  `DatumVrijemeKreiranja` datetime DEFAULT NULL,
  `KreiraoKorisnikID` int(11) DEFAULT NULL,
  `UpucenoKorisnikID` int(11) DEFAULT NULL,
  `ZahtjevTipID` int(11) DEFAULT NULL,
  `ZahtjevStatusID` int(11) DEFAULT NULL,
  `DokumentVerzijaID` int(11) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`ZahtjevID`),
  KEY `fk_Zahtjev_Korisnik1_idx` (`KreiraoKorisnikID`),
  KEY `fk_Zahtjev_Korisnik2_idx` (`UpucenoKorisnikID`),
  KEY `fk_Zahtjev_ZahtjevTip1_idx` (`ZahtjevTipID`),
  KEY `fk_Zahtjev_ZahjtevStatus1_idx` (`ZahtjevStatusID`),
  KEY `fk_Zahtjev_DokumentVerzija1_idx` (`DokumentVerzijaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `zahtjevstatus`
--

CREATE TABLE IF NOT EXISTS `zahtjevstatus` (
  `ZahjtevStatusID` int(11) NOT NULL AUTO_INCREMENT,
  `ZahjtevStatusNaziv` varchar(100) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`ZahjtevStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `zahtjevtip`
--

CREATE TABLE IF NOT EXISTS `zahtjevtip` (
  `ZahtjevTipID` int(11) NOT NULL AUTO_INCREMENT,
  `ZahtjevTipNaziv` varchar(100) DEFAULT NULL,
  `Aktivan` bit(1) NOT NULL,
  PRIMARY KEY (`ZahtjevTipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dokument`
--
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
