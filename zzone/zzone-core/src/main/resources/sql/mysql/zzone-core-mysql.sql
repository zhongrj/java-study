/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : zzone

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-04-28 17:26:58
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `core_user`
-- ----------------------------
DROP VIEW IF EXISTS `core_user_basic`;
DROP TABLE IF EXISTS `core_user`;
CREATE TABLE `core_user` (
  `id` varchar(100) NOT NULL COMMENT 'id',
  `account` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `type` int(5) DEFAULT NULL COMMENT '用户类型 0普通用户 1会员用户 9管理用户',
  `status` int(5) DEFAULT NULL COMMENT '用户状态 0正常 1冻结 2黑名单',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` int(5) NOT NULL COMMENT '删除标识 0正常 1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- View structure for `core_user_basic`
-- ----------------------------
CREATE VIEW `core_user_basic` AS select `core_user`.`id` AS `id`,`core_user`.`account` AS `account`,`core_user`.`name` AS `name`,`core_user`.`mobile` AS `mobile`,`core_user`.`email` AS `email`,`core_user`.`type` AS `type`,`core_user`.`status` AS `status`,`core_user`.`del_flag` AS `del_flag` from `core_user`;


-- ----------------------------
-- Records of core_user
-- ----------------------------
INSERT INTO `core_user` VALUES ('0a27d82c021e456fb8b4f9e0fe343c1c', 'admin', 'admin', '超级管理员', '13660677179', '329063269@qq.com', '9', '0', '2017-04-27 16:10:40', '2017-04-27 16:10:40', '0');
INSERT INTO `core_user` VALUES ('8dfe0c1dc6864beab0f96b63bde3226d', 'user', 'user', '测试注册', '13660677123', '329053269@pp.com', '0', '0', '2017-06-06 16:42:21', '2017-06-06 16:42:21', '0');









-- ----------------------------
-- Table structure for `core_dict`
-- ----------------------------
DROP TABLE IF EXISTS `core_dict`;
CREATE TABLE `core_dict` (
  `label` varchar(100) NOT NULL COMMENT '表情',
  `value` varchar(100) NOT NULL COMMENT '值',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(200) NOT NULL COMMENT '描述',
  `del_flag` int(5) NOT NULL COMMENT '删除标识 0正常 1删除',
  PRIMARY KEY (`value`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of core_dict
-- ----------------------------
INSERT INTO `core_dict` VALUES ('离线', '0', 'user_status', '用户状态', '0');
INSERT INTO `core_dict` VALUES ('在线', '1', 'user_status', '用户状态', '0');









