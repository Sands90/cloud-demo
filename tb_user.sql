/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.207
Source Server Version : 50621
Source Host           : 192.168.0.207:3306
Source Database       : lamp20170615

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-06-11 11:38:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '生日',
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '柳岩', '123', 'liuyan', '28', '2', '1995-02-02 12:04:59', '2019-04-17 12:05:18', null);
INSERT INTO `tb_user` VALUES ('2', '刘亦菲', '456', 'liuyifei', '30', '2', '1990-06-06 15:29:10', '2019-06-06 15:29:31', '2019-06-06 15:28:50');
INSERT INTO `tb_user` VALUES ('3', '刘德华', '789', 'liudehua', '57', '1', '2019-06-06 15:30:27', '2019-06-06 15:31:09', '2019-06-06 15:30:27');
INSERT INTO `tb_user` VALUES ('4', '杨幂', '012', 'yangmi', '30', '2', '1989-06-06 15:32:07', '2019-06-06 15:32:18', null);
