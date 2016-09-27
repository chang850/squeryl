# --- First database schema

# --- !Ups

CREATE TABLE `mt_user` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mt_company` (
	`id` bigint(20) NOT NULL,
	`name` varchar(255) DEFAULT NULL,
	`description` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# --- !Downs
DROP TABLE `mt_company`;
DROP TABLE `mt_user`;


