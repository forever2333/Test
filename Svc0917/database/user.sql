/*
Navicat MySQL Data Transfer

Source Server         : ROOT
Source Server Version : 50704
Source Host           : 127.0.0.1:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2015-09-20 12:46:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(4) NOT NULL AUTO_INCREMENT,
  `uname` varchar(19) NOT NULL,
  `login_pwd` varchar(32) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1000', 'scott', '202cb962ac59075b964b07152d234b70');
INSERT INTO `user` VALUES ('1001', 'lee', '68053af2923e00204c3ca7c6a3150cf7');
INSERT INTO `user` VALUES ('1002', 'kevin', '81dc9bdb52d04dc20036dbd8313ed055');
