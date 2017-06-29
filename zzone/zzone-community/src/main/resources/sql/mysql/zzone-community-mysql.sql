/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : zzone

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-06-29 19:32:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `community_post`
-- ----------------------------
DROP TABLE IF EXISTS `community_post`;
CREATE TABLE `community_post` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL COMMENT '标题',
  `comment_count` int(11) NOT NULL COMMENT '评论数',
  `create_by` varchar(100) NOT NULL COMMENT '创建人id',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `del_flag` int(5) NOT NULL COMMENT '删除标识 0正常 1删除',
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for `community_comment`
-- ----------------------------
DROP TABLE IF EXISTS `community_comment`;
CREATE TABLE `community_comment` (
  `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `post_id` varchar(100) NOT NULL COMMENT '贴子id',
  `content` tinytext NOT NULL COMMENT '评论内容',
  `create_by` varchar(100) NOT NULL COMMENT '创建人id',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `del_flag` int(5) NOT NULL COMMENT '删除标识 0正常 1删除',
  PRIMARY KEY (`id`)
);

