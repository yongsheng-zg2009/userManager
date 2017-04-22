-- MySQL Script generated by MySQL Workbench
-- 04/22/17 12:53:22
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema um
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema um
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `um` DEFAULT CHARACTER SET utf8 ;
USE `um` ;

-- -----------------------------------------------------
-- Table `um`.`t_um_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `um`.`t_um_user` (
  `user_name` VARCHAR(100) NOT NULL,
  `nick_name` VARCHAR(100) NULL,
  `gender` INT NULL COMMENT '0男,1女,2位置,3其他',
  `age` INT NULL,
  `dt_register_time` DATETIME NULL,
  `dt_create_time` DATETIME NULL,
  `dt_last_update_time` DATETIME NULL,
  PRIMARY KEY (`user_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `um`.`t_um_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `um`.`t_um_group` (
  `id` INT NOT NULL,
  `code` VARCHAR(45) NULL COMMENT '组名',
  `name` VARCHAR(100) NULL,
  `brief` VARCHAR(245) NULL COMMENT '描述',
  `level` INT NOT NULL DEFAULT 1,
  `parent_id` INT NOT NULL DEFAULT 0,
  `dt_create_time` DATETIME NULL,
  `dt_update_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `um`.`t_um_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `um`.`t_um_permission` (
  `id` INT NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `level` INT NOT NULL DEFAULT 1 COMMENT '权限级别',
  `parent_id` INT NOT NULL DEFAULT 0,
  `dt_create_time` DATETIME NOT NULL,
  `dt_update_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '资源权限';


-- -----------------------------------------------------
-- Table `um`.`t_um_system_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `um`.`t_um_system_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `level` INT NOT NULL DEFAULT 1,
  `parent_id` INT NOT NULL DEFAULT 0,
  `dt_create_time` DATETIME NULL,
  `dt_update_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '系统角色';


-- -----------------------------------------------------
-- Table `um`.`t_um_group_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `um`.`t_um_group_user` (
  `user_name` VARCHAR(100) NOT NULL,
  `groudp_id` INT NOT NULL,
  INDEX `fk_t_um_group_user_t_um_user_idx` (`user_name` ASC),
  INDEX `fk_t_um_group_user_t_um_group1_idx` (`groudp_id` ASC),
  CONSTRAINT `fk_t_um_group_user_t_um_user`
    FOREIGN KEY (`user_name`)
    REFERENCES `um`.`t_um_user` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_um_group_user_t_um_group1`
    FOREIGN KEY (`groudp_id`)
    REFERENCES `um`.`t_um_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `um`.`t_um_role_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `um`.`t_um_role_permission` (
  `permission_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  INDEX `fk_t_um_role_permission_t_um_permission1_idx` (`permission_id` ASC),
  INDEX `fk_t_um_role_permission_t_um_system_role1_idx` (`role_id` ASC),
  PRIMARY KEY (`permission_id`, `role_id`),
  CONSTRAINT `fk_t_um_role_permission_t_um_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `um`.`t_um_permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_um_role_permission_t_um_system_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `um`.`t_um_system_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `um`.`t_um_group_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `um`.`t_um_group_role` (
  `group_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  INDEX `fk_t_um_group_role_t_um_group1_idx` (`group_id` ASC),
  INDEX `fk_t_um_group_role_t_um_system_role1_idx` (`role_id` ASC),
  PRIMARY KEY (`group_id`, `role_id`),
  CONSTRAINT `fk_t_um_group_role_t_um_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `um`.`t_um_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_um_group_role_t_um_system_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `um`.`t_um_system_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;