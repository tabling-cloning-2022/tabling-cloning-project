-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tabling-cloning
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tabling-cloning
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tabling-cloning`;
CREATE SCHEMA IF NOT EXISTS `tabling-cloning` DEFAULT CHARACTER SET utf8;
USE `tabling-cloning`;

-- `tabling-cloning`.Store definition
CREATE TABLE `Store` (
                         `store_id` bigint(20) NOT NULL,
                         `name` varchar(45) DEFAULT NULL,
                         `address` varchar(45) DEFAULT NULL,
                         `district` varchar(12) DEFAULT NULL,
                         `phone_number` varchar(30) DEFAULT NULL,
                         `daily_code` varchar(45) DEFAULT NULL,
                         `image` varchar(500) DEFAULT NULL,
                         `reservation_table_queue_status` bit(1) DEFAULT NULL,
                         `reservation_status` bit(1) DEFAULT NULL,
                         `food_type` tinyint(1) DEFAULT NULL,
                         `total_rating` tinyint(1) DEFAULT NULL,
                         `favorite_count` int(11) DEFAULT NULL,
                         `total_comment` int(11) DEFAULT NULL,
                         `avg_wait_time` int(11) DEFAULT NULL,
                         `description` text,
                         `create_datetime` datetime DEFAULT NULL,
                         `update_datetime` datetime DEFAULT NULL,
                         PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='매장';


-- `tabling-cloning`.`User` definition

CREATE TABLE `User` (
                        `client_id` bigint(20) NOT NULL,
                        `email` varchar(100) DEFAULT NULL,
                        `name` varchar(30) DEFAULT NULL,
                        `oauth_provider` varchar(3) DEFAULT NULL,
                        `oauth_token` varchar(50) DEFAULT NULL,
                        `phone_number` varchar(45) DEFAULT NULL,
                        `authorization` tinyint(1) DEFAULT NULL,
                        `status` tinyint(1) DEFAULT NULL,
                        `panalty_count` int(11) DEFAULT NULL,
                        `penalty_updated_datetime` datetime DEFAULT NULL,
                        `create_datetime` datetime DEFAULT NULL,
                        `update_datetime` datetime DEFAULT NULL,
                        PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원';


-- `tabling-cloning`.Favorite definition

CREATE TABLE `Favorite` (
                            `favorite_id` bigint(20) NOT NULL,
                            `client_id` bigint(20) NOT NULL,
                            `store_id` bigint(20) NOT NULL,
                            `create_datetime` datetime DEFAULT NULL,
                            `update_datetime` datetime DEFAULT NULL,
                            PRIMARY KEY (`favorite_id`,`client_id`,`store_id`),
                            KEY `fk_Favorite_User_idx` (`client_id`),
                            KEY `fk_Favorite_Store1_idx` (`store_id`),
                            CONSTRAINT `fk_Favorite_Store1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                            CONSTRAINT `fk_Favorite_User` FOREIGN KEY (`client_id`) REFERENCES `User` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='관심매장';


-- `tabling-cloning`.Multiple_owner_stroe definition

CREATE TABLE `MultipleOwnerStore` (
                                      `multiple_owner_store_id` bigint(20) NOT NULL,
                                      `store_id` bigint(20) NOT NULL,
                                      `client_id` bigint(20) NOT NULL,
                                      `create_datetime` datetime DEFAULT NULL,
                                      `update_datetime` datetime DEFAULT NULL,
                                      PRIMARY KEY (`multiple_owner_store_id`,`store_id`,`client_id`),
                                      KEY `fk_MultipleOwnerStore_Store1_idx` (`store_id`),
                                      KEY `fk_MultipleOwnerStore_User1_idx` (`client_id`),
                                      CONSTRAINT `fk_Multiple_owner_stroe_Store1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                      CONSTRAINT `fk_Multiple_owner_stroe_User1` FOREIGN KEY (`client_id`) REFERENCES `User` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='직원_매장';


-- `tabling-cloning`.Reservation definition

CREATE TABLE `Reservation` (
                               `reservation_id` bigint(20) NOT NULL,
                               `client_id` bigint(20) NOT NULL,
                               `store_id` bigint(20) NOT NULL,
                               `datetime` datetime DEFAULT NULL,
                               `status` tinyint(1) DEFAULT NULL,
                               `description` text,
                               `create_datetime` datetime DEFAULT NULL,
                               `update_datetime` datetime DEFAULT NULL,
                               PRIMARY KEY (`reservation_id`,`client_id`,`store_id`),
                               KEY `fk_Reservation_User1_idx` (`client_id`),
                               KEY `fk_Reservation_Store1_idx` (`store_id`),
                               CONSTRAINT `fk_Reservation_Store1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                               CONSTRAINT `fk_Reservation_User1` FOREIGN KEY (`client_id`) REFERENCES `User` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='예약';


-- `tabling-cloning`.ReservationTableQueue definition

CREATE TABLE `ReservationTableQueue` (
                                         `reservation_table_queue_id` bigint(20) NOT NULL,
                                         `client_id` bigint(20) NOT NULL,
                                         `store_id` bigint(20) NOT NULL,
                                         `ticket_number` int(11) DEFAULT NULL,
                                         `status` tinyint(1) DEFAULT NULL,
                                         `create_datetime` datetime DEFAULT NULL,
                                         `update_datetime` datetime DEFAULT NULL,
                                         PRIMARY KEY (`reservation_table_queue_id`,`client_id`,`store_id`),
                                         KEY `fk_ReservationTableQueue_User1_idx` (`client_id`),
                                         KEY `fk_ReservationTableQueue_Store1_idx` (`store_id`),
                                         CONSTRAINT `fk_ReservationTableQueue_Store1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                         CONSTRAINT `fk_ReservationTableQueue_User1` FOREIGN KEY (`client_id`) REFERENCES `User` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='줄서기';


-- `tabling-cloning`.ReservationTime definition

CREATE TABLE `WorkTime` (
                            `work_time_id` bigint(20) NOT NULL,
                            `store_id` bigint(20) NOT NULL,
                            `day` varchar(45) DEFAULT NULL,
                            `status` varchar(45) DEFAULT NULL,
                            `start_time` time DEFAULT NULL,
                            `end_time` time DEFAULT NULL,
                            `create_datetime` datetime DEFAULT NULL,
                            `update_datetime` datetime DEFAULT NULL,
                            PRIMARY KEY (`work_time_id`,`store_id`),
                            KEY `fk_WorkTime_Store1_idx` (`store_id`),
                            CONSTRAINT `fk_WorkTime_Store1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='영업시간';


-- `tabling-cloning`.Review definition

CREATE TABLE `Review` (
                          `review_id` bigint(20) NOT NULL,
                          `client_id` bigint(20) NOT NULL,
                          `store_id` bigint(20) NOT NULL,
                          `rating` tinyint(1) DEFAULT NULL,
                          `comment` varchar(45) DEFAULT NULL,
                          `status` tinyint(1) DEFAULT NULL,
                          `create_datetime` datetime DEFAULT NULL,
                          `update_datetime` datetime DEFAULT NULL,
                          PRIMARY KEY (`review_id`,`client_id`,`store_id`),
                          KEY `fk_Review_User1_idx` (`client_id`),
                          KEY `fk_Review_Store1_idx` (`store_id`),
                          CONSTRAINT `fk_Review_Store1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                          CONSTRAINT `fk_Review_User1` FOREIGN KEY (`client_id`) REFERENCES `User` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='댓글';


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
