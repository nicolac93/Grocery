-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Lug 13, 2017 alle 16:49
-- Versione del server: 10.1.25-MariaDB
-- Versione PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grocery`
--
CREATE DATABASE IF NOT EXISTS `grocery` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `grocery`;

-- --------------------------------------------------------

--
-- Struttura della tabella `fascia`
--

DROP TABLE IF EXISTS `fascia`;
CREATE TABLE `fascia` (
  `idFascia` int(11) NOT NULL,
  `start` time NOT NULL,
  `end` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `fasciaOrdineFattorino`
--

DROP TABLE IF EXISTS `fasciaOrdineFattorino`;
CREATE TABLE `fasciaOrdineFattorino` (
  `idFasciaOrdineFattorino` int(11) NOT NULL,
  `idOrdine` int(11) NOT NULL,
  `idZona` int(11) NOT NULL,
  `idFascia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `fattorino`
--

DROP TABLE IF EXISTS `fattorino`;
CREATE TABLE `fattorino` (
  `idFattorino` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

DROP TABLE IF EXISTS `ordine`;
CREATE TABLE `ordine` (
  `idOrdine` int(11) NOT NULL,
  `idUtente` int(11) NOT NULL,
  `idFattorino` int(11) NOT NULL,
  `data` date NOT NULL,
  `note` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordineProdotto`
--

DROP TABLE IF EXISTS `ordineProdotto`;
CREATE TABLE `ordineProdotto` (
  `idOrdineProdotto` int(11) NOT NULL,
  `idOrdine` int(11) NOT NULL,
  `idProdotto` int(11) NOT NULL,
  `quantita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
CREATE TABLE `prodotti` (
  `idProdotto` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `scorte` int(11) NOT NULL,
  `prezzo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `ptoConsegna`
--

DROP TABLE IF EXISTS `ptoConsegna`;
CREATE TABLE `ptoConsegna` (
  `idPto` int(11) NOT NULL,
  `indirizzo` varchar(50) NOT NULL,
  `citta` varchar(50) NOT NULL,
  `idZona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `idUtente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `indirizzo` varchar(100) NOT NULL,
  `citta` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `zona`
--

DROP TABLE IF EXISTS `zona`;
CREATE TABLE `zona` (
  `idZona` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `fascia`
--
ALTER TABLE `fascia`
  ADD PRIMARY KEY (`idFascia`);

--
-- Indici per le tabelle `fasciaOrdineFattorino`
--
ALTER TABLE `fasciaOrdineFattorino`
  ADD PRIMARY KEY (`idFasciaOrdineFattorino`);

--
-- Indici per le tabelle `fattorino`
--
ALTER TABLE `fattorino`
  ADD PRIMARY KEY (`idFattorino`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`idOrdine`);

--
-- Indici per le tabelle `ordineProdotto`
--
ALTER TABLE `ordineProdotto`
  ADD PRIMARY KEY (`idOrdineProdotto`);

--
-- Indici per le tabelle `prodotti`
--
ALTER TABLE `prodotti`
  ADD PRIMARY KEY (`idProdotto`);

--
-- Indici per le tabelle `ptoConsegna`
--
ALTER TABLE `ptoConsegna`
  ADD PRIMARY KEY (`idPto`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idUtente`);

--
-- Indici per le tabelle `zona`
--
ALTER TABLE `zona`
  ADD PRIMARY KEY (`idZona`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `fascia`
--
ALTER TABLE `fascia`
  MODIFY `idFascia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `fasciaOrdineFattorino`
--
ALTER TABLE `fasciaOrdineFattorino`
  MODIFY `idFasciaOrdineFattorino` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `fattorino`
--
ALTER TABLE `fattorino`
  MODIFY `idFattorino` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `idOrdine` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `ordineProdotto`
--
ALTER TABLE `ordineProdotto`
  MODIFY `idOrdineProdotto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  MODIFY `idProdotto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `ptoConsegna`
--
ALTER TABLE `ptoConsegna`
  MODIFY `idPto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `idUtente` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `zona`
--
ALTER TABLE `zona`
  MODIFY `idZona` int(11) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
