CREATE DATABASE  IF NOT EXISTS `useradmintest`;
USE `useradmintest`;

DROP TABLE IF EXISTS `testuser`;
CREATE TABLE `testuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `testuser` WRITE;
INSERT INTO `testuser` VALUES 
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee'),
(4,'someone@nowhere.com','sesam','customer');
UNLOCK TABLES;

CREATE DATABASE IF NOT EXISTS `useradmin`;
USE `useradmin`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES 
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee'),
(4,'someone@nowhere.com','sesam','customer');
UNLOCK TABLES;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `length` int NOT NULL,
  `height` int NOT NULL,
  `width` int NOT NULL,
  `date` date,
  PRIMARY KEY (`orderId`),
  FOREIGN KEY (`customerId`) REFERENCES `user`(`id`)
);

DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills` (
  `billId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `2x4` int NOT NULL DEFAULT 0,
  `2x2` int NOT NULL DEFAULT 0,
  `1x2` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`billId`),
  FOREIGN KEY (`orderId`) REFERENCES `orders`(`orderId`)
);






