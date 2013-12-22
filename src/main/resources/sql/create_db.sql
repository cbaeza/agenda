-- in Mysql Workbench (or console) create a new Mysql DB: Agendas
-- Then execute this script.

DROP TABLE IF EXISTS `agendas`;
CREATE TABLE `agendas` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `title` varchar(255),
  `user` varchar(255),
  `password` varchar(255),
  `url` varchar(255),
  `description` text,
  `created_at` datetime,
  `updated_at` datetime,
  PRIMARY KEY (`id`)
);

INSERT INTO `agendas` (`id`,`title`,`user`,`password`,`url`,`description`,`created_at`,`updated_at`) VALUES (1,'Google','test.user','my.secret','http://mail.google.com','a email account','2012-11-27 22:10:09.569667','2012-11-27 22:10:09.569667');
INSERT INTO `agendas` (`id`,`title`,`user`,`password`,`url`,`description`,`created_at`,`updated_at`) VALUES (1,'Bank','test.user','my.secret','http://my.bank.com','my super bank','2012-11-27 22:10:09.569667','2012-11-27 22:10:09.569667');
INSERT INTO `agendas` (`id`,`title`,`user`,`password`,`url`,`description`,`created_at`,`updated_at`) VALUES (1,'Facebook','test.user','my.secret','http://www.facebook.com','Social net','2012-11-27 22:10:09.569667','2012-11-27 22:10:09.569667');

CREATE TABLE `agendas`.`user` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`ID`));
