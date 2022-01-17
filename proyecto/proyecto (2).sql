-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-01-2022 a las 07:04:14
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id` bigint(20) NOT NULL,
  `nombrecliente` varchar(100) DEFAULT NULL,
  `identificacioncliente` varchar(13) DEFAULT NULL,
  `nombreproducto` varchar(150) NOT NULL,
  `cantidadproducto` int(11) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `correocliente` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`id`, `nombrecliente`, `identificacioncliente`, `nombreproducto`, `cantidadproducto`, `estado`, `correocliente`) VALUES
(1, 'Steven Jurado', '0951665041', 'Camiseta Polo', 2, 'Entregado', 'steven@jurado.com'),
(2, 'Steven Jurado', '0951665041', 'Camisa', 3, 'Empaquetado', 'steven@jurado.com'),
(3, 'Steven Jurado', '0951665041', 'Camiseta Polo', 60, 'Recibido', 'steven@jurado.com'),
(4, 'Edgar Chamorro', '0978563215', 'Camiseta Polo', 1, 'Empaquetado', 'edgar@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Cantidad` int(10) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  `imagen` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `Nombre`, `Cantidad`, `Categoria`, `Valor`, `imagen`) VALUES
(1, 'Camisa', 2, 'Hombre', '5.70', 'http://192.168.200.8/proyecto/Imagenes/img_camisa.jpg'),
(2, 'Camiseta Logo Adidas', 5, 'Hombre', '25.00', 'http://192.168.200.8/proyecto/Imagenes/camiseta_adidas.png'),
(3, 'Camiseta Polo', 5, 'Hombre', '15.50', 'http://192.168.200.8/proyecto/Imagenes/camiseta_polo.jpg'),
(4, 'Conjunto Deportivo', 10, 'Hombre', '50.00', 'http://192.168.200.8/proyecto/Imagenes/deportivo.jpg'),
(5, 'Pantalon Jeans ', 12, 'Hombre', '14.50', 'http://192.168.200.8/proyecto/Imagenes/jeans.jpg'),
(6, 'Camiseta Polo', 6, 'Mujer', '15.60', 'http://192.168.200.8/proyecto/Imagenes/mujerpolo.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(10) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Cedula` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `Correo`, `Password`, `Nombres`, `Cedula`) VALUES
(1, 'edgar@gmail.com', 'hola123', 'Edgar Chamorro', '0978563215'),
(2, 'jose@gmail.com', 'jose123', 'José Pepito', '0923764829'),
(3, 'jose@gmail.com', 'jose123', 'José Pepito', '0923764829'),
(4, 'julio@gmail.com', 'julio123', 'julio ', '0923654789'),
(5, 'elif@gmail.com', 'elif123', 'elif', '0923456890'),
(6, 'Jerson@gmail.com', 'jerson123', 'Jerson', '0923657899'),
(7, 'Cardenas', 'Cardenas123', 'Juan', '0934743323'),
(8, 'juan@gmail.com', 'hola', 'Juan Ernesto', '0923647894');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
