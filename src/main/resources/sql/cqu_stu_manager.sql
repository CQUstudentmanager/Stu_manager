/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : cqu_stu_manager

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 16/02/2022 20:14:36
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
INSERT INTO `class` VALUES (1, '软件1班', 3);
INSERT INTO `class` VALUES (2, '电子信息一班', 1);
INSERT INTO `class` VALUES (4, '电子信息三班', 4);

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest`  (
  `contest_no` int(11) NOT NULL,
  `contest_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_projectname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_grantingdepartment` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_ranking` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_teachername` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_teacherdept` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_stuname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_stuno` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_issubmitcertificate` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_supporting_materials` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `contest_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of contest
-- ----------------------------
INSERT INTO `contest` VALUES (1, '第七届GSIG中国可视化与可视分析大会数据可视分析挑战赛', '新冠肺炎预测与舆情分析可视平台', '中国图像图形学协会', '国家级', '二等奖', '2020-07', '胡海波', '大数据与软件学院', '杨涛', '2021252', '已提交', '2021', '无', '1');
INSERT INTO `contest` VALUES (456789, 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', '456789', 'String', 'String', 'String', 'String');

-- ----------------------------
-- Table structure for dispatch
-- ----------------------------
DROP TABLE IF EXISTS `dispatch`;
CREATE TABLE `dispatch`  (
  `dispatch_no` int(11) NOT NULL,
  `dispatch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_project_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_continent` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_foreign_counterpart` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_stu_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_stu_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_stu_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_project_time_from_to` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_greater_than_3month` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_arrangement` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_passport_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_is_admission` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_is_top200` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dispatch
-- ----------------------------
INSERT INTO `dispatch` VALUES (1, '2019 8th International Conference on Industrial Technology and Management(ICITM 2019)', '校', '学术会议', '英国', '欧洲', '剑桥大学/ICITM 2019 Organizing Committee', 'XXX', '女/男', '123453', '机械', '物流工程', '20190228-20190307', '否', '硕', '硕士二年级', 'EG5006506', '17725023640', '849560269@qq.com', '是', '是');
INSERT INTO `dispatch` VALUES (1, '2019 8th International Conference on Industrial Technology and Management(ICITM 2019)', '校', '学术会议', '英国', '欧洲', '剑桥大学/ICITM 2019 Organizing Committee', 'XXX', '女/男', '123456', '机械', '物流工程', '20190228-20190307', '否', '硕', '硕士二年级', 'EG5006506', '17725023640', '849560269@qq.com', '是', '是');
INSERT INTO `dispatch` VALUES (0, 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String');

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
INSERT INTO `msginfo` VALUES ('1-2022-01-17 15:21:25', 'String', 1);

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `paper_no` int(10) NOT NULL,
  `paper_stuno` int(10) NOT NULL,
  `paper_stuname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `paper_periodical` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_publicationTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_iscscd` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_sciSearchNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_eiSearchNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_supporting_materials` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`paper_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES (156546, 20212413, 'changyao', 'asdfasdf', 'adsf', 'werqa', 'asdfr', 'wefasdf', 'aerasdfasdfasdf', 'asdf', 'asdf', 'asdf');
INSERT INTO `paper` VALUES (1, 20181703, '杨焱景', 'MSPLD: Shilling Attack Detection Model Based on Meta Self-Paced Learning', '2021 International Joint Conference on Neural Networks (IJCNN)', '2021/9/20', '否', '否', '10.1109/IJCNN52387.2021.9533622\r\n', '2021', '无', NULL);

-- ----------------------------
-- Table structure for patent
-- ----------------------------
DROP TABLE IF EXISTS `patent`;
CREATE TABLE `patent`  (
  `patent_no` int(11) NOT NULL,
  `patent_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_application_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_application_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_certificate_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_authorization_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_isfirstone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_supporting_materials` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `patent_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of patent
-- ----------------------------
INSERT INTO `patent` VALUES (1, '20184323', '楼朝立', 'MyNote3个人笔记软件', '软件著作权', '2020R11L2782388', '202.12.28', '2021SR0488462', '20210402', '是', '2021', '无', '1');
INSERT INTO `patent` VALUES (258963, '789456', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', '1');
INSERT INTO `patent` VALUES (159789546, '1596595', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `project_no` int(11) NOT NULL,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_join_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_teacher_dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_student_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_issubmit` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_supporting_materials` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_audit_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`project_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '2021', '无', '2');
INSERT INTO `project` VALUES (123, '信息系统', '软件学院', '自研', '正在完成', '2021年12月26日', '周老师', '软件学院', 'changyao', '20212413', '是', '2021', 'https://sdasd.com', '0');

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
INSERT INTO `receive` VALUES ('20212413-2022-01-17 15:21:25', '1-2022-01-17 15:21:25', 20212413, 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_no` int(10) NOT NULL,
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
INSERT INTO `student` VALUES (12347, '1111', '张三光', 0, '大数据1班', '1995-12-26', '满', '重庆渝北', '522321199512263756', '党员', '2021', 1, '135959002', '122706559', 'ch@163', '重庆', 'WU');
INSERT INTO `student` VALUES (20201034, '123456', '刘二', 0, '人工智能1', '1995-12-26', '满', '四川成都', '522321', '党员', '2021', 1, '135959002', '122706559', 'ch@163', '重庆', 'WU');
INSERT INTO `student` VALUES (20201234, '123456', '李四', 0, '人工智能1班', '1995-12-26', '汉', '美国纽约', '522321', '党员', '2021', 1, '135959002', '122706559', 'ch@163', '重庆', 'WU');
INSERT INTO `student` VALUES (20204146, '1111', '李四光', 0, '大数据1班', '1995-12-26', '汉', '四川成都', '522321', '共青团员', '2021', 20204146, '18357980493', '122706559', '', '重庆大学', 'WU');
INSERT INTO `student` VALUES (20204567, '123456', '张三', 0, '大数据1班', '1995-12-26', '汉', '四川成都', '522321', '党员', '2021', 1, '135959002', '122706559', 'ch@163', '重庆', 'WU');

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

-- ----------------------------
-- Table structure for voluntary_activities
-- ----------------------------
DROP TABLE IF EXISTS `voluntary_activities`;
CREATE TABLE `voluntary_activities`  (
  `voluntary_activities_no` int(11) NOT NULL,
  `voluntary_activities_stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_studept` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_time_from_to` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_time_long` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of voluntary_activities
-- ----------------------------
INSERT INTO `voluntary_activities` VALUES (1, '周XX', '重庆大学自动化学院', '201700', '2020.12.31  17.00-22.00', '5', '道具搬运', '1');
INSERT INTO `voluntary_activities` VALUES (1, '周XX', '重庆大学自动化学院', '02', '2020.12.31  17.00-22.00', '5', '道具搬运', '1');
INSERT INTO `voluntary_activities` VALUES (0, 'String', 'String', 'String', 'String', 'String', 'String', 'String');

SET FOREIGN_KEY_CHECKS = 1;
