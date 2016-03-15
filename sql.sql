CREATE TABLE `springtutorial`.`authorities` (
  `username` VARCHAR(60) NOT NULL,
  `authority` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));


CREATE TABLE `springtutorial`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL,
  `enabled` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`username`));


INSERT INTO `springtutorial`.`users` (username, password) values ("Mike", "hello");