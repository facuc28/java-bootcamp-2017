-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bootcamp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bootcamp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bootcamp` DEFAULT CHARACTER SET utf8 ;
USE `bootcamp` ;

-- -----------------------------------------------------
-- Table `bootcamp`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`country` (
  `idcountry` INT NOT NULL AUTO_INCREMENT,
  `country_code2` VARCHAR(2) NOT NULL,
  `country_code3` VARCHAR(3) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idcountry`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`state` (
  `idstate` INT NOT NULL AUTO_INCREMENT,
  `country_code2` VARCHAR(2) NOT NULL,
  `country_code3` VARCHAR(3) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `area` MEDIUMTEXT NOT NULL,
  `capital` TEXT NOT NULL,
  PRIMARY KEY (`idstate`),
  CONSTRAINT `country`
    FOREIGN KEY (`idstate`)
    REFERENCES `bootcamp`.`country` (`idcountry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp`.`weather`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`weather` (
  `idweather` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`idweather`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`city` (
  `idcity` INT NOT NULL AUTO_INCREMENT,
  `country_code2` VARCHAR(2) NOT NULL,
  `country_code3` VARCHAR(3) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `id_weather` INT NOT NULL,
  PRIMARY KEY (`idcity`),
  INDEX `weather_idx` (`id_weather` ASC),
  CONSTRAINT `state`
    FOREIGN KEY (`idcity`)
    REFERENCES `bootcamp`.`state` (`idstate`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `weather`
    FOREIGN KEY (`id_weather`)
    REFERENCES `bootcamp`.`weather` (`idweather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp`.`wind`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`wind` (
  `idwind` INT NOT NULL AUTO_INCREMENT,
  `speed` INT NOT NULL,
  `direction` INT NOT NULL,
  `id_weather` INT NOT NULL,
  PRIMARY KEY (`idwind`),
  INDEX `windWeather_idx` (`id_weather` ASC),
  CONSTRAINT `windWeather`
    FOREIGN KEY (`id_weather`)
    REFERENCES `bootcamp`.`weather` (`idweather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp`.`atmosphere`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`atmosphere` (
  `idatmosphere` INT NOT NULL AUTO_INCREMENT,
  `humidity` INT NOT NULL,
  `pressure` DOUBLE NOT NULL,
  `visibility` INT NOT NULL,
  `rising` INT NOT NULL,
  `id_atmosphere` INT NOT NULL,
  `id_weather` INT NOT NULL,
  PRIMARY KEY (`idatmosphere`),
  INDEX `atmosphereWeather_idx` (`id_weather` ASC),
  CONSTRAINT `atmosphereWeather`
    FOREIGN KEY (`id_weather`)
    REFERENCES `bootcamp`.`weather` (`idweather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp`.`actual`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`actual` (
  `idactual` INT NOT NULL AUTO_INCREMENT,
  `temperature` DOUBLE NOT NULL,
  `description` TEXT NOT NULL,
  `date` DATE NOT NULL,
  `id_weather` INT NOT NULL,
  PRIMARY KEY (`idactual`),
  INDEX `weather_idx` (`id_weather` ASC),
  CONSTRAINT `actualWeather`
    FOREIGN KEY (`id_weather`)
    REFERENCES `bootcamp`.`weather` (`idweather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamp`.`extended`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`extended` (
  `idextended` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `description` TEXT NOT NULL,
  `weekday` VARCHAR(15) NOT NULL,
  `maximum` DOUBLE NOT NULL,
  `minimum` DOUBLE NOT NULL,
  `id_weather` INT NOT NULL,
  PRIMARY KEY (`idextended`),
  INDEX `weather_idx` (`id_weather` ASC),
  CONSTRAINT `extendedWeather`
    FOREIGN KEY (`id_weather`)
    REFERENCES `bootcamp`.`weather` (`idweather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
