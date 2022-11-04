CREATE DATABASE `FightingRooster` DEFAULT CHARACTER SET UTF8MB4;

USE `FightingRooster`;

DROP TABLE IF EXISTS `fighter`;
CREATE TABLE `fighter` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CharName` CHAR(50) NOT NULL DEFAULT '',
  `Title` CHAR(50) NOT NULL DEFAULT '',
  `PowerUds` int NOT NULL DEFAULT 0,
  `Element` CHAR(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO `fighter` VALUES (0,'Nahida','La niña de los porros',2500,'Dendro');
INSERT INTO `fighter` VALUES(0,'Tanos','El Rey de los Monos',12,'Java');
