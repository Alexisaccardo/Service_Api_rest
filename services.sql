-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-10-2023 a las 21:48:00
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `services`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `code` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `ally` varchar(30) NOT NULL,
  `creation_date` varchar(30) NOT NULL,
  `inactivation_date` varchar(30) DEFAULT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `service`
--

INSERT INTO `service` (`code`, `name`, `ally`, `creation_date`, `inactivation_date`, `status`) VALUES
('12345', 'Alexis', 'Meli', '2023-10-05T16:06:57.098541200', '2023-10-05T16:32:21.574248700', 'Inactivo'),
('32134', 'Alexis', 'Meli', '2023-10-05T16:06:57.098541200', '', 'Activo'),
('54321', 'Adriana', 'Meli', '2023-10-05T16:06:57.098541200', '2023-10-05T16:27:30.874560100', 'Inactivo');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
