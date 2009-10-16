SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `programmers` DEFAULT CHARACTER SET utf8 ;
USE `programmers`;

-- -----------------------------------------------------
-- Table `programmers`.`programmers`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `programmers`.`programmers` (
  `name` VARCHAR(45) NULL DEFAULT 'no-name' ,
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NULL DEFAULT 'available' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `programmers`.`tasks`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `programmers`.`tasks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT 'no-name' ,
  `status` VARCHAR(45) NULL DEFAULT NULL ,
  `nopeople` INT NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `programmers`.`assingments`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `programmers`.`assingments` (
  `assID` INT NOT NULL AUTO_INCREMENT,
  `prgID` INT NULL DEFAULT NULL ,
  `tskID` INT NULL DEFAULT NULL ,
  INDEX `prFK` (`prgID` ASC) ,
  INDEX `tskFK` (`tskID` ASC) ,
  CONSTRAINT `prFK`
    FOREIGN KEY (`prgID` )
    REFERENCES `programmers`.`programmers` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `tskFK`
    FOREIGN KEY (`tskID` )
    REFERENCES `programmers`.`tasks` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
   PRIMARY KEY (`assID`))
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `programmers`.`programmers`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `programmers`;
INSERT INTO `programmers` (`name`, `id`) VALUES ('Ioana', 0);
INSERT INTO `programmers` (`name`, `id`) VALUES ('Carmen', 1);
INSERT INTO `programmers` (`name`, `id`) VALUES ('Adriana', 2);
INSERT INTO `programmers` (`name`, `id`) VALUES ('George', 10);

COMMIT;
