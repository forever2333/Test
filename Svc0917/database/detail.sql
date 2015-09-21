/*
Navicat MySQL Data Transfer

Source Server         : ROOT
Source Server Version : 50704
Source Host           : 127.0.0.1:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2015-09-20 12:46:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(4) NOT NULL,
  `to_uid` int(4) NOT NULL,
  `type` int(1) NOT NULL,
  `cash` float(7,2) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `tdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_detail_uid` (`uid`),
  KEY `fk_detail_to` (`to_uid`),
  CONSTRAINT `fk_detail_to` FOREIGN KEY (`to_uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `fk_detail_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
