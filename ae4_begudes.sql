-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-01-2022 a las 11:15:13
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ae4_begudes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `begudes`
--

CREATE TABLE `begudes` (
  `id` int(11) NOT NULL,
  `nom` varchar(150) DEFAULT NULL,
  `img` varchar(150) DEFAULT NULL,
  `instrucions` varchar(500) DEFAULT NULL,
  `ingredients1` varchar(150) DEFAULT NULL,
  `ingredients2` varchar(150) DEFAULT NULL,
  `ingredients3` varchar(150) DEFAULT NULL,
  `ingredients4` varchar(150) DEFAULT NULL,
  `ingredients5` varchar(150) DEFAULT NULL,
  `mides1` varchar(150) DEFAULT NULL,
  `mides2` varchar(150) DEFAULT NULL,
  `mides3` varchar(150) DEFAULT NULL,
  `mides4` varchar(150) DEFAULT NULL,
  `mides5` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `begudes`
--

INSERT INTO `begudes` (`id`, `nom`, `img`, `instrucions`, `ingredients1`, `ingredients2`, `ingredients3`, `ingredients4`, `ingredients5`, `mides1`, `mides2`, `mides3`, `mides4`, `mides5`) VALUES
(1, '', 'https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg', 'Muddle mint leaves with sugar and lime juice. Add a splash of soda water and fill the glass with cracked ice. Pour the rum and top with soda water. Garnish and serve with straw.', 'Light rum', 'Lime', 'Sugar', 'Mint', 'Soda water', '2-3 oz ', 'Juice of 1 ', '2 tsp ', '2-4 ', ''),
(2, 'Long vodka', 'https://www.thecocktaildb.com/images/media/drink/9179i01503565212.jpg', 'Shake a tall glass with ice cubes and Angostura, coating the inside of the glass. Por the vodka onto this, add 1 slice of lime and squeeze juice out of remainder, mix with tonic, stir and voila you have a Long Vodka', 'Vodka', 'Lime', 'Angostura bitters', 'Tonic water', 'Ice', '5 cl ', '1/2 ', '4 dashes ', '1 dl Schweppes ', '4 '),
(5, 'Zorro', 'https://www.thecocktaildb.com/images/media/drink/kvvd4z1485621283.jpg', 'add all and pour black coffee and add whipped cream on top.', 'Sambuca', 'Baileys irish cream', 'White Creme de Menthe', '', '', '2 cl ', '2 cl ', '2 cl ', '', ''),
(6, 'A1', 'https://www.thecocktaildb.com/images/media/drink/2x8thr1504816928.jpg', 'Pour all ingredients into a cocktail shaker, mix and serve over ice into a chilled glass.', 'Gin', 'Grand Marnier', 'Lemon Juice', 'Grenadine', '', '1 3/4 shot ', '1 Shot ', '1/4 Shot', '1/8 Shot', ''),
(7, 'A1', 'https://www.thecocktaildb.com/images/media/drink/2x8thr1504816928.jpg', 'Pour all ingredients into a cocktail shaker, mix and serve over ice into a chilled glass.', 'Gin', 'Grand Marnier', 'Lemon Juice', 'Grenadine', '', '1 3/4 shot ', '1 Shot ', '1/4 Shot', '1/8 Shot', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `begudes`
--
ALTER TABLE `begudes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `begudes`
--
ALTER TABLE `begudes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
