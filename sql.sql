CREATE TABLE `springtutorial`.`authorities` (
  `username` VARCHAR(60) NOT NULL,
  `authority` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));


CREATE TABLE `springtutorial`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL,
  `email` VARCHAR(60) NULL,
  `enabled` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`username`));


INSERT INTO `springtutorial`.`users` (username, password, email, enabled) values ("Mike", "hello", "mike@caveofprogramming.com", 1);
INSERT INTO `springtutorial`.`authorities` (username, authority) values ("Mike", "admin");