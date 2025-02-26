


CREATE DATABASE `banco_db` ;





CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_number` varchar(255) NOT NULL,
  `account_type` varchar(255) NOT NULL,
  `customer_id` bigint DEFAULT NULL,
  `online_balance` double NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK66gkcp94endmotfwb8r4ocxm9` (`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `identification` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UKrhpv87q3057rohwm2cawtfr3e` (`identification`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




CREATE TABLE `log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_time` datetime(6) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




CREATE TABLE `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `available_balance` double NOT NULL,
  `initial_balance` double NOT NULL,
  `transaction_amount` double NOT NULL,
  `transaction_date` datetime(6) DEFAULT NULL,
  `transaction_description` varchar(255) DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6g20fcr3bhr6bihgy24rq1r1b` (`account_id`),
  CONSTRAINT `FK6g20fcr3bhr6bihgy24rq1r1b` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

