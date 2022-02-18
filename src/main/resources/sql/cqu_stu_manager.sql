/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : cqu_stu_manager

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 18/02/2022 18:01:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accommodation_information
-- ----------------------------
DROP TABLE IF EXISTS `accommodation_information`;
CREATE TABLE `accommodation_information`  (
  `accommodation_information_no` int(11) NULL DEFAULT NULL,
  `accommodation_information_stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `accommodation_information_room_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `accommodation_information_bed` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `accommodation_information_building` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of accommodation_information
-- ----------------------------
INSERT INTO `accommodation_information` VALUES (NULL, '20201755', '409', '4', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20205644', '412', '', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201640', '109', '1', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201692', '323', '3', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201656', '316', '1', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201668', '318', '4', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201762', '411', '3', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201770', '476', '1', '松园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201682', '321', '3', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20204051', '611', '1', '梅园6栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20206463', '412', '', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201644', '110', '1', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201662', '471', '1', '松园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201793', '419', '1', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20204050', '526', '1', '松园4栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201756', '410', '1', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201786', '417', '3', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201753', '409', '3', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201707', '328', '1', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201781', '476', '4', '松园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201765', '413', '2', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20204353', '412', '', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201737', '406', '2', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20204176', '412', '', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20205911', '321', '4', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201686', '322', '3', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201787', '417', '4', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201739', '406', '4', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20204145', '408', '1', '竹园5栋');
INSERT INTO `accommodation_information` VALUES (NULL, '20201749', '408', '4', '竹园5栋');

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
INSERT INTO `class` VALUES (2, '20软件工程02', 1);
INSERT INTO `class` VALUES (3, '20软件工程03', NULL);
INSERT INTO `class` VALUES (4, '20软件工程04', NULL);
INSERT INTO `class` VALUES (5, '20软件工程05', NULL);
INSERT INTO `class` VALUES (6, '20软件工程06', NULL);
INSERT INTO `class` VALUES (7, '20大数据班', NULL);
INSERT INTO `class` VALUES (8, '20人工智能班', NULL);

-- ----------------------------
-- Table structure for college_entrance_examination
-- ----------------------------
DROP TABLE IF EXISTS `college_entrance_examination`;
CREATE TABLE `college_entrance_examination`  (
  `college_entrance_examination_no` int(11) NULL DEFAULT 0,
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
INSERT INTO `college_entrance_examination` VALUES (0, '江苏省前黄高级中学', '城镇应届', NULL, NULL, NULL, NULL, '20201755');
INSERT INTO `college_entrance_examination` VALUES (0, '江苏省宝应中学', '城镇应届', NULL, NULL, NULL, NULL, '20205644');
INSERT INTO `college_entrance_examination` VALUES (0, '鹤庆县第一中学', '农村应届', NULL, NULL, NULL, NULL, '20201640');
INSERT INTO `college_entrance_examination` VALUES (0, '浙江省瓯海中学', '农村应届', NULL, NULL, NULL, NULL, '20201692');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市第十八中学', '城镇往届', NULL, NULL, NULL, NULL, '20201656');
INSERT INTO `college_entrance_examination` VALUES (0, '合肥一六八中学', '城镇应届', NULL, NULL, NULL, NULL, '20201668');
INSERT INTO `college_entrance_examination` VALUES (0, '独山子第二中学', '城镇应届', NULL, NULL, NULL, NULL, '20201762');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市第十一中学校', '城镇应届', NULL, NULL, NULL, NULL, '20201770');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市字水中学', '城镇应届', NULL, NULL, NULL, NULL, '20201682');
INSERT INTO `college_entrance_examination` VALUES (0, '南昌大学附属中学', '城镇应届', NULL, NULL, NULL, NULL, '20204051');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市凤鸣山中学', '城市应届', NULL, NULL, NULL, NULL, '20206463');
INSERT INTO `college_entrance_examination` VALUES (0, '南海中学分校', '城镇应届', NULL, NULL, NULL, NULL, '20201644');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市南开中学', '城市应届', NULL, NULL, NULL, NULL, '20201662');
INSERT INTO `college_entrance_examination` VALUES (0, '渝北中学', '城镇应届', NULL, NULL, NULL, NULL, '20201793');
INSERT INTO `college_entrance_examination` VALUES (0, '江苏省苏州中学', '城镇应届', NULL, NULL, NULL, NULL, '20204050');
INSERT INTO `college_entrance_examination` VALUES (0, '江西省临川第二中学', '农村应届', NULL, NULL, NULL, NULL, '20201756');
INSERT INTO `college_entrance_examination` VALUES (0, '安岳中学', '农村应届', NULL, NULL, NULL, NULL, '20201786');
INSERT INTO `college_entrance_examination` VALUES (0, '保定市第一中学', '城镇应届', NULL, NULL, NULL, NULL, '20201753');
INSERT INTO `college_entrance_examination` VALUES (0, '四川省遂宁市卓同', '城镇往届', NULL, NULL, NULL, NULL, '20201707');
INSERT INTO `college_entrance_examination` VALUES (0, '河南省实验中学', '城镇应届', NULL, NULL, NULL, NULL, '20201781');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市育才中学校', '城镇应届', NULL, NULL, NULL, NULL, '20201765');
INSERT INTO `college_entrance_examination` VALUES (0, '深圳外国语学校', '城市应届', NULL, NULL, NULL, NULL, '20204353');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市第一中学', '城镇应届', NULL, NULL, NULL, NULL, '20201737');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市璧山中学校', '农村应届', NULL, NULL, NULL, NULL, '20204176');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市潼南中学校', '农村应届', NULL, NULL, NULL, NULL, '20205911');
INSERT INTO `college_entrance_examination` VALUES (0, '丰都中学校', '农村应届', NULL, NULL, NULL, NULL, '20201686');
INSERT INTO `college_entrance_examination` VALUES (0, '崇庆中学', '城市应届', NULL, NULL, NULL, NULL, '20201787');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市綦江中学', '城镇应届', NULL, NULL, NULL, NULL, '20201739');
INSERT INTO `college_entrance_examination` VALUES (0, '重庆市渝高中学校', '农村应届', NULL, NULL, NULL, NULL, '20204145');
INSERT INTO `college_entrance_examination` VALUES (0, '巢湖市第二中学', '农村应届', NULL, NULL, NULL, NULL, '20201749');

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
INSERT INTO `contest` VALUES (0, 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String');

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
INSERT INTO `family` VALUES ('20201755', NULL, NULL, NULL, '13861175001', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20205644', NULL, NULL, NULL, '15252716118', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201640', NULL, NULL, NULL, '15987613985', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201692', NULL, NULL, NULL, '13587881903', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201656', NULL, NULL, NULL, '18323750168', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201668', NULL, NULL, NULL, '15821562466', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201762', NULL, NULL, NULL, '18997719996', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201770', NULL, NULL, NULL, '13608316968', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201682', NULL, NULL, NULL, '15723321954', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20204051', NULL, NULL, NULL, '13970927371', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20206463', NULL, NULL, NULL, '13012392927', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201644', NULL, NULL, NULL, '13434306941', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201662', NULL, NULL, NULL, '13808339516', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201793', NULL, NULL, NULL, '13696413526', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20204050', NULL, NULL, NULL, '13646225910', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201756', NULL, NULL, NULL, '13687945280', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201786', NULL, NULL, NULL, '13778492752', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201753', NULL, NULL, NULL, '13032010030', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201707', NULL, NULL, NULL, '13547229303', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201781', NULL, NULL, NULL, '13939089910', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201765', NULL, NULL, NULL, '15828717896', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20204353', NULL, NULL, NULL, '13725501605', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201737', NULL, NULL, NULL, '13896684888', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20204176', NULL, NULL, NULL, '15823506364', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20205911', NULL, NULL, NULL, '13637855436', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201686', NULL, NULL, NULL, '15826272128', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201787', NULL, NULL, NULL, '15828520334', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201739', NULL, NULL, NULL, '15023782239', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20204145', NULL, NULL, NULL, '15696101251', NULL, NULL, NULL, '是');
INSERT INTO `family` VALUES ('20201749', NULL, NULL, NULL, '13856575178', NULL, NULL, NULL, '是');

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
INSERT INTO `paper` VALUES (156546, '20212413', 'changyao', 'asdfasdf', 'adsf', 'werqa', 'asdfr', 'wefasdf', 'aerasdfasdfasdf', 'asdf', 'asdf', 'asdf');
INSERT INTO `paper` VALUES (1, '20181703', '杨焱景', 'MSPLD: Shilling Attack Detection Model Based on Meta Self-Paced Learning', '2021 International Joint Conference on Neural Networks (IJCNN)', '2021/9/20', '否', '否', '10.1109/IJCNN52387.2021.9533622\r\n', '2021', '无', NULL);
INSERT INTO `paper` VALUES (0, 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String');
INSERT INTO `paper` VALUES (0, '0', '', '12312', '121212', '12212', '1', '121e', '12312', '1212', '', '0');
INSERT INTO `paper` VALUES (0, '0', '', '2332', '333', '333', '1', '33', '33', '333', '', '0');
INSERT INTO `paper` VALUES (0, '0', '', '111', '11', '11', '1', '11', '11', '11', '', '0');
INSERT INTO `paper` VALUES (0, '0', '', '1212', '1212', '121', '1', '1222', '000', '121', '', '0');
INSERT INTO `paper` VALUES (0, '0', '', '123123', '12312321', '123123', '1', '123213', '1212212', '12312', '', '0');
INSERT INTO `paper` VALUES (0, '0', '', '11', '11', '11', '1', '11', '11', '11', '', '0');
INSERT INTO `paper` VALUES (0, '0', '', '00000', '00000', '0000000', '1', '0000', '00000', '00000', '', '0');
INSERT INTO `paper` VALUES (0, '0', '', 'qqqqqqqq', 'qqqq', 'qq', '1', 'qq', 'qq', 'qqq', '', '0');
INSERT INTO `paper` VALUES (0, '0', '', 'wwwwwwww', 'wwww', 'www', '1', 'wwww', 'wwww', 'www', '', '0');
INSERT INTO `paper` VALUES (0, '12347', '张三光', 'uu', 'uu', 'u', '1', 'u', 'u', 'u', '', '0');
INSERT INTO `paper` VALUES (0, '12347', '张三光', 'tt', 'tt', 'tt', '1', 'tt', 'tt', 'tt', 'zzz', '0');

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
INSERT INTO `project` VALUES (0, 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String', 'String');
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
  `stu_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_join_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stu_no`) USING BTREE,
  INDEX `Stu_class`(`stu_class`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (20191574, '20191574', '曹越', 1, '20软件工程04', '测试数据1', '汉族', '测试数据2', '测试数据3', '测试数据4', '测试数据5', 6, '测试数据7', '测试数据8', '测试数据9', '测试数据10', NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20191651, '20191651', '李昊哲', 1, '20软件工程04', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20191653, '20191653', '焦波桥', 1, '20软件工程05', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20191665, '20191665', '蔡林汛', 1, '20软件工程06', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20194048, '20194048', '杨廷', 1, '20软件工程03', NULL, '苗族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20194093, '20194093', '周雅萱', 0, '20软件工程03', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
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
INSERT INTO `student` VALUES (20201656, '20201656', '刘瑞奇', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
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
INSERT INTO `student` VALUES (20201686, '20201686', '张强', 1, '20软件工程01', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201687, '20201687', '廖新宇', 1, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
INSERT INTO `student` VALUES (20201688, '20201688', '李钥莹', 0, '20软件工程02', NULL, '汉族', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '软件工程', '2020年9月');
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
INSERT INTO `teacher` VALUES (2, '123456', '李潇', '123456', '431', 2);
INSERT INTO `teacher` VALUES (10000, 'tan', '周巍', '13595922234', '431', 1);

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
