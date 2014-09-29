-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 20-11-2013 a las 20:26:17
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `biblioteca`
--

CREATE TABLE IF NOT EXISTS `biblioteca` (
  `numRegistro` int(10) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  PRIMARY KEY (`numRegistro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE IF NOT EXISTS `libro` (
  `isbn` int(8) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `ediciones` int(10) NOT NULL,
  `editorial` varchar(50) DEFAULT NULL,
  `año` int(10) DEFAULT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`isbn`),
  UNIQUE KEY `isbn` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`isbn`, `titulo`, `ediciones`, `editorial`, `año`, `estado`) VALUES
(8976, 'matematica', 7, 'festpawl', 2012, 'libre'),
(123123, 'ingenieria del software', 4, 'pawl', 2012, 'PRESTADO'),
(123134, 'ingenieria del software 2', 4, 'pawl', 2012, 'PRESTADO'),
(454563, 'hola mundo para todos', 6, 'laCasa', 1999, 'libre'),
(1234545, 'algebra', 7, 'editor mat', 2012, 'libre'),
(1238976, 'matematica 2', 7, 'editor', 2012, 'libre'),
(1983134, 'ingenieria electronica', 7, 'festpawl', 2012, 'libre'),
(12345678, ' linux', 1, ' redex', 2012, 'libre'),
(65656545, 'elpais', 1, 'da', 2012, 'libre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `librojava`
--

CREATE TABLE IF NOT EXISTS `librojava` (
  `titulo` varchar(40) NOT NULL,
  `edicion` int(11) NOT NULL,
  `editorial` varchar(40) NOT NULL,
  `año` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `librojava`
--

INSERT INTO `librojava` (`titulo`, `edicion`, `editorial`, `año`) VALUES
('"matematicas para todos"', 1, 'mated', 2012),
('nuevo libro', 1, 'editorial', 2012);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE IF NOT EXISTS `prestamo` (
  `prestamo` int(20) NOT NULL AUTO_INCREMENT,
  `fretiro` varchar(10) NOT NULL,
  `fdevolucion` varchar(10) DEFAULT NULL,
  `isbn` int(10) NOT NULL,
  `socio` int(20) NOT NULL,
  PRIMARY KEY (`prestamo`),
  KEY `isbn` (`isbn`),
  KEY `socio` (`socio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=53 ;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`prestamo`, `fretiro`, `fdevolucion`, `isbn`, `socio`) VALUES
(41, '20/11/2013', '20/11/2013', 8976, 1),
(42, '20/11/2013', '20/11/2013', 1234545, 2),
(43, '20/11/2013', '20/11/2013', 123123, 1),
(44, '20/11/2013', '20/11/2013', 12345678, 1),
(45, '20/11/2013', '20/11/2013', 8976, 1),
(46, '20/11/2013', '20/11/2013', 12345678, 1),
(47, '20/11/2013', '20/11/2013', 1234545, 1),
(48, '20/11/2013', '20/11/2013', 454563, 2),
(49, '20/11/2013', '20/11/2013', 8976, 5),
(50, '20/11/2013', 'nodevuelto', 123123, 5),
(51, '20/11/2013', 'nodevuelto', 123134, 5),
(52, '20/11/2013', '20/11/2013', 454563, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

CREATE TABLE IF NOT EXISTS `socio` (
  `socionum` int(10) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `rol` varchar(25) NOT NULL,
  `caracteristica` varchar(40) NOT NULL,
  `diasPrestamo` int(10) NOT NULL,
  `cantPrestamos` int(15) DEFAULT NULL,
  PRIMARY KEY (`socionum`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `socio`
--

INSERT INTO `socio` (`socionum`, `dni`, `nombre`, `rol`, `caracteristica`, `diasPrestamo`, `cantPrestamos`) VALUES
(1, '34243123', 'mariel', 'Alumno', 'lic.Sistemas', 3, 0),
(2, '35678678', 'Romina Flesler', 'Alumno', 'Cuenca', 3, 0),
(3, '34123123', 'Nicolas FLesler', 'Docente', 'Ingenieria Electronica', 15, 0),
(4, '35678687', 'Maria Fernandes', 'Alumno', 'Ingenieria Electronica', 3, 0),
(5, '35678567', 'Antonio Pers', 'Docente', 'lic.Computacion', 15, 2),
(6, '34123543', 'mariangeles Masedo', 'Alumno', 'lic.Matematica', 3, 0),
(7, '34968737', 'Roberto caceres', 'Docente', 'Medios', 15, 0),
(8, '35897964', 'maru', 'Alumno', 'Lic.Sistemas', 3, 0),
(9, '35646767', 'mariel', 'Docente', 'licsistemas', 15, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sociodocente`
--

CREATE TABLE IF NOT EXISTS `sociodocente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `materia` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sociodocente`
--

INSERT INTO `sociodocente` (`id`, `nombre`, `materia`) VALUES
(1, 'mariel', 'lic.sistemas'),
(2, 'julia', 'radiologia'),
(3, 'maria', 'matematica'),
(210, 'Sandra Gomez', 'Lengua');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socioest`
--

CREATE TABLE IF NOT EXISTS `socioest` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `materia` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `socioest`
--

INSERT INTO `socioest` (`id`, `nombre`, `materia`) VALUES
(2, 'maria', 'doctorado');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_4` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`),
  ADD CONSTRAINT `prestamo_ibfk_5` FOREIGN KEY (`socio`) REFERENCES `socio` (`socionum`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
