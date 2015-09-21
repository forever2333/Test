/*
Navicat MySQL Data Transfer

Source Server         : ROOT
Source Server Version : 50704
Source Host           : 127.0.0.1:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2015-09-20 12:46:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for refund
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund` (
  `sid` int(4) NOT NULL AUTO_INCREMENT,
  `uid` int(4) NOT NULL,
  `scash` float(7,2) NOT NULL,
  `from_uid` int(4) NOT NULL,
  `type` int(1) NOT NULL DEFAULT '1',
  `rdate` datetime NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `fk_back_to` (`from_uid`),
  KEY `fk_back_uid` (`uid`),
  CONSTRAINT `fk_back_to` FOREIGN KEY (`from_uid`) REFERENCES `account` (`aid`),
  CONSTRAINT `fk_back_uid` FOREIGN KEY (`uid`) REFERENCES `account` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
