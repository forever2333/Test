/*
Navicat MySQL Data Transfer

Source Server         : ROOT
Source Server Version : 50704
Source Host           : 127.0.0.1:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2015-09-20 12:46:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `aid` int(4) NOT NULL AUTO_INCREMENT,
  `paypwd` varchar(32) NOT NULL,
  `account` varchar(19) NOT NULL,
  `cash` float(7,2) NOT NULL,
  `init` float(7,2) NOT NULL,
  `atype` int(1) NOT NULL,
  PRIMARY KEY (`aid`),
  CONSTRAINT `fk_aid` FOREIGN KEY (`aid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1000', '674f3c2c1a8a6f90461e8a66fb5550ba', '2345678576430108976', '500.00', '500.00', '0');
INSERT INTO `account` VALUES ('1001', '674f3c2c1a8a6f90461e8a66fb5550ba', '5673465237892476129', '800.00', '800.00', '0');
INSERT INTO `account` VALUES ('1002', '674f3c2c1a8a6f90461e8a66fb5550ba', '2878476628734657889', '1000.00', '1000.00', '1');
