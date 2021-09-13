-- --------------
-- CREATE SCHEMA
-- --------------

CREATE SCHEMA IF NOT EXISTS `gateways-manager`;

USE `gateways-manager`;

-- -----------------
-- GATEWAYS TABLE
-- -----------------
CREATE TABLE IF NOT EXISTS`gateways`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `serial` VARCHAR(255) DEFAULT NULL, 
    `name` VARCHAR(255) DEFAULT NULL, 
    `ipv4_address` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci; 


-- -------------
-- DEVICE TABLE
-- -------------
CREATE TABLE IF NOT EXISTS `device` (
	`id` SMALLINT(20) NOT NULL AUTO_INCREMENT,
    `vendor` VARCHAR(255) DEFAULT NULL,
    `date_created` DATETIME(6) DEFAULT NULL,
    `status` TINYINT(1) DEFAULT NULL, 
    `gateways_id` BIGINT(20) DEFAULT NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT `fk_gateways_id` FOREIGN KEY (`gateways_id`) REFERENCES `gateways`(`id`)
    ON UPDATE NO ACTION ON DELETE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
