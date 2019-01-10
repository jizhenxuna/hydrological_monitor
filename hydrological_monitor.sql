/*
Navicat MySQL Data Transfer

Source Server         : zhenxuan
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hydrological_monitor

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-01-10 11:08:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `ID` varchar(64) NOT NULL COMMENT '主键',
  `AREA_NAME` varchar(64) NOT NULL COMMENT '区域名称',
  `AREA_SUPERIOR` varchar(64) NOT NULL COMMENT '上级名称',
  `AREA_LOCATION` varchar(64) DEFAULT NULL COMMENT '地图坐标',
  `AREA_LEVEL` int(11) DEFAULT NULL COMMENT '区域级别',
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------

-- ----------------------------
-- Table structure for `operator`
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `ID` varchar(64) NOT NULL,
  `OP_NAME` varchar(64) NOT NULL COMMENT '操作员名称',
  `OP_ROLE` varchar(5) NOT NULL COMMENT '操作员角色（0:总管理员  1:分管理员  2:浏览用户）',
  `OP_AREAID` varchar(64) NOT NULL COMMENT '区域ID',
  `OP_CUS_POINT` varchar(5) NOT NULL COMMENT '自定义测点（0:是  1:不是）',
  `OP_POINTID` varchar(64) DEFAULT NULL COMMENT '测点ID',
  `OP_MAP` varchar(64) DEFAULT NULL COMMENT '地图坐标',
  `CREATEDATE` varchar(64) NOT NULL COMMENT '创建时间',
  `UPDATEDATE` varchar(64) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator
-- ----------------------------

-- ----------------------------
-- Table structure for `point_station`
-- ----------------------------
DROP TABLE IF EXISTS `point_station`;
CREATE TABLE `point_station` (
  `ID` varchar(64) NOT NULL,
  `PS_AREA_ID` varchar(64) NOT NULL COMMENT '区域ID',
  `PS_STATION` varchar(64) NOT NULL COMMENT '测站',
  `PS_WATERLINE` decimal(10,2) DEFAULT NULL COMMENT '水位',
  `PS_WATERSTATUS` int(11) DEFAULT NULL COMMENT '水位状态(0--正常  1--不正常)',
  `PS_SPEED` decimal(10,2) DEFAULT NULL COMMENT '流速',
  `PS_ECOLOGICAL_FLOW` decimal(10,2) DEFAULT NULL COMMENT '生态流量',
  `PS_AUTHORIZED_FLOW` decimal(10,2) DEFAULT NULL COMMENT '核定流量',
  `PS_TEMPLATE_FLOW` decimal(10,2) DEFAULT NULL COMMENT '瞬时流量',
  `PS_FLOW_STATUS` int(11) DEFAULT NULL COMMENT '流量状态(0--正常  1--过快  2--过慢)',
  `PS_VOLTAGE` decimal(10,2) DEFAULT NULL COMMENT '电池电压',
  `PS_DEVICENUM` varchar(32) DEFAULT NULL COMMENT '设备卡号',
  `PS_HEIGHT` decimal(10,2) DEFAULT NULL COMMENT '空高',
  `PS_LOCATION` varchar(64) DEFAULT NULL COMMENT '地图坐标',
  `CREATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `ps_area` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PS_AREA_ID` (`PS_AREA_ID`),
  CONSTRAINT `point_station_ibfk_1` FOREIGN KEY (`PS_AREA_ID`) REFERENCES `area` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of point_station
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `realname` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4028628167e371d30167e371fac40000', '123456', 'jzx', '纪桢轩');
INSERT INTO `user` VALUES ('4028628167e371d30167e372a97b0001', '123456', 'jizx', '纪桢轩');
INSERT INTO `user` VALUES ('402862816823b88b016823c62e840000', '123', 'jzx01', '纪桢轩');
INSERT INTO `user` VALUES ('40286281682c4ab801682c6313430000', '123456', 'jzx02', '纪桢轩');
