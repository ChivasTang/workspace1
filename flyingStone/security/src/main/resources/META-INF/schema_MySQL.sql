/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

-- -----------------------------------------------------
-- Schema flyingStone
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS flyingStone;

-- -----------------------------------------------------
-- Schema flyingStone
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS flyingStone DEFAULT CHARACTER SET utf8;
USE flyingStone;

-- -----------------------------------------------------
-- Table flyingStone.m_user
-- -----------------------------------------------------
DROP TABLE IF EXISTS flyingStone.m_user;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS flyingStone.m_user
(
--    id          BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'ユーザID',
    username    VARCHAR(255) NOT NULL COMMENT 'ユーザ名',
    email       VARCHAR(255) NOT NULL UNIQUE COMMENT 'イーメール',
    password    VARCHAR(255) NOT NULL COMMENT 'パスワード',
    first_name  VARCHAR(255) NOT NULL COMMENT '名前',
    last_name   VARCHAR(255) NOT NULL COMMENT '苗字',
    birthday    DATE         NOT NULL COMMENT '生年月日',
    create_user VARCHAR(255) NOT NULL COMMENT '作成ユーザ',
    created     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP COMMENT '作成日付',
    update_user VARCHAR(255) DEFAULT NULL COMMENT '更新ユーザ',
    updated     TIMESTAMP    DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日付',
    available   TINYINT(1)   DEFAULT 1 COMMENT '有効区分',
    PRIMARY KEY (username)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_bin
    AUTO_INCREMENT = 1;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Dumping data for table flyingStone.m_user

LOCK TABLES flyingStone.m_user WRITE;
/*!40000 ALTER TABLE flyingStone.m_user DISABLE KEYS */;
INSERT INTO flyingStone.m_user
(username, email, password, first_name, last_name, birthday, create_user)
VALUES ('tangzh1983', 'tangzh1983@gmail.com','1c9078915870690b6dae37a57cf7b43e64763f32e1932fbc6d1e3ba37abc4260b97ee4046fcd4575', '湯', '志華', '1983-11-20','tangzh1983'),
       ('tangzhihua', 'tangzhihua1983@i.softbank.jp','883863d54bc59d1df9447abf694bae0584da482a2c8c6d744df75dedf94c5f5a0d2e840d0cfbf191', '湯', '志華', '1983-11-20','tangzh1983');
/*!40000 ALTER TABLE flyingStone.m_user ENABLE KEYS */;
UNLOCK TABLES;



-- -----------------------------------------------------
-- Table flyingStone.r_users_roles
-- -----------------------------------------------------

DROP TABLE IF EXISTS flyingStone.r_users_roles;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS r_users_roles
(
    id       BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'ユーザロール区分',
    username VARCHAR(255) NOT NULL COMMENT 'ユーザ名',
    role     VARCHAR(255) NOT NULL COMMENT 'ロール名',
    create_user VARCHAR(255) NOT NULL COMMENT '作成ユーザ',
    created     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP COMMENT '作成日付',
    update_user VARCHAR(255) DEFAULT NULL COMMENT '更新ユーザ',
    updated     TIMESTAMP    DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日付',
    available   TINYINT(1)   DEFAULT 1 COMMENT '有効区分',
    PRIMARY KEY (id),
    KEY fk_r_users_roles_1_idx (username),
    CONSTRAINT fk_r_users_roles_1 FOREIGN KEY (username) REFERENCES m_user (username) ON DELETE NO ACTION ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_bin
    AUTO_INCREMENT = 1;
/*!40101 SET character_set_client = @saved_cs_client */;


-- Dumping data for table flyingStone.r_users_roles

LOCK TABLES flyingStone.r_users_roles WRITE;
/*!40000 ALTER TABLE flyingStone.r_users_roles DISABLE KEYS */;
INSERT INTO flyingStone.r_users_roles
(id, username, role, create_user)
VALUES (1, 'tangzh1983', 'ROLE_ADMIN','tangzh1983'),
       (2, 'tangzh1983', 'ROLE_USER','tangzh1983'),
       (3, 'tangzhihua', 'ROLE_USER','tangzh1983');
/*!40000 ALTER TABLE flyingStone.r_users_roles ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2017-06-26 13:59:16



