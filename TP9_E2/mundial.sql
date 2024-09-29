-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 08, 2024 at 04:21 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mundial`
--

-- --------------------------------------------------------

--
-- Table structure for table `encuentros`
--

CREATE TABLE `encuentros` (
  `id` int(11) NOT NULL,
  `equipoLocal` varchar(30) NOT NULL,
  `equipoVisitante` varchar(30) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `lugar` varchar(30) NOT NULL,
  `golesLocal` int(11) NOT NULL,
  `golesVisitante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `encuentros`
--

INSERT INTO `encuentros` (`id`, `equipoLocal`, `equipoVisitante`, `fecha`, `hora`, `lugar`, `golesLocal`, `golesVisitante`) VALUES
(1, 'Brasil', 'Argentina', '2024-06-30', '18:00:00', 'Maracaná', 2, 1),
(2, 'Alemania', 'Brasil', '2024-07-15', '21:00:00', 'Allianz Arena', 1, 1),
(3, 'España', 'Francia', '2024-07-20', '17:00:00', 'Camp Nou ', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `jugadores`
--

CREATE TABLE `jugadores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `posicion` varchar(50) NOT NULL,
  `seleccion` varchar(100) NOT NULL,
  `goles` int(11) NOT NULL,
  `asistencias` int(11) NOT NULL,
  `tarjetasAmarillas` int(11) NOT NULL,
  `tarjetasRojas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jugadores`
--

INSERT INTO `jugadores` (`id`, `nombre`, `edad`, `posicion`, `seleccion`, `goles`, `asistencias`, `tarjetasAmarillas`, `tarjetasRojas`) VALUES
(1, 'Lionel Messi', 37, 'Delantero', 'Argentina', 70, 45, 5, 1),
(2, 'Neymar', 32, 'Delantero', 'Brasil', 60, 40, 8, 2),
(3, 'Toni Kroos', 34, 'Centrocampista', 'Alemania', 25, 35, 4, 1),
(4, 'Nicolás Tagliafico ', 31, 'Defensa', 'Argentina ', 61, 40, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `selecciones`
--

CREATE TABLE `selecciones` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `medallasOro` int(11) NOT NULL,
  `medallasPlata` int(11) NOT NULL,
  `participaciones` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `selecciones`
--

INSERT INTO `selecciones` (`id`, `nombre`, `medallasOro`, `medallasPlata`, `participaciones`) VALUES
(1, 'Brasil', 37, 42, 21),
(2, 'Argentina', 21, 26, 18),
(3, 'Alemania', 23, 19, 20),
(4, 'España ', 7, 17, 16);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `encuentros`
--
ALTER TABLE `encuentros`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `selecciones`
--
ALTER TABLE `selecciones`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `encuentros`
--
ALTER TABLE `encuentros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `jugadores`
--
ALTER TABLE `jugadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `selecciones`
--
ALTER TABLE `selecciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
