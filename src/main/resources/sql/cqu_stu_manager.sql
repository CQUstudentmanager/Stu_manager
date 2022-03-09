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

 Date: 09/03/2022 12:15:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accommodation_information
-- ----------------------------
DROP TABLE IF EXISTS `accommodation_information`;
CREATE TABLE `accommodation_information`  (
  `accommodation_information_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `accommodation_information_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `accommodation_information_room_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `accommodation_information_bed` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `accommodation_information_building` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `accommodation_information_ismain` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of accommodation_information
-- ----------------------------
INSERT INTO `accommodation_information` VALUES ('20201755162803', '20201755', '123', '2', '竹园5栋', '是');
INSERT INTO `accommodation_information` VALUES (NULL, '20205644', '412', '', '竹园5栋', '是');
INSERT INTO `accommodation_information` VALUES (NULL, '20201640', '109', '1', '竹园5栋', '是');
INSERT INTO `accommodation_information` VALUES (NULL, '20201692', '323', '3', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201656', '316', '1', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201668', '318', '4', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201762', '411', '3', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201770', '476', '1', '松园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201682', '321', '3', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20204051', '611', '1', '梅园6栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20206463', '412', '', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201644', '110', '1', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201662', '471', '1', '松园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201793', '419', '1', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20204050', '526', '1', '松园4栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201756', '410', '1', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201786', '417', '3', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201753', '409', '3', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201707', '328', '1', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201781', '476', '4', '松园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201765', '413', '2', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20204353', '412', '', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201737', '406', '2', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20204176', '412', '', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20205911', '321', '4', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES ('20201686162804', '20201686', '322', '3', '竹园五栋', '是');
INSERT INTO `accommodation_information` VALUES (NULL, '20201787', '417', '4', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201739', '406', '4', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20204145', '408', '1', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES (NULL, '20201749', '408', '4', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES ('20191574162036', '20191574', '205', '3', '兰园5栋', '是');
INSERT INTO `accommodation_information` VALUES (NULL, '20205380', '408', '3', '竹园5栋', NULL);
INSERT INTO `accommodation_information` VALUES ('20214567221957', '20214567', '206', '3', '竹园二栋', '是');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123456789', '123');

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
INSERT INTO `class` VALUES (1, '20软件工程01', 2);
INSERT INTO `class` VALUES (2, '20软件工程02', 2);
INSERT INTO `class` VALUES (3, '20软件工程03', 3);
INSERT INTO `class` VALUES (4, '20软件工程04', NULL);
INSERT INTO `class` VALUES (5, '20软件工程05', NULL);
INSERT INTO `class` VALUES (6, '20软件工程06', NULL);
INSERT INTO `class` VALUES (7, '20大数据班', NULL);
INSERT INTO `class` VALUES (8, '20人工智能班', NULL);
INSERT INTO `class` VALUES (9, '21软件工程01', 3);

-- ----------------------------
-- Table structure for college_entrance_examination
-- ----------------------------
DROP TABLE IF EXISTS `college_entrance_examination`;
CREATE TABLE `college_entrance_examination`  (
  `college_entrance_examination_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0',
  `college_entrance_examination_highschool_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `college_entrance_examination_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `college_entrance_examination_chinese` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `college_entrance_examination_math` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `college_entrance_examination_english` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `college_entrance_examination_comprehensive` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `college_entrance_examination_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of college_entrance_examination
-- ----------------------------
INSERT INTO `college_entrance_examination` VALUES ('String', 'String', 'String', 'String', 'String', 'String', 'String', '20201755');
INSERT INTO `college_entrance_examination` VALUES ('0', '江苏省宝应中学', '城镇应届', NULL, NULL, NULL, NULL, '20205644');
INSERT INTO `college_entrance_examination` VALUES ('0', '鹤庆县第一中学', '农村应届', NULL, NULL, NULL, NULL, '20201640');
INSERT INTO `college_entrance_examination` VALUES ('0', '浙江省瓯海中学', '农村应届', NULL, NULL, NULL, NULL, '20201692');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市第十八中学', '城镇往届', NULL, NULL, NULL, NULL, '20201656');
INSERT INTO `college_entrance_examination` VALUES ('0', '合肥一六八中学', '城镇应届', NULL, NULL, NULL, NULL, '20201668');
INSERT INTO `college_entrance_examination` VALUES ('0', '独山子第二中学', '城镇应届', NULL, NULL, NULL, NULL, '20201762');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市第十一中学校', '城镇应届', NULL, NULL, NULL, NULL, '20201770');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市字水中学', '城镇应届', NULL, NULL, NULL, NULL, '20201682');
INSERT INTO `college_entrance_examination` VALUES ('0', '南昌大学附属中学', '城镇应届', NULL, NULL, NULL, NULL, '20204051');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市凤鸣山中学', '城市应届', NULL, NULL, NULL, NULL, '20206463');
INSERT INTO `college_entrance_examination` VALUES ('0', '南海中学分校', '城镇应届', NULL, NULL, NULL, NULL, '20201644');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市南开中学', '城市应届', NULL, NULL, NULL, NULL, '20201662');
INSERT INTO `college_entrance_examination` VALUES ('0', '渝北中学', '城镇应届', NULL, NULL, NULL, NULL, '20201793');
INSERT INTO `college_entrance_examination` VALUES ('0', '江苏省苏州中学', '城镇应届', NULL, NULL, NULL, NULL, '20204050');
INSERT INTO `college_entrance_examination` VALUES ('0', '江西省临川第二中学', '农村应届', NULL, NULL, NULL, NULL, '20201756');
INSERT INTO `college_entrance_examination` VALUES ('0', '安岳中学', '农村应届', NULL, NULL, NULL, NULL, '20201786');
INSERT INTO `college_entrance_examination` VALUES ('0', '保定市第一中学', '城镇应届', NULL, NULL, NULL, NULL, '20201753');
INSERT INTO `college_entrance_examination` VALUES ('0', '四川省遂宁市卓同', '城镇往届', NULL, NULL, NULL, NULL, '20201707');
INSERT INTO `college_entrance_examination` VALUES ('0', '河南省实验中学', '城镇应届', NULL, NULL, NULL, NULL, '20201781');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市育才中学校', '城镇应届', NULL, NULL, NULL, NULL, '20201765');
INSERT INTO `college_entrance_examination` VALUES ('0', '深圳外国语学校', '城市应届', NULL, NULL, NULL, NULL, '20204353');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市第一中学', '城镇应届', NULL, NULL, NULL, NULL, '20201737');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市璧山中学校', '农村应届', NULL, NULL, NULL, NULL, '20204176');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市潼南中学校', '农村应届', NULL, NULL, NULL, NULL, '20205911');
INSERT INTO `college_entrance_examination` VALUES ('0', '丰都中学校', '农村应届', '111', '111', '111', '111', '20201686');
INSERT INTO `college_entrance_examination` VALUES ('0', '崇庆中学', '城市应届', NULL, NULL, NULL, NULL, '20201787');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市綦江中学', '城镇应届', NULL, NULL, NULL, NULL, '20201739');
INSERT INTO `college_entrance_examination` VALUES ('0', '重庆市渝高中学校', '农村应届', NULL, NULL, NULL, NULL, '20204145');
INSERT INTO `college_entrance_examination` VALUES ('0', '巢湖市第二中学', '农村应届', NULL, NULL, NULL, NULL, '20201749');
INSERT INTO `college_entrance_examination` VALUES ('0', '兴义市第八中学', '农村应届', NULL, NULL, NULL, NULL, '20191574');
INSERT INTO `college_entrance_examination` VALUES ('20214567221351', '兴义市第八中学', '农村应届', '150', '150', '150', '300', '20214567');

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest`  (
  `contest_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
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
INSERT INTO `contest` VALUES ('20214567220213', '452343', '4563', '463', '4634', '364', '34653', '53.53.', '53.', '昌瑶', '20214567', '是', '2032.53.', '766e866a-9523-4619-90b6-2ab155441e58.pdf', '2');
INSERT INTO `contest` VALUES ('20214567140456', 'dfghdf', 'ghdf', 'ghdfgh', 'fgh', 'fghf', 'ghdfg', 'hdfgh', 'fdgh', '昌瑶', '20214567', '是', '2020-12-31T16:00:00.000Z', '61f018e6-9f65-4965-8e65-70ad9be91e96.jpg', '1');

-- ----------------------------
-- Table structure for development_planning
-- ----------------------------
DROP TABLE IF EXISTS `development_planning`;
CREATE TABLE `development_planning`  (
  `development_planning_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_stu_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_room` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_gpa` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_nopass_point` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_wish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_planone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_plantwo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_howto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `development_planning_family_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of development_planning
-- ----------------------------
INSERT INTO `development_planning` VALUES ('1', '223', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `development_planning` VALUES ('4562203080250', '456', 'String', 'String', '444', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String');
INSERT INTO `development_planning` VALUES ('String', '456', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', '000', '1', '1', '123');
INSERT INTO `development_planning` VALUES ('String024711', 'String', 'String', 'String', '444', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String');

-- ----------------------------
-- Table structure for dispatch
-- ----------------------------
DROP TABLE IF EXISTS `dispatch`;
CREATE TABLE `dispatch`  (
  `dispatch_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
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
  `dispatch_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_is_admission` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_is_top200` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dispatch_supporting_materials` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dispatch
-- ----------------------------

-- ----------------------------
-- Table structure for family
-- ----------------------------
DROP TABLE IF EXISTS `family`;
CREATE TABLE `family`  (
  `family_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `family_relationship` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `family_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `family_age` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `family_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `family_work` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `family_duties` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `family_workplace` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `family_ismain` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of family
-- ----------------------------
INSERT INTO `family` VALUES ('20201755', '母亲', '123', NULL, '13364018163', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201755', '父亲', 'String', 'String', '18183019908', 'String', 'String', 'String', 'String');
INSERT INTO `family` VALUES ('20214567', '父亲', '昌兴明', '48', '13595900213', 'asd', 'asd', '123456', '是');
INSERT INTO `family` VALUES ('20214567', '母亲', 'asd', 'asd', 'as', '职工', '职工', '兴义市', '否');
INSERT INTO `family` VALUES ('20201686', '父亲', 'xxx', 'xx', '15826272128', 'xx', 'xx', 'xx', '是');
INSERT INTO `family` VALUES ('20201686', '母亲', '1', '1', '1', '1', '1', '1', '否');

-- ----------------------------
-- Table structure for msginfo
-- ----------------------------
DROP TABLE IF EXISTS `msginfo`;
CREATE TABLE `msginfo`  (
  `msg_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msg_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msg_sender` int(255) NULL DEFAULT NULL,
  `msg_deadline` datetime NULL DEFAULT NULL,
  `msg_releasetime` datetime NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of msginfo
-- ----------------------------
INSERT INTO `msginfo` VALUES ('10000-2022-03-03 11:39:54', 'sadfasd', 10000, NULL, '2022-03-03 11:39:53');
INSERT INTO `msginfo` VALUES ('2-2022-03-04 23:06:00', '1232', 2, NULL, '2022-03-04 23:05:59');
INSERT INTO `msginfo` VALUES ('10000-2022-03-05 23:41:11', '测试', 10000, '2022-03-01 00:00:00', '2022-03-05 23:41:11');
INSERT INTO `msginfo` VALUES ('2-2022-03-05 23:41:32', 'sdasd', 2, NULL, '2022-03-05 23:41:33');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `paper_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `paper_stuno` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `paper_stuname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `paper_periodical` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_publicationTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_iscscd` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_sciSearchNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_eiSearchNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_supporting_materials` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `paper_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('20214567215600', '20214567', '昌瑶', '数据处理', 'AAAI', '2021年12月16日', '是', '10086', '10086', '2020-12-31T16:00:00.000Z', 'd35d1022-11c7-4542-9435-f8a3ef88f4b3.jpg', '1');

-- ----------------------------
-- Table structure for patent
-- ----------------------------
DROP TABLE IF EXISTS `patent`;
CREATE TABLE `patent`  (
  `patent_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
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
INSERT INTO `patent` VALUES ('20214567144755', '20214567', '昌瑶', '12.', '12.', '12.', '12.1', '2.12.', '12.', '是', '2020-12-31T16:00:00.000Z', 'decfc03f-2470-45ad-a88e-063b89a6f3f9.jpg', '1');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `project_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
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
INSERT INTO `project` VALUES ('20214567220530', '20420', '546.', '56.', '67+8', '+78', '9++', '9*', '昌瑶', '20214567', '是', '2020-12-31T16:00:00.000Z', 'c50dfff7-6bdb-4f31-86d6-6242cd6b433c.jpg', '1');

-- ----------------------------
-- Table structure for receive
-- ----------------------------
DROP TABLE IF EXISTS `receive`;
CREATE TABLE `receive`  (
  `receive_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msg_no2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver` int(255) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of receive
-- ----------------------------
INSERT INTO `receive` VALUES ('20191574-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20191574, 0);
INSERT INTO `receive` VALUES ('20191651-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20191651, 0);
INSERT INTO `receive` VALUES ('20191653-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20191653, 0);
INSERT INTO `receive` VALUES ('20191665-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20191665, 0);
INSERT INTO `receive` VALUES ('20194048-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20194048, 0);
INSERT INTO `receive` VALUES ('20194093-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20194093, 0);
INSERT INTO `receive` VALUES ('20194228-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20194228, 0);
INSERT INTO `receive` VALUES ('20194280-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20194280, 0);
INSERT INTO `receive` VALUES ('20200136-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20200136, 0);
INSERT INTO `receive` VALUES ('20200658-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20200658, 0);
INSERT INTO `receive` VALUES ('20201576-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201576, 0);
INSERT INTO `receive` VALUES ('20201577-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201577, 0);
INSERT INTO `receive` VALUES ('20201578-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201578, 0);
INSERT INTO `receive` VALUES ('20201579-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201579, 0);
INSERT INTO `receive` VALUES ('20201580-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201580, 0);
INSERT INTO `receive` VALUES ('20201581-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201581, 0);
INSERT INTO `receive` VALUES ('20201582-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201582, 0);
INSERT INTO `receive` VALUES ('20201583-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201583, 0);
INSERT INTO `receive` VALUES ('20201584-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201584, 0);
INSERT INTO `receive` VALUES ('20201585-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201585, 0);
INSERT INTO `receive` VALUES ('20201586-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201586, 0);
INSERT INTO `receive` VALUES ('20201587-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201587, 0);
INSERT INTO `receive` VALUES ('20201588-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201588, 0);
INSERT INTO `receive` VALUES ('20201589-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201589, 0);
INSERT INTO `receive` VALUES ('20201590-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201590, 0);
INSERT INTO `receive` VALUES ('20201591-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201591, 0);
INSERT INTO `receive` VALUES ('20201592-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201592, 0);
INSERT INTO `receive` VALUES ('20201593-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201593, 0);
INSERT INTO `receive` VALUES ('20201594-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201594, 0);
INSERT INTO `receive` VALUES ('20201595-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201595, 0);
INSERT INTO `receive` VALUES ('20201596-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201596, 0);
INSERT INTO `receive` VALUES ('20201597-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201597, 0);
INSERT INTO `receive` VALUES ('20201598-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201598, 0);
INSERT INTO `receive` VALUES ('20201599-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201599, 0);
INSERT INTO `receive` VALUES ('20201600-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201600, 0);
INSERT INTO `receive` VALUES ('20201602-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201602, 0);
INSERT INTO `receive` VALUES ('20201603-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201603, 0);
INSERT INTO `receive` VALUES ('20201604-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201604, 0);
INSERT INTO `receive` VALUES ('20201605-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201605, 0);
INSERT INTO `receive` VALUES ('20201606-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201606, 0);
INSERT INTO `receive` VALUES ('20201607-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201607, 0);
INSERT INTO `receive` VALUES ('20201608-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201608, 0);
INSERT INTO `receive` VALUES ('20201609-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201609, 0);
INSERT INTO `receive` VALUES ('20201610-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201610, 0);
INSERT INTO `receive` VALUES ('20201611-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201611, 0);
INSERT INTO `receive` VALUES ('20201612-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201612, 0);
INSERT INTO `receive` VALUES ('20201613-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201613, 0);
INSERT INTO `receive` VALUES ('20201614-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201614, 0);
INSERT INTO `receive` VALUES ('20201615-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201615, 0);
INSERT INTO `receive` VALUES ('20201616-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201616, 0);
INSERT INTO `receive` VALUES ('20201617-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201617, 0);
INSERT INTO `receive` VALUES ('20201618-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201618, 0);
INSERT INTO `receive` VALUES ('20201619-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201619, 0);
INSERT INTO `receive` VALUES ('20201620-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201620, 0);
INSERT INTO `receive` VALUES ('20201621-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201621, 0);
INSERT INTO `receive` VALUES ('20201622-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201622, 0);
INSERT INTO `receive` VALUES ('20201623-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201623, 0);
INSERT INTO `receive` VALUES ('20201624-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201624, 0);
INSERT INTO `receive` VALUES ('20201625-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201625, 0);
INSERT INTO `receive` VALUES ('20201626-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201626, 0);
INSERT INTO `receive` VALUES ('20201627-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201627, 0);
INSERT INTO `receive` VALUES ('20201628-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201628, 0);
INSERT INTO `receive` VALUES ('20201629-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201629, 0);
INSERT INTO `receive` VALUES ('20201630-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201630, 0);
INSERT INTO `receive` VALUES ('20201631-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201631, 0);
INSERT INTO `receive` VALUES ('20201632-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201632, 0);
INSERT INTO `receive` VALUES ('20201633-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201633, 0);
INSERT INTO `receive` VALUES ('20201634-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201634, 0);
INSERT INTO `receive` VALUES ('20201635-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201635, 0);
INSERT INTO `receive` VALUES ('20201636-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201636, 0);
INSERT INTO `receive` VALUES ('20201637-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201637, 0);
INSERT INTO `receive` VALUES ('20201638-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201638, 0);
INSERT INTO `receive` VALUES ('20201639-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201639, 0);
INSERT INTO `receive` VALUES ('20201640-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201640, 0);
INSERT INTO `receive` VALUES ('20201642-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201642, 0);
INSERT INTO `receive` VALUES ('20201643-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201643, 0);
INSERT INTO `receive` VALUES ('20201644-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201644, 0);
INSERT INTO `receive` VALUES ('20201646-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201646, 0);
INSERT INTO `receive` VALUES ('20201648-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201648, 0);
INSERT INTO `receive` VALUES ('20201649-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201649, 0);
INSERT INTO `receive` VALUES ('20201650-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201650, 0);
INSERT INTO `receive` VALUES ('20201651-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201651, 0);
INSERT INTO `receive` VALUES ('20201652-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201652, 0);
INSERT INTO `receive` VALUES ('20201653-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201653, 0);
INSERT INTO `receive` VALUES ('20201654-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201654, 0);
INSERT INTO `receive` VALUES ('20201655-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201655, 0);
INSERT INTO `receive` VALUES ('20201656-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201656, 0);
INSERT INTO `receive` VALUES ('20201657-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201657, 0);
INSERT INTO `receive` VALUES ('20201658-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201658, 0);
INSERT INTO `receive` VALUES ('20201659-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201659, 0);
INSERT INTO `receive` VALUES ('20201660-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201660, 0);
INSERT INTO `receive` VALUES ('20201661-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201661, 0);
INSERT INTO `receive` VALUES ('20201662-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201662, 0);
INSERT INTO `receive` VALUES ('20201663-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201663, 0);
INSERT INTO `receive` VALUES ('20201664-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201664, 0);
INSERT INTO `receive` VALUES ('20201665-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201665, 0);
INSERT INTO `receive` VALUES ('20201668-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201668, 0);
INSERT INTO `receive` VALUES ('20201675-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201675, 0);
INSERT INTO `receive` VALUES ('20201678-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201678, 0);
INSERT INTO `receive` VALUES ('20201682-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201682, 0);
INSERT INTO `receive` VALUES ('20201683-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201683, 0);
INSERT INTO `receive` VALUES ('20201685-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201685, 0);
INSERT INTO `receive` VALUES ('20201686-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201686, 0);
INSERT INTO `receive` VALUES ('20201687-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201687, 2);
INSERT INTO `receive` VALUES ('20201688-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201688, 0);
INSERT INTO `receive` VALUES ('20201690-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201690, 0);
INSERT INTO `receive` VALUES ('20201691-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201691, 0);
INSERT INTO `receive` VALUES ('20201692-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201692, 0);
INSERT INTO `receive` VALUES ('20201694-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201694, 0);
INSERT INTO `receive` VALUES ('20201695-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201695, 0);
INSERT INTO `receive` VALUES ('20201697-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201697, 0);
INSERT INTO `receive` VALUES ('20201699-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201699, 0);
INSERT INTO `receive` VALUES ('20201700-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201700, 0);
INSERT INTO `receive` VALUES ('20201701-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201701, 0);
INSERT INTO `receive` VALUES ('20201702-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201702, 0);
INSERT INTO `receive` VALUES ('20201703-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201703, 0);
INSERT INTO `receive` VALUES ('20201704-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201704, 0);
INSERT INTO `receive` VALUES ('20201706-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201706, 0);
INSERT INTO `receive` VALUES ('20201707-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201707, 0);
INSERT INTO `receive` VALUES ('20201708-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201708, 0);
INSERT INTO `receive` VALUES ('20201709-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201709, 0);
INSERT INTO `receive` VALUES ('20201710-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201710, 0);
INSERT INTO `receive` VALUES ('20201711-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201711, 0);
INSERT INTO `receive` VALUES ('20201712-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201712, 0);
INSERT INTO `receive` VALUES ('20201713-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201713, 0);
INSERT INTO `receive` VALUES ('20201714-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201714, 0);
INSERT INTO `receive` VALUES ('20201715-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201715, 0);
INSERT INTO `receive` VALUES ('20201720-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201720, 0);
INSERT INTO `receive` VALUES ('20201721-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201721, 0);
INSERT INTO `receive` VALUES ('20201724-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201724, 0);
INSERT INTO `receive` VALUES ('20201725-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201725, 0);
INSERT INTO `receive` VALUES ('20201726-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201726, 0);
INSERT INTO `receive` VALUES ('20201728-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201728, 0);
INSERT INTO `receive` VALUES ('20201729-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201729, 0);
INSERT INTO `receive` VALUES ('20201730-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201730, 0);
INSERT INTO `receive` VALUES ('20201734-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201734, 0);
INSERT INTO `receive` VALUES ('20201737-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201737, 0);
INSERT INTO `receive` VALUES ('20201738-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201738, 0);
INSERT INTO `receive` VALUES ('20201739-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201739, 0);
INSERT INTO `receive` VALUES ('20201740-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201740, 0);
INSERT INTO `receive` VALUES ('20201741-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201741, 0);
INSERT INTO `receive` VALUES ('20201743-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201743, 0);
INSERT INTO `receive` VALUES ('20201745-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201745, 0);
INSERT INTO `receive` VALUES ('20201747-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201747, 0);
INSERT INTO `receive` VALUES ('20201749-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201749, 0);
INSERT INTO `receive` VALUES ('20201750-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201750, 0);
INSERT INTO `receive` VALUES ('20201751-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201751, 0);
INSERT INTO `receive` VALUES ('20201753-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201753, 0);
INSERT INTO `receive` VALUES ('20201754-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201754, 0);
INSERT INTO `receive` VALUES ('20201755-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201755, 0);
INSERT INTO `receive` VALUES ('20201756-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201756, 0);
INSERT INTO `receive` VALUES ('20201757-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201757, 0);
INSERT INTO `receive` VALUES ('20201758-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201758, 0);
INSERT INTO `receive` VALUES ('20201759-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201759, 0);
INSERT INTO `receive` VALUES ('20201762-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201762, 0);
INSERT INTO `receive` VALUES ('20201763-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201763, 0);
INSERT INTO `receive` VALUES ('20201764-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201764, 0);
INSERT INTO `receive` VALUES ('20201765-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201765, 0);
INSERT INTO `receive` VALUES ('20201766-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201766, 0);
INSERT INTO `receive` VALUES ('20201767-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201767, 0);
INSERT INTO `receive` VALUES ('20201768-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201768, 0);
INSERT INTO `receive` VALUES ('20201769-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201769, 0);
INSERT INTO `receive` VALUES ('20201770-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201770, 0);
INSERT INTO `receive` VALUES ('20201771-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201771, 0);
INSERT INTO `receive` VALUES ('20201772-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201772, 0);
INSERT INTO `receive` VALUES ('20201773-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201773, 0);
INSERT INTO `receive` VALUES ('20201774-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201774, 0);
INSERT INTO `receive` VALUES ('20201775-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201775, 0);
INSERT INTO `receive` VALUES ('20201776-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201776, 0);
INSERT INTO `receive` VALUES ('20201778-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201778, 0);
INSERT INTO `receive` VALUES ('20201779-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201779, 0);
INSERT INTO `receive` VALUES ('20201780-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201780, 0);
INSERT INTO `receive` VALUES ('20201781-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201781, 0);
INSERT INTO `receive` VALUES ('20201782-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201782, 0);
INSERT INTO `receive` VALUES ('20201786-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201786, 0);
INSERT INTO `receive` VALUES ('20201787-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201787, 0);
INSERT INTO `receive` VALUES ('20201788-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201788, 0);
INSERT INTO `receive` VALUES ('20201789-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201789, 0);
INSERT INTO `receive` VALUES ('20201790-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201790, 0);
INSERT INTO `receive` VALUES ('20201791-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201791, 0);
INSERT INTO `receive` VALUES ('20201792-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201792, 0);
INSERT INTO `receive` VALUES ('20201793-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201793, 0);
INSERT INTO `receive` VALUES ('20201795-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201795, 0);
INSERT INTO `receive` VALUES ('20201796-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201796, 0);
INSERT INTO `receive` VALUES ('20201797-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201797, 0);
INSERT INTO `receive` VALUES ('20201800-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20201800, 0);
INSERT INTO `receive` VALUES ('20202738-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20202738, 0);
INSERT INTO `receive` VALUES ('20202864-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20202864, 0);
INSERT INTO `receive` VALUES ('20203144-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20203144, 0);
INSERT INTO `receive` VALUES ('20204050-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204050, 0);
INSERT INTO `receive` VALUES ('20204051-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204051, 0);
INSERT INTO `receive` VALUES ('20204095-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204095, 0);
INSERT INTO `receive` VALUES ('20204103-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204103, 0);
INSERT INTO `receive` VALUES ('20204106-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204106, 0);
INSERT INTO `receive` VALUES ('20204114-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204114, 0);
INSERT INTO `receive` VALUES ('20204123-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204123, 0);
INSERT INTO `receive` VALUES ('20204125-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204125, 0);
INSERT INTO `receive` VALUES ('20204126-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204126, 0);
INSERT INTO `receive` VALUES ('20204138-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204138, 0);
INSERT INTO `receive` VALUES ('20204139-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204139, 0);
INSERT INTO `receive` VALUES ('20204141-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204141, 0);
INSERT INTO `receive` VALUES ('20204145-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204145, 0);
INSERT INTO `receive` VALUES ('20204146-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204146, 0);
INSERT INTO `receive` VALUES ('20204153-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204153, 0);
INSERT INTO `receive` VALUES ('20204158-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204158, 0);
INSERT INTO `receive` VALUES ('20204159-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204159, 0);
INSERT INTO `receive` VALUES ('20204176-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204176, 0);
INSERT INTO `receive` VALUES ('20204177-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204177, 0);
INSERT INTO `receive` VALUES ('20204180-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204180, 0);
INSERT INTO `receive` VALUES ('20204182-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204182, 0);
INSERT INTO `receive` VALUES ('20204189-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204189, 0);
INSERT INTO `receive` VALUES ('20204193-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204193, 0);
INSERT INTO `receive` VALUES ('20204218-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204218, 0);
INSERT INTO `receive` VALUES ('20204219-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204219, 0);
INSERT INTO `receive` VALUES ('20204226-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204226, 0);
INSERT INTO `receive` VALUES ('20204229-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204229, 0);
INSERT INTO `receive` VALUES ('20204230-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204230, 0);
INSERT INTO `receive` VALUES ('20204235-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204235, 0);
INSERT INTO `receive` VALUES ('20204236-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204236, 0);
INSERT INTO `receive` VALUES ('20204238-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204238, 0);
INSERT INTO `receive` VALUES ('20204239-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204239, 0);
INSERT INTO `receive` VALUES ('20204240-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204240, 0);
INSERT INTO `receive` VALUES ('20204253-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204253, 0);
INSERT INTO `receive` VALUES ('20204257-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204257, 0);
INSERT INTO `receive` VALUES ('20204259-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204259, 0);
INSERT INTO `receive` VALUES ('20204267-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204267, 0);
INSERT INTO `receive` VALUES ('20204269-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204269, 0);
INSERT INTO `receive` VALUES ('20204283-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204283, 0);
INSERT INTO `receive` VALUES ('20204290-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204290, 0);
INSERT INTO `receive` VALUES ('20204310-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204310, 0);
INSERT INTO `receive` VALUES ('20204323-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204323, 0);
INSERT INTO `receive` VALUES ('20204326-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204326, 0);
INSERT INTO `receive` VALUES ('20204328-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204328, 0);
INSERT INTO `receive` VALUES ('20204335-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204335, 0);
INSERT INTO `receive` VALUES ('20204338-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204338, 0);
INSERT INTO `receive` VALUES ('20204347-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204347, 0);
INSERT INTO `receive` VALUES ('20204353-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204353, 0);
INSERT INTO `receive` VALUES ('20204366-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204366, 0);
INSERT INTO `receive` VALUES ('20204372-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204372, 0);
INSERT INTO `receive` VALUES ('20204627-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204627, 0);
INSERT INTO `receive` VALUES ('20204875-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20204875, 0);
INSERT INTO `receive` VALUES ('20205172-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20205172, 0);
INSERT INTO `receive` VALUES ('20205380-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20205380, 0);
INSERT INTO `receive` VALUES ('20205644-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20205644, 0);
INSERT INTO `receive` VALUES ('20205911-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20205911, 0);
INSERT INTO `receive` VALUES ('20206024-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20206024, 0);
INSERT INTO `receive` VALUES ('20206351-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20206351, 0);
INSERT INTO `receive` VALUES ('20206353-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20206353, 0);
INSERT INTO `receive` VALUES ('20206463-2022-03-03 11:39:54', '10000-2022-03-03 11:39:54', 20206463, 0);
INSERT INTO `receive` VALUES ('20214567-2022-03-04 23:06:00', '2-2022-03-04 23:06:00', 20214567, 2);
INSERT INTO `receive` VALUES ('20201686-2022-03-05 23:41:11', '10000-2022-03-05 23:41:11', 20201686, 0);
INSERT INTO `receive` VALUES ('20214567-2022-03-05 23:41:32', '2-2022-03-05 23:41:32', 20214567, 2);

-- ----------------------------
-- Table structure for stay_school_info
-- ----------------------------
DROP TABLE IF EXISTS `stay_school_info`;
CREATE TABLE `stay_school_info`  (
  `stay_school_info_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `stay_school_info_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `stay_school_info_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `stay_school_info_end` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `stay_school_info_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `stay_school_info_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `stay_school_info_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `stay_school_info_stuname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `stay_school_info_stuclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stay_school_info
-- ----------------------------
INSERT INTO `stay_school_info` VALUES (NULL, NULL, '232', NULL, NULL, '2020-2021暑假', '2020-2021暑假', '20软件工程01', '20软件工程01');
INSERT INTO `stay_school_info` VALUES (NULL, NULL, '232', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `stay_school_info` VALUES ('String162340', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String');

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
  `stu_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_join_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stu_no`) USING BTREE,
  INDEX `Stu_class`(`stu_class`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (20191574, '123', '曹越', 1, '20软件工程04', '2000年1月', '汉族', '江西省', '522321199512263756', '团员', '2000年1月', 1, '18357980493', '122706559', '122706559@qq.com', '贵州省兴义市万屯镇海峰村', NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20191651, '20191651', '李昊哲', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '202124131113@cqu.edu.cn', NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20191653, '20191653', '焦波桥', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20191665, '20191665', '蔡林汛', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20194048, '20194048', '杨廷', 1, '20软件工程03', NULL, '苗族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20194093, '20194093', '周雅萱', 0, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20194228, '20194228\r\n', '张怡宁', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (20194280, '20194280', '谭千禧', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20200136, '20200136', '武林霄', 0, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20200658, '20200658', '解骥烨', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201576, '20201576', '孙睿', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201577, '20201577', '黄应诚', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201578, '20201578', '李楠楠', 1, '20人工智能班', NULL, '壮族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201579, '20201579', '徐小天', 1, '20人工智能班', NULL, '苗族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201580, '20201580', '胡凯洋', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201581, '20201581', '范益诚', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201582, '20201582', '曹佳睿', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201583, '20201583', '唐湘林', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201584, '20201584', '王子杰', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201585, '20201585', '张佳伟', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201586, '20201586', '徐铭泽', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201587, '20201587', '王士嘉', 1, '20人工智能班', NULL, '蒙古族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201588, '20201588', '张超然', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201589, '20201589', '张沫然', 1, '20人工智能班', NULL, '回族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201590, '20201590', '熊梦然', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201591, '20201591', '刘凯', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201592, '20201592', '漆文宇', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201593, '20201593', '陈易强', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201594, '20201594', '冷祥', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201595, '20201595', '张献巍', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201596, '20201596', '李芊玥', 0, '20人工智能班', NULL, '土家族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201597, '20201597', '熊香愉', 0, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201598, '20201598', '曾子越', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201599, '20201599', '徐嘉栋', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201600, '20201600', '齐翔宇', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201602, '20201602', '张雍弦', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201603, '20201603', '宋东焕', 1, '20人工智能班', NULL, '朝鲜族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201604, '20201604', '项君瑞', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201605, '20201605', '钟准', 1, '20人工智能班', NULL, '畲族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201606, '20201606', '黄晓辉', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201607, '20201607', '李晓玲', 0, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20201608, '20201608', '杨博雅', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201609, '20201609', '汪欣仪', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201610, '20201610', '黄文轩', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201611, '20201611', '宋湘阳', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201612, '20201612', '黄靖雷', 1, '20大数据班', NULL, '壮族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201613, '20201613', '何雪雨', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201614, '20201614', '康文郡', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201615, '20201615', '邵欣鑫', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201616, '20201616', '刘子萌', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201617, '20201617', '喻小潇', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201618, '20201618', '周紫依', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201619, '20201619', '杨鹏', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201620, '20201620', '荀佳播', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201621, '20201621', '郭岳屹', 1, '20大数据班', NULL, '满族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201622, '20201622', '卢少柯', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201623, '20201623', '宋晔冰', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201624, '20201624', '唐晨', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201625, '20201625', '庞棋文', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201626, '20201626', '林煜涵', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201627, '20201627', '阳承希', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201628, '20201628', '张盛佳', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201629, '20201629', '童柯辑', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201630, '20201630', '陈威', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201631, '20201631', '向寒', 0, '20大数据班', NULL, '土家族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201632, '20201632', '陈季藩', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201633, '20201633', '李骋昊', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201634, '20201634', '白小松', 1, '20大数据班', NULL, '蒙古族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201635, '20201635', '王英奇', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201636, '20201636', '李佳丽', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201637, '20201637', '虞果', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201638, '20201638', '许若伊', 0, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20201639, '20201639', '赵国强', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201640, '20201640', '田先民', 1, '20软件工程01', NULL, '白族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201642, '20201642', '袁振宇', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201643, '20201643', '林城', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201644, '20201644', '李润东', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201646, '20201646', '余思瑶', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201648, '20201648', '秦泽亮', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201649, '20201649', '宁嘉煊', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201650, '20201650', '李骁', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201651, '20201651', '孙中悦', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201652, '20201652', '陈星宇', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201653, '20201653', '冯懿文', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201654, '20201654', '张苏鹏', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201655, '20201655', '王妍心', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201656, '20201656', '刘瑞奇', 1, '20软件工程01', NULL, '汉族', '1111', NULL, '群众', '2022-03-08T16:00:00.000Z', 0, NULL, NULL, NULL, 'zxcz', 'c29e8ff2-8206-4de5-bba1-8dc09dd40a5b.jpg', '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201657, '20201657', '王以勋', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201658, '20201658', '余鹏', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201659, '20201659', '刘星宇', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201660, '20201660', '吴治霖', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201661, '20201661', '陈武', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201662, '20201662', '高琳璐', 0, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201663, '20201663', '王文焘', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201664, '20201664', '韩天瑞', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201665, '20201665', '程了然', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201668, '20201668', '卢承兮', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201675, '20201675', '李颜冰', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201678, '20201678', '何乐为', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201682, '20201682', '陈佳明', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201683, '20201683', '雷鹏宇', 1, '20软件工程02', NULL, '畲族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201685, '20201685', '尤艺潼', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201686, '20201686', '张强', 1, '20软件工程01', '2001-12-12', '汉族', '重庆市丰都县xxxxxx', NULL, '共青团员', '2017-01-03T16:00:00.000Z', 0, '18183019908', '2499497317', '2499497317@qq.com', '重庆市沙坪坝区xxxxxx', '8ea9a742-ca58-46a9-8a3d-039ac5c7dc0f.jpg', '软件工程', '2020-09-01');
INSERT INTO `student` VALUES (20201687, '20201687', '廖新宇', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201688, '20201688', '李钥莹', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '0ebf848f-e8d7-4aa8-9208-29597ea152d7.jpg', '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201690, '20201690', '李以芳', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201691, '20201691', '周伟建', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201692, '20201692', '陈天宇', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201694, '20201694', '简文杰', 1, '20软件工程03', NULL, '仡佬族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201695, '20201695', '崔士骥', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201697, '20201697', '任禛', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201699, '20201699', '要波', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201700, '20201700', '刘旭', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201701, '20201701', '王宇哲', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201702, '20201702', '杨浩然', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201703, '20201703', '谢宝杰', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201704, '20201704', '徐文轩', 0, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201706, '20201706', '郑民洙', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201707, '20201707', '彭越涵', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201708, '20201708', '伍晨露', 0, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201709, '20201709', '何玄', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201710, '20201710', '张严', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201711, '20201711', '魏修远', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201712, '20201712', '柯振尧', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201713, '20201713', '曾骏杰', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201714, '20201714', '雷昭鑫', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201715, '20201715', '张洋华', 1, '20软件工程03', NULL, '土家族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201720, '20201720', '杨洵', 1, '20软件工程04', NULL, '布依族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201721, '20201721', '秦昊', 1, '20软件工程04', NULL, '壮族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201724, '20201724', '王志杰', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201725, '20201725', '蔡晓明', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201726, '20201726', '李晨雨', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201728, '20201728', '雷祥', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201729, '20201729', '解瑞', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201730, '20201730', '牛君礼', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201734, '20201734', '邓宇轩', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201737, '20201737', '郑凌韬', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201738, '20201738', '李钦沛', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201739, '20201739', '卢宇航', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201740, '20201740', '吴浩然', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201741, '20201741', '何连杰', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201743, '20201743', '冯霞', 0, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201745, '20201745', '孙雪婷', 0, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201747, '20201747', '赵庆坤', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201749, '20201749', '李骥琛', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201750, '20201750', '王腾飞', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201751, '20201751', '刘泽凯', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201753, '20201753', '陈禹硕', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201754, '20201754', '秦煜祺', 0, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201755, '20201755', '邱天', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201756, '20201756', '艾逸明', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201757, '20201757', '吴发荣', 1, '20软件工程05', NULL, '藏族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201758, '20201758', '张鑫', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201759, '20201759', '彭天琪', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201762, '20201762', '赵欣昀', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201763, '20201763', '黄思源', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201764, '20201764', '李治莹', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201765, '20201765', '李嘉俊', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201766, '20201766', '彭塬森', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201767, '20201767', '何航', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201768, '20201768', '黄启宇', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201769, '20201769', '隆芊积', 1, '20软件工程05', NULL, '土家族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201770, '20201770', '何静仪', 0, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201771, '20201771', '陈贤诗', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201772, '20201772', '曹恬恬', 0, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201773, '20201773', '白永斌', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201774, '20201774', '齐昌吉', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201775, '20201775', '袁浪', 1, '20软件工程06', NULL, '土家族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201776, '20201776', '高旭', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201778, '20201778', '欧振坪', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201779, '20201779', '陈小', 0, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201780, '20201780', '雷一诺', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201781, '20201781', '钟梓文', 0, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201782, '20201782', '邱可真', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201786, '20201786', '唐葆程', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201787, '20201787', '杨昊淼', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201788, '20201788', '刘蕾', 0, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201789, '20201789', '李想', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201790, '20201790', '董佳俊', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201791, '20201791', '鲁星铭', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201792, '20201792', '郑世杰', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201793, '20201793', '余泽伟', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201795, '20201795', '肖泉君', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201796, '20201796', '冉依霖', 1, '20软件工程06', NULL, '土家族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201797, '20201797', '孙越', 0, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201800, '20201800', '倪喆', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20202738, '20202738', '曾吾悠', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20202864, '20202864', '李先优', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20203144, '20203144', '肖博毅', 1, '20人工智能班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '人工智能班', '2020年9月');
INSERT INTO `student` VALUES (20204050, '20204050', '屈咏清', 0, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204051, '20204051', '朱子骏', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204095, '20204095', '魏苇', 0, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204103, '20204103', '叶哲铭', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204106, '20204106', '潘芝伶', 0, '20软件工程06', NULL, '壮族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204114, '20204114', '谢婷', 0, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204123, '20204123', '田雨鑫', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204125, '20204125', '张思远', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204126, '20204126', '陈俊羽', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204138, '20204138', '廖弘宇', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204139, '20204139', '卢彦博', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204141, '20204141', '盛茜', 0, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204145, '20204145', '邱盈钢', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204146, '20204146', '李潇', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204153, '20204153', '郑楠', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204158, '20204158', '唐一凡', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204159, '20204159', '贾昊', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204176, '20204176', '王磊', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204177, '20204177', '袁小帆', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204180, '20204180', '王子腾', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204182, '20204182', '高弘扬', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204189, '20204189', '韦东', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204193, '20204193', '董盛阳', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204218, '20204218', '赵李博', 1, '20软件工程04', NULL, '满族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204219, '20204219', '王伟', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204226, '20204226', '罗成员', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204229, '20204229', '朱开源', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204230, '20204230', '谢振鹏', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204235, '20204235', '唐梦旭', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204236, '20204236', '刘雨桐', 1, '20软件工程05', NULL, '满族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204238, '20204238', '林宥任', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204239, '20204239', '周羿', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204240, '20204240', '赵宇翔', 1, '20软件工程06', NULL, '傣族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204253, '20204253', '李双均', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204257, '20204257', '龙虹霖', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204259, '20204259', '唐福鑫', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204267, '20204267', '吕旭飞', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204269, '20204269', '陈昕睿', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204283, '20204283', '李鹏程', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204290, '20204290', '王艺', 0, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204310, '20204310', '郑慧琳', 0, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204323, '20204323', '伍欣怡', 0, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204326, '20204326', '李泽奥', 1, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204328, '20204328', '卯文浩', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204335, '20204335', '张城铵', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204338, '20204338', '和晓东', 1, '20软件工程04', NULL, '纳西族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204347, '20204347', '邵壮', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204353, '20204353', '王超', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204366, '20204366', '陈俊彦', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204372, '20204372', '周珈羽', 0, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20204627, '20204627', '陶周', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20204875, '20204875', '武宇江', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20205172, '20205172', '蒋艾恒', 1, '20大数据班', NULL, '汉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大数据班', '2020年9月');
INSERT INTO `student` VALUES (20205380, '20205380', '姚颖茜', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20205644, '20205644', '李易燔', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20205911, '20205911', '薛翔', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20206024, '20206024', '谭晏欣', 0, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20206351, '20206351', '吴骏', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20206353, '20206353', '秦晗轩', 1, '20软件工程05', NULL, '侗族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20206463, '20206463', '曾颉', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20214567, '12', '昌瑶', 1, '21软件工程01', '1995-12-26', '汉族', '贵州省', '522321199512263756', '中共党员', '2022-02-28T16:00:00.000Z', 0, '18357980493', '122706559', '122706559@qq.com', '贵州省兴义市万屯镇', '9cd93baf-413c-4e59-82f9-a639dc47c327.jpg', '软件工程', '2021-09-01');

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
INSERT INTO `teacher` VALUES (0, 'String', 'String', 'String', 'String', 0);
INSERT INTO `teacher` VALUES (3, '3', 's', '55', '3', 2);
INSERT INTO `teacher` VALUES (10000000, 'tan', '谭老师', '13595922234', '431', 20);
INSERT INTO `teacher` VALUES (10000001, '123456', '测试老师', '13595900213', '654', 21);

-- ----------------------------
-- Table structure for voluntary_activities
-- ----------------------------
DROP TABLE IF EXISTS `voluntary_activities`;
CREATE TABLE `voluntary_activities`  (
  `voluntary_activities_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `voluntary_activities_stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_studept` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_time_from_to` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_time_long` double(255, 0) NULL DEFAULT NULL,
  `voluntary_activities_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `voluntary_activities_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of voluntary_activities
-- ----------------------------
INSERT INTO `voluntary_activities` VALUES ('20214567155604', '昌瑶', '125154', '20214567', '33', 1, '353', '1', '15561', '0e7988d3-74e4-4047-8613-a71f4c295e17.jpg');

SET FOREIGN_KEY_CHECKS = 1;
