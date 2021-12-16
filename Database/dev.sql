-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 16 dec 2021 om 11:43
-- Serverversie: 10.1.38-MariaDB
-- PHP-versie: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dev`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `algemeen`
--

CREATE TABLE `algemeen` (
  `id` int(20) NOT NULL,
  `machine` varchar(20) DEFAULT NULL,
  `persoon` varchar(20) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `overtime` int(11) NOT NULL,
  `materiaal` varchar(30) DEFAULT NULL,
  `batch` varchar(30) DEFAULT NULL,
  `bekken` varchar(30) DEFAULT NULL,
  `bekken_merk` varchar(30) DEFAULT NULL,
  `messen` varchar(30) DEFAULT NULL,
  `draad` varchar(30) DEFAULT NULL,
  `geen_orders` varchar(30) DEFAULT NULL,
  `overig_spijkermakerij` varchar(30) DEFAULT NULL,
  `geen_draad` varchar(30) DEFAULT NULL,
  `onderhoud` varchar(30) DEFAULT NULL,
  `overig_kantoor` varchar(30) DEFAULT NULL,
  `stilstand` varchar(30) DEFAULT NULL,
  `draad_info` varchar(255) DEFAULT NULL,
  `draad_merk` varchar(255) DEFAULT NULL,
  `foutcode_11` varchar(255) DEFAULT NULL,
  `opmerking_foutcode11` varchar(255) DEFAULT NULL,
  `overig_algemeen` varchar(255) DEFAULT NULL,
  `timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `spijkers`
--

CREATE TABLE `spijkers` (
  `id` int(11) NOT NULL,
  `machine` varchar(30) NOT NULL,
  `productiesnelheid` int(11) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `algemeen`
--
ALTER TABLE `algemeen`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `spijkers`
--
ALTER TABLE `spijkers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `algemeen`
--
ALTER TABLE `algemeen`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `spijkers`
--
ALTER TABLE `spijkers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
