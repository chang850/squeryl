# --- First database schema

# --- !Ups

CREATE TABLE `mt_user` (
	`id` varchar(255) NOT NULL,
	`name` varchar(255) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# --- !Downs
DROP TABLE `mt_user`;


