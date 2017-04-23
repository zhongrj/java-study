/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : zzone

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-04-22 17:53:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `core_session`
-- ----------------------------
DROP TABLE IF EXISTS `core_session`;
CREATE TABLE `core_session` (
  `token` varchar(100) NOT NULL,
  `user_id` varchar(100) NOT NULL COMMENT '用户id',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `expire_date` datetime NOT NULL COMMENT '失效时间',
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of core_session
-- ----------------------------
INSERT INTO `core_session` VALUES ('48ce6c4ee4bf4aa5902530c7a154a590', '1', '2017-04-22 15:00:09', '2017-04-29 15:00:10');

-- ----------------------------
-- Table structure for `core_user`
-- ----------------------------
DROP TABLE IF EXISTS `core_user`;
CREATE TABLE `core_user` (
  `id` varchar(100) NOT NULL COMMENT 'id',
  `account` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `type` int(5) DEFAULT NULL COMMENT '用户类型 0普通用户 1会员用户',
  `status` int(5) DEFAULT NULL COMMENT '用户状态 0正常 1冻结 2黑名单',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` int(5) NOT NULL COMMENT '删除标识 0正常 1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of core_user
-- ----------------------------
INSERT INTO `core_user` VALUES ('4e510ffb47904b179b7c805c568450a3', 'admin', 'admin', null, null, null, '2017-04-22 17:13:05', '2017-04-22 17:13:05', '0');
