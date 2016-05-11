-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2016 at 09:43 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dms`
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

INSERT INTO `folder` (`FolderID`, `FolderNaziv`, `KreiraoKorisnikID`, `RoditeljFolderID`, `Aktivan`) VALUES
(2, 'Menadžment', 1, NULL, b'1'),
(4, 'Fakture', 1, 2, b'1');

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

INSERT INTO `folderxgrupa` (`FolderXGrupaID`, `GrupaID`, `FolderID`, `PravoSkidanja`, `PravoDodavanja`, `Aktivan`) VALUES
(1, 1, 2, b'1', b'1', b'1'),
(3, 1, 4, b'1', b'1', b'1');

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

INSERT INTO `grupa` (`GrupaID`, `GrupaNaziv`, `OdgovorniKorisnikID`, `DatumKreiranja`, `Aktivan`) VALUES
(1, 'Menadzment', 3, NULL, b'1'),
(2, 'Razvoj', 4, NULL, b'1');

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

INSERT INTO `grupaxkorisnik` (`GrupaXKorisnikID`, `GrupaID`, `KorisnikID`, `DatumPristupa`, `DatumZadnjeIzmjene`, `Aktivan`) VALUES
(1, 1, 1, NULL, NULL, b'1'),
(2, 2, 1, NULL, NULL, b'1');

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
  `Aktivan` varchar(45) NOT NULL,
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

INSERT INTO `korisnik` (`KorisnikID`, `Ime`, `Prezime`, `Adresa`, `DatumRodjenja`, `Username`, `Password`, `KorisnikTipID`, `KorisnikPozicijaID`, `Aktivan`) VALUES
(1, 'Muhamed', 'Smajevic', 'Minhen 12', NULL, 'muhamed', 'muhamed123', NULL, NULL, b'1'),
(2, 'Muhamed', 'Smajevic', 'Minhen 12', NULL, 'muha', 'muha123', 1, 1, b'1'),
(3, 'Elvedin', 'Sinanovic', 'Sarajevo Kampus', '2016-05-11 00:12:39', 'elvedin', '[C@254c2498', 1, 1, b'1'),
(4, 'Ragib', 'Smajic', 'Vils', '2016-05-11 00:15:17', 'ragib', 'ragib123', 1, 1, b'1'),
(5, 'Kenan', 'Prses', 'Vratnik', '2016-05-11 18:29:15', 'kenan', 'kenan123', 1, 1, b'1');

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

INSERT INTO `korisnikpozicija` (`KorisnikPozicijaID`, `KorisnikPozicijaNaziv`, `Aktivan`) VALUES
(1, 'Direktor', b'1');

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

INSERT INTO `korisniktip` (`KorisnikTipID`, `KorisnikTipNaziv`, `Aktivan`) VALUES
(1, 'Administrator', b'1');

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
ALTER TABLE `dokument`
  ADD CONSTRAINT `fk_Dokument_Folder1` FOREIGN KEY (`FolderID`) REFERENCES `folder` (`FolderID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `dokumentverzija`
--
ALTER TABLE `dokumentverzija`
  ADD CONSTRAINT `fk_DokumentVerzija_Dokument1` FOREIGN KEY (`DokumentID`) REFERENCES `dokument` (`DokumentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DokumentVerzija_DokumentVerzijaStatus1` FOREIGN KEY (`DokumentVerzijaStatusID`) REFERENCES `dokumentverzijastatus` (`DokumentVerzijaStatusID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DokumentVerzija_Korisnik1` FOREIGN KEY (`PostavioKorisnikID`) REFERENCES `mdms`.`korisnik` (`KorisnikID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `folder`
--
ALTER TABLE `folder`
  ADD CONSTRAINT `fk_Folder_Folder1` FOREIGN KEY (`RoditeljFolderID`) REFERENCES `folder` (`FolderID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Folder_Korisnik1` FOREIGN KEY (`KreiraoKorisnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `folderxgrupa`
--
ALTER TABLE `folderxgrupa`
  ADD CONSTRAINT `fk_FolderXGrupa_Folder1` FOREIGN KEY (`FolderID`) REFERENCES `folder` (`FolderID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_FolderXGrupa_Grupa1` FOREIGN KEY (`GrupaID`) REFERENCES `grupa` (`GrupaID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `grupa`
--
ALTER TABLE `grupa`
  ADD CONSTRAINT `fk_Grupa_Korisnik1` FOREIGN KEY (`OdgovorniKorisnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `grupaxkorisnik`
--
ALTER TABLE `grupaxkorisnik`
  ADD CONSTRAINT `fk_GrupaXKorisnik_Grupa1` FOREIGN KEY (`GrupaID`) REFERENCES `grupa` (`GrupaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_GrupaXKorisnik_Korisnik1` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `komentar`
--
ALTER TABLE `komentar`
  ADD CONSTRAINT `fk_Komentar_DokumentVerzija1` FOREIGN KEY (`DokumentVerzijaID`) REFERENCES `dokumentverzija` (`DokumentVerzijaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Komentar_Korisnik1` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD CONSTRAINT `fk_Korisnik_KorisnikPozicija1` FOREIGN KEY (`KorisnikPozicijaID`) REFERENCES `korisnikpozicija` (`KorisnikPozicijaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Korisnik_KorisnikTip` FOREIGN KEY (`KorisnikTipID`) REFERENCES `korisniktip` (`KorisnikTipID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `zahtjev`
--
ALTER TABLE `zahtjev`
  ADD CONSTRAINT `fk_Zahtjev_DokumentVerzija1` FOREIGN KEY (`DokumentVerzijaID`) REFERENCES `dokumentverzija` (`DokumentVerzijaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Zahtjev_Korisnik1` FOREIGN KEY (`KreiraoKorisnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Zahtjev_Korisnik2` FOREIGN KEY (`UpucenoKorisnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Zahtjev_ZahjtevStatus1` FOREIGN KEY (`ZahtjevStatusID`) REFERENCES `zahtjevstatus` (`ZahjtevStatusID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Zahtjev_ZahtjevTip1` FOREIGN KEY (`ZahtjevTipID`) REFERENCES `zahtjevtip` (`ZahtjevTipID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
