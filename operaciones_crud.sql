-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-08-2022 a las 07:18:56
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `operaciones_crud`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `Matricula` varchar(17) NOT NULL,
  `Nombre` varchar(17) NOT NULL,
  `Paterno` varchar(19) NOT NULL,
  `Materno` varchar(19) NOT NULL,
  `Genero` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`Matricula`, `Nombre`, `Paterno`, `Materno`, `Genero`) VALUES
('57201000174', 'ROGELIO', 'PASCUALEÑO', 'CHEPILLO', 'H'),
('57201000177', 'jose de jesus', 'navarrete', 'je', 'h'),
('77777777', 'grande', 'chepillo', 'jjjjjj', 'm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE `maestros` (
  `Id` varchar(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Paterno` varchar(19) NOT NULL,
  `Materno` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `maestros`
--

INSERT INTO `maestros` (`Id`, `Nombre`, `Paterno`, `Materno`) VALUES
('1102', 'EFRAIN', 'TECORRAL', 'CESAR'),
('1103', 'gerardo', 'ort', 'sss'),
('1115', 'hhhhh', 'jjjjjjj', 'kkkkkkkkkkkk'),
('1118', 'reyes', 'gonzales', 'gerardo'),
('1190', 'gerardo', 'colotzin', ' yadi'),
('2000', 'kjk', 'kkk', 'l'),
('6666', 'jjjjjjjjjjjjj', 'jjjjjjjjjjj', 'jjjjjjjjjjjjj'),
('9998', 'jdhfkjshdkjghdsk', 'fjdgshfhdgsk', 'jhgjdgsdfh');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `Clavemat` varchar(4) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Cuatrimestre` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`Clavemat`, `Nombre`, `Cuatrimestre`) VALUES
('0001', 'ddddd', '2'),
('1102', 'Talleres', '12'),
('1103', 'matematicas', '11'),
('1109', 'espaÃ±ol', '11');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`Matricula`);

--
-- Indices de la tabla `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`Clavemat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
