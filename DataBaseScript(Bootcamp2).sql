-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bootcamp2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bootcamp2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bootcamp2` DEFAULT CHARACTER SET utf8 ;
USE `bootcamp2` ;

-- -----------------------------------------------------
-- Table `bootcamp2`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp2`.`Country` (
  `id_country` INT NOT NULL AUTO_INCREMENT,
  `country_code2` VARCHAR(2) NOT NULL,
  `country_code3` VARCHAR(3) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_country`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp2`.`State`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp2`.`State` (
  `id_state` INT NOT NULL AUTO_INCREMENT,
  `country_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `area` MEDIUMTEXT NOT NULL,
  `capital` VARCHAR(100) NOT NULL,
  `abbrev` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id_state`),
  CONSTRAINT `country`
    FOREIGN KEY (`country_id`)
    REFERENCES `bootcamp2`.`Country` (`id_country`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp2`.`City`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp2`.`City` (
  `id_city` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `weather_id` INT NOT NULL,
  `state_id` INT NOT NULL,
  PRIMARY KEY (`id_city`),
  CONSTRAINT `state`
    FOREIGN KEY (`state_id`)
    REFERENCES `bootcamp2`.`State` (`id_state`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp2`.`Wind`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp2`.`Wind` (
  `id_wind` INT NOT NULL AUTO_INCREMENT,
  `speed` INT NOT NULL,
  `direction` INT NOT NULL,
  PRIMARY KEY (`id_wind`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp2`.`Atmosphere`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp2`.`Atmosphere` (
  `id_atmosphere` INT NOT NULL AUTO_INCREMENT,
  `humidity` INT NOT NULL,
  `visibility` INT NOT NULL,
  `rising` INT NOT NULL,
  `pressure` DOUBLE NOT NULL,
  PRIMARY KEY (`id_atmosphere`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp2`.`Actual_weather`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp2`.`Actual_weather` (
  `id_actualWeather` INT NOT NULL AUTO_INCREMENT,
  `temperature` DOUBLE NOT NULL,
  `description` TEXT NOT NULL,
  `date` TEXT NOT NULL,
  PRIMARY KEY (`id_actualWeather`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp2`.`Extended_weather`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp2`.`Extended_weather` (
  `id_extended_weather` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NOT NULL,
  `weekday` VARCHAR(20) NOT NULL,
  `maximum` DOUBLE NOT NULL,
  `minimum` DOUBLE NOT NULL,
  `date` TEXT NOT NULL,
  PRIMARY KEY (`id_extended_weather`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp2`.`Weather`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp2`.`Weather` (
  `id_weather` INT NOT NULL AUTO_INCREMENT,
  `city_id` INT NOT NULL,
  `wind_id` INT NOT NULL,
  `atmosphere_id` INT NOT NULL,
  `actual_weather_id` INT NOT NULL,
  `extended_weather_id` INT NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`id_weather`),
  INDEX `wind_idx` (`wind_id` ASC),
  INDEX `atmosphere_idx` (`atmosphere_id` ASC),
  INDEX `today_weather_idx` (`actual_weather_id` ASC),
  INDEX `extended_weather_idx` (`extended_weather_id` ASC),
  INDEX `city_idx` (`city_id` ASC),
  CONSTRAINT `wind`
    FOREIGN KEY (`wind_id`)
    REFERENCES `bootcamp2`.`Wind` (`id_wind`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `atmosphere`
    FOREIGN KEY (`atmosphere_id`)
    REFERENCES `bootcamp2`.`Atmosphere` (`id_atmosphere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `today_weather`
    FOREIGN KEY (`actual_weather_id`)
    REFERENCES `bootcamp2`.`Actual_weather` (`id_actualWeather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `extended_weather`
    FOREIGN KEY (`extended_weather_id`)
    REFERENCES `bootcamp2`.`Extended_weather` (`id_extended_weather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `city`
    FOREIGN KEY (`city_id`)
    REFERENCES `bootcamp2`.`City` (`id_city`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
