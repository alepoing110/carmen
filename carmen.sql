-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-08-2021 a las 01:02:06
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carmen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anticipo`
--

CREATE TABLE `anticipo` (
  `monto` double NOT NULL,
  `fecha` date NOT NULL,
  `tipo_pago` varchar(20) NOT NULL,
  `id_servicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `anticipo`
--

INSERT INTO `anticipo` (`monto`, `fecha`, `tipo_pago`, `id_servicio`) VALUES
(100, '2021-08-20', 'Efectivo', 5),
(150, '2021-08-20', 'Efectivo', 5),
(150, '2021-08-20', 'Efectivo', 5),
(150, '2021-08-20', 'Efectivo', 5),
(234, '2021-08-20', 'Efectivo', 1),
(55, '2021-08-20', 'Efectivo', 8),
(300, '2021-08-20', 'Efectivo', 10),
(100, '2021-08-20', 'Efectivo', 12),
(12, '2021-08-20', 'Efectivo', 6),
(8, '2021-08-20', 'Efectivo', 6),
(80, '2021-08-20', 'Efectivo', 6),
(34, '2021-08-20', 'Efectivo', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` varchar(11) NOT NULL,
  `nombre` varchar(120) NOT NULL,
  `empresa` varchar(70) NOT NULL,
  `tipo_regimen` varchar(20) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `direccion` varchar(120) NOT NULL,
  `password_si` varchar(50) DEFAULT NULL,
  `usuario_si` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `empresa`, `tipo_regimen`, `telefono`, `direccion`, `password_si`, `usuario_si`) VALUES
('123456789', 'JUAN PEREZ', 'PROTESIS JUAN', 'PERSONAL', '749374937', '6 DE OCTUBRE', NULL, NULL),
('9876543', 'LUIS', 'REPUESTOS', 'INDUSTRIAL', '9887', 'CIRCUNVALACION', NULL, NULL),
('09870987', 'ROBERTO', 'ROBERTO PIZZA', 'PERSONAL', '1342', 'POTOSI Y BOLIVAR', NULL, NULL),
('76467', 'KHKG', 'GGJG', 'JFJJFJ', 'JFJ', 'JFJ', NULL, NULL),
('3506195011', 'ruth patricia leon martinez', 'unipersonal', 'servicios', '72494818', '6 de octubre', '6 de octubre', '6 de octubre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos`
--

CREATE TABLE `gastos` (
  `id` int(11) NOT NULL,
  `motivo` varchar(200) NOT NULL,
  `monto` double NOT NULL,
  `tipo` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `id_cliente` varchar(11) NOT NULL,
  `precio` double NOT NULL,
  `fecha` date NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id`, `nombre`, `id_cliente`, `precio`, `fecha`, `saldo`) VALUES
(1, 'a;lkdfj', '09870987', 234, '2021-08-03', 0),
(2, 'adf', '123456789', 234.5, '2021-08-04', 234.5),
(3, 'a;lkdfj', '123456789', 234.5, '2021-08-04', 234.5),
(4, 'Certificación RUPE', '6190213015', 300, '2021-08-20', 300),
(5, 'Certificación CERL', '09870987', 150, '2021-08-20', 0),
(6, 'Balance Gestion', '123456789', 100, '2021-08-20', 0),
(7, 'Servicio mensual', '76467', 234, '2021-08-20', 200),
(8, 'Servicio mensual', '9876543', 555, '2021-08-20', 500),
(9, 'Certificación RUPE', '09870987', 100, '2021-08-20', 100),
(10, 'Balance Gestion', '3506195011', 600, '2021-08-20', 300),
(11, 'Servicio mensual', '3506195011', 100, '2021-08-20', 100),
(12, 'Servicio mensual', '3506195011', 100, '2021-08-20', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `rol` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `password`, `rol`) VALUES
(0, 'admin', 'admin', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `gastos`
--
ALTER TABLE `gastos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `gastos`
--
ALTER TABLE `gastos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
