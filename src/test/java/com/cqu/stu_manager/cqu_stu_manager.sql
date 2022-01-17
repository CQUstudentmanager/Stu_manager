/*
 Navicat Premium Data Transfer

 Source Server         : TEST
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : cqu_stu_manager

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 17/01/2022 14:52:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_teacherid` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE,
  INDEX `Class_teacherid`(`class_teacherid`) USING BTREE,
  INDEX `Class_name`(`class_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 'ceshi', 1);

-- ----------------------------
-- Table structure for msginfo
-- ----------------------------
DROP TABLE IF EXISTS `msginfo`;
CREATE TABLE `msginfo`  (
  `msg_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `msg_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msg_sender` int(255) NOT NULL,
  PRIMARY KEY (`msg_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of msginfo
-- ----------------------------
INSERT INTO `msginfo` VALUES ('1-2022-01-17 14:15:49', '大家好，这是一条测试数据', 1);
INSERT INTO `msginfo` VALUES ('1-2022-01-17 14:35:36', '大家好，第二条测试数据', 1);
INSERT INTO `msginfo` VALUES ('1-2022-01-17 14:40:03', '大家好，第三条测试数据', 1);

-- ----------------------------
-- Table structure for receive
-- ----------------------------
DROP TABLE IF EXISTS `receive`;
CREATE TABLE `receive`  (
  `receive_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `msg_no2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver` int(255) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`receive_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of receive
-- ----------------------------
INSERT INTO `receive` VALUES ('12347-2022-01-17 14:15:49', '1-2022-01-17 14:15:49', 12347, 0);
INSERT INTO `receive` VALUES ('12347-2022-01-17 14:40:03', '1-2022-01-17 14:40:03', 12347, 0);
INSERT INTO `receive` VALUES ('20201034-2022-01-17 14:15:49', '1-2022-01-17 14:15:49', 20201034, 0);
INSERT INTO `receive` VALUES ('20201034-2022-01-17 14:35:36', '1-2022-01-17 14:35:36', 20201034, 0);
INSERT INTO `receive` VALUES ('20201034-2022-01-17 14:40:03', '1-2022-01-17 14:40:03', 20201034, 0);
INSERT INTO `receive` VALUES ('20201234-2022-01-17 14:15:49', '1-2022-01-17 14:15:49', 20201234, 0);
INSERT INTO `receive` VALUES ('20201234-2022-01-17 14:40:03', '1-2022-01-17 14:40:03', 20201234, 0);
INSERT INTO `receive` VALUES ('20204146-2022-01-17 14:15:49', '1-2022-01-17 14:15:49', 20204146, 0);
INSERT INTO `receive` VALUES ('20204146-2022-01-17 14:35:36', '1-2022-01-17 14:35:36', 20204146, 0);
INSERT INTO `receive` VALUES ('20204146-2022-01-17 14:40:03', '1-2022-01-17 14:40:03', 20204146, 0);
INSERT INTO `receive` VALUES ('20204567-2022-01-17 14:15:49', '1-2022-01-17 14:15:49', 20204567, 0);
INSERT INTO `receive` VALUES ('20204567-2022-01-17 14:40:03', '1-2022-01-17 14:40:03', 20204567, 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_no` int(9) NOT NULL,
  `stu_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_gender` int(1) NULL DEFAULT NULL,
  `stu_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_ethnic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_origin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_politicalface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_caucus_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_ismacau` int(1) NULL DEFAULT NULL,
  `stu_telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_qq` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_photourl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stu_no`) USING BTREE,
  INDEX `Stu_class`(`stu_class`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (12347, '1111', '张三光', 12347, '大数据1班', '1995-12-26', '满', '重庆渝北', '522321', '党员', '2021', 1, '135959002', '122706559', 'ch@163', '重庆', 'WU');
INSERT INTO `student` VALUES (20201034, '123456', '刘二', 0, '人工智能1', '1995-12-26', '满', '四川成都', '522321', '党员', '2021', 1, '135959002', '122706559', 'ch@163', '重庆', 'WU');
INSERT INTO `student` VALUES (20201234, '123456', '李四', 20201234, '人工智能1班', '1995-12-26', '汉', '美国纽约', '522321', '党员', '2021', 1, '135959002', '122706559', 'ch@163', '重庆', 'WU');
INSERT INTO `student` VALUES (20204146, '1111', '李四光', 20204146, '大数据1班', '1995-12-26', '汉', '四川成都', '522321', '共青团员', '2021', 20204146, '18357980493', '122706559', '', '重庆大学', 'WU');
INSERT INTO `student` VALUES (20204567, '123456', '张三', 20204567, '大数据1班', '1995-12-26', '汉', '四川成都', '522321', '党员', '2021', 1, '135959002', '122706559', 'ch@163', '重庆', 'WU');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_no` int(20) NOT NULL,
  `t_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_officeroom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_identity` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`t_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'zhouwei', '周巍', '13595922234', '431', 1);
INSERT INTO `teacher` VALUES (2, '123456', '李潇', '123456', '431', 5);

SET FOREIGN_KEY_CHECKS = 1;
