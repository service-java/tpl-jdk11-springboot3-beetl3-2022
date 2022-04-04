/*
Navicat MySQL Data Transfer
Source Server         : ����ʦ�����ݿ�
Source Server Version : 50736
Source Host           : 120.55.13.130:3306
Source Database       : demo
Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001
Date: 2022-03-26 13:05:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                        `name` varchar(255) NOT NULL COMMENT '����',
                        `age` int(11) DEFAULT NULL COMMENT '����',
                        `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
                        `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '����ʱ��',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user1', '22', '2022-03-26 13:04:55', '2022-03-26 13:04:57');