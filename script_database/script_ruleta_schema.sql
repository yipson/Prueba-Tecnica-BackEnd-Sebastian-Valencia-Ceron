-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ruleta
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ruleta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ruleta` DEFAULT CHARACTER SET latin1 ;
USE `ruleta` ;

-- -----------------------------------------------------
-- Table `ruleta`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ruleta`.`usuarios` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ruleta`.`mesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ruleta`.`mesas` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `disponible` CHAR(1) NULL DEFAULT NULL,
  `id_jugador` BIGINT(20) NULL DEFAULT NULL,
  `apuesta` DOUBLE NULL DEFAULT NULL,
  `resultado_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `resultado_final` VARCHAR(45) NULL DEFAULT NULL,
  `recaudo_mesa` DOUBLE NULL DEFAULT NULL,
  `recaudo_usuario` DOUBLE NULL DEFAULT NULL,
  `usuario_gano` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_mesa_jugador`
    FOREIGN KEY (`id_jugador`)
    REFERENCES `ruleta`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_mesa_jugador_idx` ON `ruleta`.`mesas` (`id_jugador` ASC);


-- -----------------------------------------------------
-- Table `ruleta`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ruleta`.`roles` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `id_usuario` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `roles_ibfk_1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `ruleta`.`usuarios` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `id_usuario` ON `ruleta`.`roles` (`id_usuario` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
