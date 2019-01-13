/*
Navicat MySQL Data Transfer

Source Server         : zhenxuan
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hydrological_monitor

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-01-13 21:35:39
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
INSERT INTO `area` VALUES ('402862816835d189016835d1a9060000', '琼中县', '海南省', null, '0', '2019-01-10 11:32:39');
INSERT INTO `area` VALUES ('402862816836a9e1016836aa03a90000', '南澳县', '广东省', null, '0', '2019-01-10 15:28:58');

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
  `CREATE_TIME` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`),
  KEY `FK1wxqnng7sgwa2drp3p6fk021p` (`PS_AREA_ID`),
  CONSTRAINT `FK1wxqnng7sgwa2drp3p6fk021p` FOREIGN KEY (`PS_AREA_ID`) REFERENCES `area` (`ID`),
  CONSTRAINT `point_station_ibfk_1` FOREIGN KEY (`PS_AREA_ID`) REFERENCES `area` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of point_station
-- ----------------------------
INSERT INTO `point_station` VALUES ('402862816836975a0168369792370000', '402862816835d189016835d1a9060000', '丹村水电站', '2019-01-10 15:08:50');
INSERT INTO `point_station` VALUES ('402862816837180a016837182aa50000', '402862816836a9e1016836aa03a90000', '南澳水电站', '2019-01-10 17:29:17');
INSERT INTO `point_station` VALUES ('40286281683719f10168371a10ee0000', '402862816836a9e1016836aa03a90000', '南澳大坝', '2019-01-10 17:31:22');

-- ----------------------------
-- Table structure for `point_station_data`
-- ----------------------------
DROP TABLE IF EXISTS `point_station_data`;
CREATE TABLE `point_station_data` (
  `ID` varchar(64) NOT NULL,
  `PS_POINT_ID` varchar(64) NOT NULL COMMENT '测站ID',
  `PS_WATERLINE` decimal(10,2) DEFAULT NULL COMMENT '水位',
  `PS_WATERSTATUS` int(11) DEFAULT NULL COMMENT '水位状态(0--正常  1--不正常)',
  `PS_SPEED` decimal(10,2) DEFAULT NULL COMMENT '流速',
  `PS_ECOLOGICAL_FLOW` decimal(10,2) DEFAULT NULL COMMENT '生态流量',
  `PS_AUTHORIZED_FLOW` decimal(10,2) DEFAULT NULL COMMENT '核定流量',
  `PS_TEMPLATE_FLOW` decimal(10,2) DEFAULT NULL COMMENT '瞬时流量',
  `PS_FLOW_STATUS` int(11) DEFAULT NULL COMMENT '流量状态(0--正常  1--过快  2--过慢)',
  `PS_VOLTAGE` decimal(10,2) DEFAULT NULL COMMENT '电池电压',
  `PS_DEVICENUM` varchar(32) DEFAULT NULL COMMENT '设备卡号',
  `PS_DEVICE_STATUS` int(11) DEFAULT NULL COMMENT '设备状态',
  `PS_HEIGHT` decimal(10,2) DEFAULT NULL COMMENT '空高',
  `PS_LOCATION` varchar(64) DEFAULT NULL COMMENT '地图坐标',
  `CREATE_TIME` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`),
  KEY `FKocnyxnljh7e8du6tgwfq3kly5` (`PS_POINT_ID`),
  CONSTRAINT `FKocnyxnljh7e8du6tgwfq3kly5` FOREIGN KEY (`PS_POINT_ID`) REFERENCES `point_station` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of point_station_data
-- ----------------------------
INSERT INTO `point_station_data` VALUES ('402862816840ec2e016840ec57e50000', '402862816836975a0168369792370000', '1.38', '1', '0.78', '46.20', '3.25', '12.52', '1', '12.06', '913246548321313B', '0', '5.20', null, '2019-01-12 15:17:37');
INSERT INTO `point_station_data` VALUES ('402862816840eeae016840eed7830000', '402862816836975a0168369792370000', '1.38', '0', '0.78', '47.20', '3.25', '12.55', '0', '12.06', '913246548321313B', '1', '5.20', null, '2019-01-12 15:20:21');

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
