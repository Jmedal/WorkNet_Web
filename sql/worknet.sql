/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : worknet

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-04 18:43:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_administrator
-- ----------------------------
DROP TABLE IF EXISTS `sys_administrator`;
CREATE TABLE `sys_administrator` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  `power` int(20) NOT NULL DEFAULT '0' COMMENT '权限',
  PRIMARY KEY (`id`,`account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_administrator
-- ----------------------------
INSERT INTO `sys_administrator` VALUES ('1', 'admin', 'admin', '3');

-- ----------------------------
-- Table structure for sys_company
-- ----------------------------
DROP TABLE IF EXISTS `sys_company`;
CREATE TABLE `sys_company` (
  `id` bigint(255) unsigned NOT NULL COMMENT '公司id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '公司帐号id',
  `name` varchar(255) DEFAULT '' COMMENT '公司名称',
  `introduction` varchar(255) DEFAULT '' COMMENT '公司简介',
  `address` varchar(255) DEFAULT '' COMMENT '公司地址',
  `register_time` datetime(6) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`,`user_id`),
  KEY `fk_sys_company_sys_user_1` (`user_id`),
  CONSTRAINT `fk_sys_company_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司信息表';

-- ----------------------------
-- Records of sys_company
-- ----------------------------
INSERT INTO `sys_company` VALUES ('1', '1', '123', '123', '123', '2019-05-07 00:28:05.000000');
INSERT INTO `sys_company` VALUES ('2', '12', '腾讯', '腾讯', '腾讯', '2019-05-25 20:52:58.000000');

-- ----------------------------
-- Table structure for sys_company_contest
-- ----------------------------
DROP TABLE IF EXISTS `sys_company_contest`;
CREATE TABLE `sys_company_contest` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '公司笔试id',
  `company_id` bigint(255) unsigned NOT NULL COMMENT '公司id',
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '笔试标题',
  `start_time` datetime(6) NOT NULL COMMENT '笔试开始时间',
  `end_time` datetime(6) NOT NULL COMMENT '笔试结束时间',
  `activity` tinyint(10) NOT NULL COMMENT '是否激活',
  PRIMARY KEY (`id`,`company_id`),
  KEY `fk_sys_company_contest_sys_company_1` (`company_id`),
  KEY `id` (`id`),
  CONSTRAINT `fk_sys_company_contest_sys_company_1` FOREIGN KEY (`company_id`) REFERENCES `sys_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='公司笔试表';

-- ----------------------------
-- Records of sys_company_contest
-- ----------------------------
INSERT INTO `sys_company_contest` VALUES ('1', '2', '腾讯校招', '2019-06-04 10:53:57.000000', '2019-06-04 20:54:02.000000', '0');

-- ----------------------------
-- Table structure for sys_company_contest_apply
-- ----------------------------
DROP TABLE IF EXISTS `sys_company_contest_apply`;
CREATE TABLE `sys_company_contest_apply` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '报名id',
  `contest_id` bigint(255) unsigned NOT NULL COMMENT '笔试id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '用户id',
  `permission` tinyint(10) NOT NULL DEFAULT '1' COMMENT '是否有效（考试时间、作弊等）',
  `sign_up_time` datetime(6) NOT NULL COMMENT '报名时间',
  PRIMARY KEY (`id`,`contest_id`,`user_id`),
  KEY `fk_sys_comany_contest_apply_sys_company_contest_1` (`contest_id`) USING BTREE,
  KEY `fk_sys_comany_contest_apply_sys_user_1` (`user_id`) USING BTREE,
  CONSTRAINT `fk_sys_comany_contest_apply_sys_company_contest_1` FOREIGN KEY (`contest_id`) REFERENCES `sys_company_contest` (`id`),
  CONSTRAINT `fk_sys_comany_contest_apply_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='公司笔试报名表';

-- ----------------------------
-- Records of sys_company_contest_apply
-- ----------------------------
INSERT INTO `sys_company_contest_apply` VALUES ('1', '1', '4', '1', '2019-05-25 20:55:42.000000');
INSERT INTO `sys_company_contest_apply` VALUES ('2', '1', '3', '1', '2019-05-27 15:36:40.000000');

-- ----------------------------
-- Table structure for sys_company_contest_choice_option
-- ----------------------------
DROP TABLE IF EXISTS `sys_company_contest_choice_option`;
CREATE TABLE `sys_company_contest_choice_option` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '笔试选项id',
  `question_id` bigint(255) unsigned NOT NULL COMMENT '问题id',
  `option` varchar(255) NOT NULL COMMENT '选项内容',
  PRIMARY KEY (`id`,`question_id`),
  KEY `fk_sys_company_contest_choice_option_company_contest_question_1` (`question_id`),
  CONSTRAINT `fk_sys_company_contest_choice_option_company_contest_question_1` FOREIGN KEY (`question_id`) REFERENCES `sys_company_contest_question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司笔试选项表';

-- ----------------------------
-- Records of sys_company_contest_choice_option
-- ----------------------------

-- ----------------------------
-- Table structure for sys_company_contest_question
-- ----------------------------
DROP TABLE IF EXISTS `sys_company_contest_question`;
CREATE TABLE `sys_company_contest_question` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `contest_id` bigint(255) unsigned NOT NULL COMMENT '所属笔试id',
  `question` varchar(255) NOT NULL COMMENT '问题内容',
  `correct_option_id` bigint(255) unsigned NOT NULL COMMENT '正确选项id',
  `order_no` int(255) NOT NULL COMMENT '问题序号',
  `question_type` tinyint(10) NOT NULL DEFAULT '0' COMMENT '问题类型',
  PRIMARY KEY (`id`,`contest_id`,`correct_option_id`),
  KEY `fk_company_contest_question_sys_company_contest_1` (`contest_id`),
  KEY `fk_sys_company_contest_question_company_contest_choice_option_1` (`correct_option_id`),
  CONSTRAINT `fk_company_contest_question_sys_company_contest_1` FOREIGN KEY (`contest_id`) REFERENCES `sys_company_contest` (`id`),
  CONSTRAINT `fk_sys_company_contest_question_company_contest_choice_option_1` FOREIGN KEY (`correct_option_id`) REFERENCES `sys_company_contest_choice_option` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司笔试问题表';

-- ----------------------------
-- Records of sys_company_contest_question
-- ----------------------------

-- ----------------------------
-- Table structure for sys_company_contest_result
-- ----------------------------
DROP TABLE IF EXISTS `sys_company_contest_result`;
CREATE TABLE `sys_company_contest_result` (
  `id` bigint(255) unsigned NOT NULL COMMENT '笔试回答id',
  `contest_id` bigint(255) unsigned NOT NULL COMMENT '回答所属笔试id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '回答用户id',
  `question_id` bigint(255) unsigned NOT NULL COMMENT '问题id',
  `start_time` datetime(6) NOT NULL COMMENT '开始回答时间',
  `end_time` datetime(6) NOT NULL COMMENT '结束回答时间',
  `answer_id` bigint(255) unsigned NOT NULL COMMENT '回答选项id',
  PRIMARY KEY (`id`,`user_id`,`contest_id`,`question_id`),
  KEY `fk_company_contest_result_sys_company_contest_1` (`contest_id`),
  KEY `fk_company_contest_result_sys_user_1` (`user_id`),
  KEY `fk_company_contest_result_company_contest_question_1` (`question_id`),
  CONSTRAINT `fk_company_contest_result_company_contest_question_1` FOREIGN KEY (`question_id`) REFERENCES `sys_company_contest_question` (`id`),
  CONSTRAINT `fk_company_contest_result_sys_company_contest_1` FOREIGN KEY (`contest_id`) REFERENCES `sys_company_contest` (`id`),
  CONSTRAINT `fk_company_contest_result_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司笔试回答表';

-- ----------------------------
-- Records of sys_company_contest_result
-- ----------------------------

-- ----------------------------
-- Table structure for sys_course
-- ----------------------------
DROP TABLE IF EXISTS `sys_course`;
CREATE TABLE `sys_course` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `teacher_id` bigint(255) unsigned NOT NULL COMMENT '发布者id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '课程名称',
  `introduction` varchar(255) NOT NULL DEFAULT '' COMMENT '课程介绍',
  `stars` float(50,0) NOT NULL DEFAULT '0' COMMENT '综合评分',
  `upload_time` datetime(6) NOT NULL COMMENT '课程开设时间',
  `picture_path` varchar(255) NOT NULL DEFAULT '\\course_picture\\default\\default.jpg' COMMENT '封面图片路径',
  `activity` tinyint(10) unsigned NOT NULL DEFAULT '1' COMMENT '是否激活',
  PRIMARY KEY (`id`,`teacher_id`),
  KEY `fk_sys_course_sys_teacher_info_1` (`teacher_id`),
  CONSTRAINT `fk_sys_course_sys_teacher_info_1` FOREIGN KEY (`teacher_id`) REFERENCES `sys_teacher_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Records of sys_course
-- ----------------------------
INSERT INTO `sys_course` VALUES ('1', '1', '独立完成企业级Java电商网站开发', 'Web', '3', '2019-05-09 00:00:00.000000', '\\course_picture\\2019\\58f57d200001461105400300-360-202.jpg', '1');
INSERT INTO `sys_course` VALUES ('2', '1', 'Java生产环境下调优详解', 'JAVA', '3', '2019-05-10 00:00:00.000000', '\\course_picture\\2019\\5b384772000132c405400300-360-202.jpg', '1');

-- ----------------------------
-- Table structure for sys_course_click
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_click`;
CREATE TABLE `sys_course_click` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程点击记录id',
  `user_id` bigint(255) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `course_id` bigint(255) unsigned NOT NULL DEFAULT '0' COMMENT '课程id',
  `click_time` datetime(6) NOT NULL COMMENT '点击时间',
  PRIMARY KEY (`id`,`user_id`,`course_id`),
  KEY `fk_sys_course_click_sys_user_1` (`user_id`),
  KEY `fk_sys_course_click_sys_course_1` (`course_id`),
  CONSTRAINT `fk_sys_course_click_sys_course_1` FOREIGN KEY (`course_id`) REFERENCES `sys_course` (`id`),
  CONSTRAINT `fk_sys_course_click_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='课程点击记录表';

-- ----------------------------
-- Records of sys_course_click
-- ----------------------------
INSERT INTO `sys_course_click` VALUES ('1', '3', '1', '2019-05-20 11:09:34.000000');
INSERT INTO `sys_course_click` VALUES ('2', '4', '1', '2019-05-20 11:09:44.000000');
INSERT INTO `sys_course_click` VALUES ('3', '6', '2', '2019-05-20 11:09:57.000000');

-- ----------------------------
-- Table structure for sys_course_comment
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_comment`;
CREATE TABLE `sys_course_comment` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '评论者id',
  `course_id` bigint(255) unsigned NOT NULL COMMENT '课程id',
  `time` datetime(6) NOT NULL COMMENT '评论时间',
  `stars` float(50,0) NOT NULL DEFAULT '5' COMMENT '课程打分',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '评价内容',
  PRIMARY KEY (`id`,`course_id`,`user_id`),
  KEY `fk_course_comment_user_1` (`user_id`),
  KEY `fk_sys_course_comment_sys_course_1` (`course_id`),
  CONSTRAINT `fk_course_comment_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `fk_sys_course_comment_sys_course_1` FOREIGN KEY (`course_id`) REFERENCES `sys_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='课程评价表';

-- ----------------------------
-- Records of sys_course_comment
-- ----------------------------
INSERT INTO `sys_course_comment` VALUES ('6', '3', '1', '2019-05-20 10:23:15.000000', '3', '还行！');
INSERT INTO `sys_course_comment` VALUES ('7', '3', '1', '2019-05-20 10:23:27.000000', '4', '二刷');
INSERT INTO `sys_course_comment` VALUES ('8', '1', '1', '2019-05-20 10:24:26.000000', '5', '太棒了');
INSERT INTO `sys_course_comment` VALUES ('10', '3', '2', '2019-05-27 22:10:28.000000', '2', 'just so so.');
INSERT INTO `sys_course_comment` VALUES ('11', '3', '1', '2019-05-27 22:11:08.000000', '4', '6666');
INSERT INTO `sys_course_comment` VALUES ('12', '3', '2', '2019-06-04 17:46:17.000000', '4', '还行');
INSERT INTO `sys_course_comment` VALUES ('13', '3', '1', '2019-06-04 18:00:34.000000', '3', '666');
INSERT INTO `sys_course_comment` VALUES ('14', '3', '2', '2019-06-04 18:15:18.000000', '5', 'six');
INSERT INTO `sys_course_comment` VALUES ('15', '3', '2', '2019-06-04 18:21:03.000000', '1', 'zzzz');
INSERT INTO `sys_course_comment` VALUES ('16', '3', '1', '2019-06-04 18:38:19.000000', '1', '测试');

-- ----------------------------
-- Table structure for sys_course_contest
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_contest`;
CREATE TABLE `sys_course_contest` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程单元测试id',
  `course_index_id` bigint(255) unsigned NOT NULL COMMENT '所属课程单元id',
  `contest_name` varchar(255) DEFAULT NULL COMMENT '测试标题',
  PRIMARY KEY (`id`,`course_index_id`),
  KEY `fk_sys_course_contest_sys_course_index_1` (`course_index_id`),
  CONSTRAINT `fk_sys_course_contest_sys_course_index_1` FOREIGN KEY (`course_index_id`) REFERENCES `sys_course_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程单元测试表';

-- ----------------------------
-- Records of sys_course_contest
-- ----------------------------

-- ----------------------------
-- Table structure for sys_course_contest_option
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_contest_option`;
CREATE TABLE `sys_course_contest_option` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '选项id',
  `question_id` bigint(255) unsigned NOT NULL COMMENT '问题id',
  `option_content` varchar(255) NOT NULL COMMENT '选项内容',
  PRIMARY KEY (`id`,`question_id`),
  KEY `fk_sys_course_contest_option_sys_course_contest_question_1` (`question_id`),
  CONSTRAINT `fk_sys_course_contest_option_sys_course_contest_question_1` FOREIGN KEY (`question_id`) REFERENCES `sys_course_contest_question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='选项表';

-- ----------------------------
-- Records of sys_course_contest_option
-- ----------------------------

-- ----------------------------
-- Table structure for sys_course_contest_question
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_contest_question`;
CREATE TABLE `sys_course_contest_question` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `contest_question_id` bigint(255) unsigned NOT NULL COMMENT '所属课程单元测试id',
  `correct_option_id` bigint(255) unsigned NOT NULL COMMENT '正确答案id',
  `question_content` varchar(255) NOT NULL COMMENT '问题内容',
  PRIMARY KEY (`id`,`contest_question_id`,`correct_option_id`),
  KEY `fk_sys_course_contest_question_sys_course_contest_1` (`contest_question_id`),
  KEY `fk_sys_course_contest_question_sys_course_contest_option_1` (`correct_option_id`),
  CONSTRAINT `fk_sys_course_contest_question_sys_course_contest_1` FOREIGN KEY (`contest_question_id`) REFERENCES `sys_course_contest` (`id`),
  CONSTRAINT `fk_sys_course_contest_question_sys_course_contest_option_1` FOREIGN KEY (`correct_option_id`) REFERENCES `sys_course_contest_option` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题表';

-- ----------------------------
-- Records of sys_course_contest_question
-- ----------------------------

-- ----------------------------
-- Table structure for sys_course_contest_result
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_contest_result`;
CREATE TABLE `sys_course_contest_result` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '单元测试结果id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '用户id',
  `course_contest_id` bigint(255) unsigned NOT NULL COMMENT '所属课程测试id',
  `start_time` datetime(6) DEFAULT NULL COMMENT '开始测试时间',
  `end_time` datetime(6) DEFAULT NULL COMMENT '结束测试时间',
  `score` int(255) unsigned DEFAULT NULL COMMENT '测试得分',
  PRIMARY KEY (`id`,`user_id`,`course_contest_id`),
  KEY `fk_sys_course_contest_result_sys_course_contest_1` (`course_contest_id`),
  KEY `fk_sys_course_contest_result_sys_user_1` (`user_id`),
  CONSTRAINT `fk_sys_course_contest_result_sys_course_contest_1` FOREIGN KEY (`course_contest_id`) REFERENCES `sys_course_contest` (`id`),
  CONSTRAINT `fk_sys_course_contest_result_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单元测试结果表';

-- ----------------------------
-- Records of sys_course_contest_result
-- ----------------------------

-- ----------------------------
-- Table structure for sys_course_contest_score
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_contest_score`;
CREATE TABLE `sys_course_contest_score` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '单元测试成绩id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '用户id',
  `course_index_id` bigint(255) unsigned NOT NULL COMMENT '所属课程单元id',
  `score` float(255,0) NOT NULL DEFAULT '0' COMMENT '测试成绩',
  `take_time` datetime(6) NOT NULL COMMENT '参考时间',
  PRIMARY KEY (`id`,`user_id`,`course_index_id`),
  KEY `fk_sys_course_contest_score_sys_course_index_1` (`course_index_id`),
  KEY `fk_sys_course_contest_score_sys_user_1` (`user_id`),
  CONSTRAINT `fk_sys_course_contest_score_sys_course_index_1` FOREIGN KEY (`course_index_id`) REFERENCES `sys_course_index` (`id`),
  CONSTRAINT `fk_sys_course_contest_score_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单元测试成绩表';

-- ----------------------------
-- Records of sys_course_contest_score
-- ----------------------------

-- ----------------------------
-- Table structure for sys_course_contest_user_answer
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_contest_user_answer`;
CREATE TABLE `sys_course_contest_user_answer` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '单元测试答题id',
  `contest_result_id` bigint(255) unsigned NOT NULL COMMENT '单元测试结果id',
  `question_id` bigint(255) unsigned NOT NULL COMMENT '问题id',
  `answer_id` bigint(255) unsigned NOT NULL COMMENT '回答选项id',
  PRIMARY KEY (`id`,`contest_result_id`),
  KEY `fk_sys_course_contest_user_answer_sys_course_contest_question_1` (`question_id`),
  KEY `fk_sys_course_contest_user_answer_sys_course_contest_option_1` (`answer_id`),
  KEY `fk_sys_course_contest_user_answer_sys_course_contest_result_1` (`contest_result_id`),
  CONSTRAINT `fk_sys_course_contest_user_answer_sys_course_contest_option_1` FOREIGN KEY (`answer_id`) REFERENCES `sys_course_contest_option` (`id`),
  CONSTRAINT `fk_sys_course_contest_user_answer_sys_course_contest_question_1` FOREIGN KEY (`question_id`) REFERENCES `sys_course_contest_question` (`id`),
  CONSTRAINT `fk_sys_course_contest_user_answer_sys_course_contest_result_1` FOREIGN KEY (`contest_result_id`) REFERENCES `sys_course_contest_result` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户单元测试答题表';

-- ----------------------------
-- Records of sys_course_contest_user_answer
-- ----------------------------

-- ----------------------------
-- Table structure for sys_course_index
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_index`;
CREATE TABLE `sys_course_index` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程目录id',
  `course_id` bigint(255) unsigned NOT NULL COMMENT '所属课程id',
  `scale` int(255) NOT NULL COMMENT '目录等级',
  `index_order` int(255) NOT NULL COMMENT '目录位置',
  `index_title` varchar(255) NOT NULL DEFAULT '' COMMENT '目录标题',
  PRIMARY KEY (`id`,`course_id`),
  KEY `fk_sys_course_index_sys_course_1` (`course_id`),
  CONSTRAINT `fk_sys_course_index_sys_course_1` FOREIGN KEY (`course_id`) REFERENCES `sys_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='课程目录表';

-- ----------------------------
-- Records of sys_course_index
-- ----------------------------
INSERT INTO `sys_course_index` VALUES ('1', '1', '1', '1', 'JAVA语言');
INSERT INTO `sys_course_index` VALUES ('2', '1', '2', '1', 'JAVA语言');
INSERT INTO `sys_course_index` VALUES ('3', '1', '2', '2', 'JAVA语言');
INSERT INTO `sys_course_index` VALUES ('4', '1', '2', '3', 'JAVA语言');
INSERT INTO `sys_course_index` VALUES ('5', '1', '1', '2', 'JAVA语言');
INSERT INTO `sys_course_index` VALUES ('6', '1', '1', '3', 'JAVA语言');
INSERT INTO `sys_course_index` VALUES ('7', '1', '2', '1', 'JAVA语言');
INSERT INTO `sys_course_index` VALUES ('8', '1', '2', '2', 'JAVA语言');
INSERT INTO `sys_course_index` VALUES ('9', '1', '1', '4', 'JAVA语言');

-- ----------------------------
-- Table structure for sys_course_recommend
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_recommend`;
CREATE TABLE `sys_course_recommend` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '推荐id',
  `profession_id` bigint(255) unsigned NOT NULL COMMENT '职业id',
  `curriculum_id` bigint(255) unsigned NOT NULL COMMENT '科目分类id',
  PRIMARY KEY (`id`,`profession_id`,`curriculum_id`),
  KEY `fk_sys_course_recommend_sys_profession_type_1` (`profession_id`),
  KEY `fk_sys_course_recommend_sys_curriculum_1` (`curriculum_id`),
  CONSTRAINT `fk_sys_course_recommend_sys_curriculum_1` FOREIGN KEY (`curriculum_id`) REFERENCES `sys_curriculum` (`id`),
  CONSTRAINT `fk_sys_course_recommend_sys_profession_type_1` FOREIGN KEY (`profession_id`) REFERENCES `sys_profession` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='职业推荐课程表';

-- ----------------------------
-- Records of sys_course_recommend
-- ----------------------------
INSERT INTO `sys_course_recommend` VALUES ('1', '5', '1');
INSERT INTO `sys_course_recommend` VALUES ('2', '5', '2');
INSERT INTO `sys_course_recommend` VALUES ('3', '5', '3');
INSERT INTO `sys_course_recommend` VALUES ('4', '5', '4');
INSERT INTO `sys_course_recommend` VALUES ('5', '5', '6');

-- ----------------------------
-- Table structure for sys_course_studied
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_studied`;
CREATE TABLE `sys_course_studied` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户学习课程记录id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '用户id',
  `course_id` bigint(255) unsigned NOT NULL COMMENT '课程id',
  `score` float(100,0) DEFAULT '0' COMMENT '课程综合成绩',
  `is_finished` tinyint(10) NOT NULL DEFAULT '0' COMMENT '是否完成学习',
  `start_time` datetime(6) NOT NULL COMMENT '开始学习时间',
  PRIMARY KEY (`id`,`user_id`,`course_id`),
  KEY `fk_sys_course_studied_sys_user_1` (`user_id`),
  KEY `fk_sys_course_studied_sys_course_1` (`course_id`),
  CONSTRAINT `fk_sys_course_studied_sys_course_1` FOREIGN KEY (`course_id`) REFERENCES `sys_course` (`id`),
  CONSTRAINT `fk_sys_course_studied_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户学习课程记录表';

-- ----------------------------
-- Records of sys_course_studied
-- ----------------------------
INSERT INTO `sys_course_studied` VALUES ('1', '8', '1', '80', '1', '2019-05-09 09:29:02.000000');
INSERT INTO `sys_course_studied` VALUES ('2', '4', '1', '50', '0', '2019-05-09 09:29:44.000000');
INSERT INTO `sys_course_studied` VALUES ('3', '4', '2', '60', '1', '2019-05-09 09:30:33.000000');
INSERT INTO `sys_course_studied` VALUES ('4', '6', '1', '30', '0', '2019-05-09 09:30:52.000000');
INSERT INTO `sys_course_studied` VALUES ('5', '7', '2', '0', '0', '2019-05-09 09:31:50.000000');
INSERT INTO `sys_course_studied` VALUES ('6', '3', '1', '0', '0', '2019-05-24 00:00:00.000000');
INSERT INTO `sys_course_studied` VALUES ('6', '3', '2', '0', '0', '2019-05-25 20:20:17.000000');

-- ----------------------------
-- Table structure for sys_course_video
-- ----------------------------
DROP TABLE IF EXISTS `sys_course_video`;
CREATE TABLE `sys_course_video` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `course_Index_id` bigint(255) unsigned NOT NULL COMMENT '所属课程id',
  `video_title` varchar(255) NOT NULL DEFAULT '' COMMENT '课程标题',
  `update_time` datetime(6) NOT NULL DEFAULT '2018-12-05 00:00:00.000000' COMMENT '发布时间',
  `video_len` bigint(255) unsigned NOT NULL DEFAULT '30' COMMENT '视频时长',
  `video_path` varchar(255) NOT NULL DEFAULT '\\course_view\\default\\001.mkv' COMMENT '视频文件路径',
  PRIMARY KEY (`id`,`course_Index_id`),
  KEY `fk_sys_course_video_sys_course_index_1` (`course_Index_id`),
  CONSTRAINT `fk_sys_course_video_sys_course_index_1` FOREIGN KEY (`course_Index_id`) REFERENCES `sys_course_index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='课程视频表';

-- ----------------------------
-- Records of sys_course_video
-- ----------------------------
INSERT INTO `sys_course_video` VALUES ('1', '2', 'JAVA语言', '2018-12-05 00:00:00.000000', '30', '\\course_view\\default\\001.mkv');
INSERT INTO `sys_course_video` VALUES ('2', '3', 'JAVA语言', '2018-12-05 00:00:00.000000', '30', '\\course_view\\default\\001.mkv');
INSERT INTO `sys_course_video` VALUES ('3', '4', '', '2018-12-05 00:00:00.000000', '30', '\\course_view\\default\\001.mkv');
INSERT INTO `sys_course_video` VALUES ('4', '7', '', '2018-12-05 00:00:00.000000', '30', '\\course_view\\default\\001.mkv');
INSERT INTO `sys_course_video` VALUES ('5', '8', '', '2018-12-05 00:00:00.000000', '30', '\\course_view\\default\\001.mkv');

-- ----------------------------
-- Table structure for sys_curriculum
-- ----------------------------
DROP TABLE IF EXISTS `sys_curriculum`;
CREATE TABLE `sys_curriculum` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '科目id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '科目名称',
  `introduction` varchar(255) NOT NULL DEFAULT '' COMMENT '科目介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='科目表';

-- ----------------------------
-- Records of sys_curriculum
-- ----------------------------
INSERT INTO `sys_curriculum` VALUES ('1', 'JAVA基础', 'JAVA基础');
INSERT INTO `sys_curriculum` VALUES ('2', 'Web基础', 'Web基础');
INSERT INTO `sys_curriculum` VALUES ('3', '数据结构', '数据结构');
INSERT INTO `sys_curriculum` VALUES ('4', '数据库基础', '数据库基础');
INSERT INTO `sys_curriculum` VALUES ('5', 'PHP基础', 'PHP基础');
INSERT INTO `sys_curriculum` VALUES ('6', 'C语言', 'C语言');

-- ----------------------------
-- Table structure for sys_curriculum_course
-- ----------------------------
DROP TABLE IF EXISTS `sys_curriculum_course`;
CREATE TABLE `sys_curriculum_course` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `course_id` bigint(255) unsigned NOT NULL COMMENT '课程id',
  `curriculum_id` bigint(255) unsigned NOT NULL COMMENT '科目id',
  PRIMARY KEY (`id`,`curriculum_id`,`course_id`),
  KEY `fk_curriculum_course_curriculum_1` (`curriculum_id`),
  KEY `fk_curriculum_course_course_1` (`course_id`),
  CONSTRAINT `fk_curriculum_course_course_1` FOREIGN KEY (`course_id`) REFERENCES `sys_course` (`id`),
  CONSTRAINT `fk_curriculum_course_curriculum_1` FOREIGN KEY (`curriculum_id`) REFERENCES `sys_curriculum` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='科目_课程关系表';

-- ----------------------------
-- Records of sys_curriculum_course
-- ----------------------------
INSERT INTO `sys_curriculum_course` VALUES ('1', '1', '1');
INSERT INTO `sys_curriculum_course` VALUES ('1', '2', '2');

-- ----------------------------
-- Table structure for sys_curriculum_tree
-- ----------------------------
DROP TABLE IF EXISTS `sys_curriculum_tree`;
CREATE TABLE `sys_curriculum_tree` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '结点id',
  `curriculum_id` bigint(255) unsigned NOT NULL COMMENT '科目id',
  `pre_curriculum_id` bigint(255) unsigned NOT NULL COMMENT '前置科目id',
  PRIMARY KEY (`id`,`curriculum_id`,`pre_curriculum_id`),
  KEY `fk_curriculum_tree_curriculum_1` (`curriculum_id`),
  KEY `fk_curriculum_tree_curriculum_2` (`pre_curriculum_id`),
  CONSTRAINT `fk_curriculum_tree_curriculum_1` FOREIGN KEY (`curriculum_id`) REFERENCES `sys_curriculum` (`id`),
  CONSTRAINT `fk_curriculum_tree_curriculum_2` FOREIGN KEY (`pre_curriculum_id`) REFERENCES `sys_curriculum` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='课程树表';

-- ----------------------------
-- Records of sys_curriculum_tree
-- ----------------------------
INSERT INTO `sys_curriculum_tree` VALUES ('3', '1', '3');
INSERT INTO `sys_curriculum_tree` VALUES ('1', '2', '1');
INSERT INTO `sys_curriculum_tree` VALUES ('2', '2', '4');
INSERT INTO `sys_curriculum_tree` VALUES ('4', '3', '6');
INSERT INTO `sys_curriculum_tree` VALUES ('5', '5', '3');

-- ----------------------------
-- Table structure for sys_learner_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_learner_info`;
CREATE TABLE `sys_learner_info` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '学习者id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '用户id',
  `nickname` varchar(255) NOT NULL COMMENT '昵称',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(10) DEFAULT '男' COMMENT '性别',
  `age` int(20) unsigned DEFAULT '0' COMMENT '年龄',
  `signature` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `vacation` varchar(30) DEFAULT '本科一年级' COMMENT '学历',
  `github` varchar(255) DEFAULT NULL COMMENT 'github帐号',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  `professional` varchar(255) DEFAULT NULL COMMENT '目标职业',
  PRIMARY KEY (`id`,`user_id`),
  KEY `fk_sys_learner_info_sys_user_1` (`user_id`),
  CONSTRAINT `fk_sys_learner_info_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='学习者信息表';

-- ----------------------------
-- Records of sys_learner_info
-- ----------------------------
INSERT INTO `sys_learner_info` VALUES ('1', '3', 'T49Jml', '姜云杰', null, '20', '996', '本科一年级', '123', '123', '123', '吃喝玩乐', null);
INSERT INTO `sys_learner_info` VALUES ('2', '4', 'IrhErX', null, null, null, null, '本科一年级', null, null, null, null, null);
INSERT INTO `sys_learner_info` VALUES ('3', '5', 'MjpYks', null, null, null, null, '本科一年级', null, null, null, null, null);
INSERT INTO `sys_learner_info` VALUES ('4', '6', 'LOaTvM', null, '男', '0', null, '本科一年级', null, null, null, null, null);
INSERT INTO `sys_learner_info` VALUES ('5', '7', 'XYMAWB', null, '男', '0', null, '本科一年级', null, null, null, null, null);
INSERT INTO `sys_learner_info` VALUES ('6', '8', 'r98AKq', null, '男', '0', null, '本科一年级', null, null, null, null, null);
INSERT INTO `sys_learner_info` VALUES ('7', '9', 'jXtWNU', 'AAD13456', '男', '13456', 'AAD13456', '本科一年级', 'AAD13456', 'AAD13456', 'AAD13456', 'AAD13456', null);
INSERT INTO `sys_learner_info` VALUES ('8', '1', 'lst', 'lst', '男', '0', 'lst', '本科一年级', null, null, null, null, null);
INSERT INTO `sys_learner_info` VALUES ('9', '10', 'FOycYJ', null, '男', '0', null, '本科一年级', null, null, null, null, null);
INSERT INTO `sys_learner_info` VALUES ('10', '11', 'vv1c18', null, '男', '0', null, '本科一年级', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `sender_id` bigint(255) unsigned NOT NULL COMMENT '发送者id',
  `receiver_id` bigint(255) unsigned NOT NULL COMMENT '接受者id',
  `send_time` datetime(6) NOT NULL COMMENT '发送时间',
  `message_content` varchar(255) NOT NULL COMMENT '消息内容',
  `readed` tinyint(10) NOT NULL DEFAULT '0',
  `type` tinyint(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`sender_id`,`receiver_id`),
  KEY `fk_sys_message_sys_user_1` (`sender_id`),
  KEY `fk_sys_message_sys_user_2` (`receiver_id`),
  CONSTRAINT `fk_sys_message_sys_user_1` FOREIGN KEY (`sender_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `fk_sys_message_sys_user_2` FOREIGN KEY (`receiver_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息记录表';

-- ----------------------------
-- Records of sys_message
-- ----------------------------

-- ----------------------------
-- Table structure for sys_profession
-- ----------------------------
DROP TABLE IF EXISTS `sys_profession`;
CREATE TABLE `sys_profession` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '职业id',
  `name` varchar(255) NOT NULL COMMENT '职业名称',
  `salary` float(255,0) NOT NULL COMMENT '职业薪资',
  `type_id` bigint(255) unsigned NOT NULL COMMENT '职业分类id',
  PRIMARY KEY (`id`),
  KEY `fk_sys_professtion_sys_profession_type_1` (`type_id`),
  CONSTRAINT `fk_sys_professtion_sys_profession_type_1` FOREIGN KEY (`type_id`) REFERENCES `sys_profession_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='职业表';

-- ----------------------------
-- Records of sys_profession
-- ----------------------------
INSERT INTO `sys_profession` VALUES ('1', 'php前端工程师', '15000', '1');
INSERT INTO `sys_profession` VALUES ('2', 'php后端工程师', '20000', '2');
INSERT INTO `sys_profession` VALUES ('3', 'MySql工程师', '25000', '3');
INSERT INTO `sys_profession` VALUES ('4', 'Oracle工程师', '25000', '3');
INSERT INTO `sys_profession` VALUES ('5', 'Java工程师', '15000', '3');

-- ----------------------------
-- Table structure for sys_profession_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_profession_type`;
CREATE TABLE `sys_profession_type` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '职业id',
  `type_name` varchar(255) NOT NULL COMMENT '职业分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='职业分类';

-- ----------------------------
-- Records of sys_profession_type
-- ----------------------------
INSERT INTO `sys_profession_type` VALUES ('1', '前端工程师');
INSERT INTO `sys_profession_type` VALUES ('2', '后端工程师');
INSERT INTO `sys_profession_type` VALUES ('3', '数据库工程师');

-- ----------------------------
-- Table structure for sys_teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_teacher_info`;
CREATE TABLE `sys_teacher_info` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '讲师id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '讲师用户账号id',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(10) DEFAULT '男' COMMENT '性别',
  `age` int(20) unsigned DEFAULT '0' COMMENT '年龄',
  `identity` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `tag` varchar(255) DEFAULT '' COMMENT '讲师头衔',
  `introduction` varchar(255) DEFAULT '' COMMENT '经历简介',
  `github` varchar(255) DEFAULT NULL COMMENT 'github帐号',
  PRIMARY KEY (`id`,`user_id`),
  KEY `fk_teacher_info_user_1` (`user_id`),
  CONSTRAINT `fk_teacher_info_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='讲师信息登记表';

-- ----------------------------
-- Records of sys_teacher_info
-- ----------------------------
INSERT INTO `sys_teacher_info` VALUES ('1', '1', '陆施涛', '99', null, '3434************', '152**********', '78********', '天才', '天才', '没有');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  `head_path` varchar(255) NOT NULL DEFAULT '\\avatar\\default\\avatar.jpg' COMMENT '头像路径',
  `role` tinyint(10) NOT NULL DEFAULT '3' COMMENT '身份标记（讲师/学生/公司）',
  `activity` tinyint(10) NOT NULL DEFAULT '1' COMMENT '帐号是否激活',
  PRIMARY KEY (`id`,`account`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', '\\avatar\\default\\avatar.jpg', '2', '1');
INSERT INTO `sys_user` VALUES ('3', '1617440712', '1617440712', '\\avatar\\2019\\18c444c3-c532-4dca-a6b8-ca7aceef48cf.png', '3', '1');
INSERT INTO `sys_user` VALUES ('4', '123', 'J123456789', '\\avatar\\default\\avatar.jpg', '3', '1');
INSERT INTO `sys_user` VALUES ('5', 'jmedal', '1617440712J', '\\avatar\\default\\avatar.jpg', '3', '1');
INSERT INTO `sys_user` VALUES ('6', '789147', '123456789A', '\\avatar\\default\\avatar.jpg', '3', '1');
INSERT INTO `sys_user` VALUES ('7', '16175', 'A1617511', '\\avatar\\default\\avatar.jpg', '3', '1');
INSERT INTO `sys_user` VALUES ('8', '156786', 'AA156786', '\\avatar\\default\\avatar.jpg', '3', '1');
INSERT INTO `sys_user` VALUES ('9', 'AAD13456', 'AAD13456', '\\avatar\\default\\avatar.jpg', '3', '1');
INSERT INTO `sys_user` VALUES ('10', 'lst', 'Lstlstlst', '\\avatar\\2019\\778c8477-4dc7-469c-b6aa-caa14abb787a.png', '3', '1');
INSERT INTO `sys_user` VALUES ('11', 'dddddd', 'Ddddddddddddd', '\\avatar\\2019\\d51ba82a-ac54-4845-8b0c-4cd78f99f099.png', '3', '1');
INSERT INTO `sys_user` VALUES ('12', 'tencent', 'tencent', '\\avatar\\2019\\timg.jpg', '1', '1');

-- ----------------------------
-- Table structure for sys_user_profession
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_profession`;
CREATE TABLE `sys_user_profession` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户选择id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '用户id',
  `profession_id` bigint(255) unsigned NOT NULL COMMENT '职业id',
  PRIMARY KEY (`id`,`user_id`,`profession_id`),
  KEY `user_id` (`user_id`),
  KEY `profession_id` (`profession_id`),
  CONSTRAINT `profession_id` FOREIGN KEY (`profession_id`) REFERENCES `sys_profession` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户选择职业表';

-- ----------------------------
-- Records of sys_user_profession
-- ----------------------------
INSERT INTO `sys_user_profession` VALUES ('1', '3', '5');
INSERT INTO `sys_user_profession` VALUES ('2', '4', '3');
INSERT INTO `sys_user_profession` VALUES ('3', '5', '4');

-- ----------------------------
-- Table structure for sys_video_discussion
-- ----------------------------
DROP TABLE IF EXISTS `sys_video_discussion`;
CREATE TABLE `sys_video_discussion` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '讨论id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '用户id',
  `video_id` bigint(255) unsigned NOT NULL COMMENT '视频id',
  `reply_to_id` bigint(255) NOT NULL COMMENT '回复对象id（0：回复视频；非0：回复评论（值为最上级评论id））',
  `reply_user_id` bigint(255) unsigned NOT NULL COMMENT '回复用户id（0：回复视频或者回复最上级评论；非0：回复评论（值为被回复的用户id））',
  `reply_time` datetime(6) NOT NULL COMMENT '回答时间',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '讨论内容',
  PRIMARY KEY (`id`,`user_id`,`video_id`,`reply_to_id`,`reply_user_id`),
  KEY `fk_video_discussion_user_1` (`user_id`),
  KEY `fk_sys_video_discussion_sys_course_video_1` (`video_id`),
  KEY `fk_sys_video_discussion_sys_user_1` (`reply_user_id`),
  KEY `id` (`id`),
  KEY `fk_video_discussion_user_2` (`reply_to_id`),
  CONSTRAINT `fk_video_discussion_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='讨论表';

-- ----------------------------
-- Records of sys_video_discussion
-- ----------------------------
INSERT INTO `sys_video_discussion` VALUES ('33', '1', '1', '0', '0', '2019-05-20 10:33:42.000000', '牛逼');
INSERT INTO `sys_video_discussion` VALUES ('34', '1', '1', '33', '1', '2019-05-20 10:33:47.000000', '牛逼');
INSERT INTO `sys_video_discussion` VALUES ('35', '3', '1', '33', '1', '2019-05-20 10:34:21.000000', '牛逼');
INSERT INTO `sys_video_discussion` VALUES ('36', '3', '1', '33', '1', '2019-05-20 10:34:28.000000', '牛逼');
INSERT INTO `sys_video_discussion` VALUES ('37', '3', '1', '0', '0', '2019-05-20 10:34:36.000000', '牛逼');

-- ----------------------------
-- Table structure for sys_video_watched
-- ----------------------------
DROP TABLE IF EXISTS `sys_video_watched`;
CREATE TABLE `sys_video_watched` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT COMMENT '播放记录id',
  `user_id` bigint(255) unsigned NOT NULL COMMENT '用户id',
  `video_id` bigint(255) unsigned NOT NULL COMMENT '视频id',
  `videl_watched_length` bigint(255) unsigned NOT NULL COMMENT '观看时长',
  PRIMARY KEY (`id`,`user_id`,`video_id`),
  KEY `fk_sys_video_watched_sys_user_1` (`user_id`),
  KEY `fk_sys_video_watched_sys_course_video_1` (`video_id`),
  CONSTRAINT `fk_sys_video_watched_sys_course_video_1` FOREIGN KEY (`video_id`) REFERENCES `sys_course_video` (`id`),
  CONSTRAINT `fk_sys_video_watched_sys_user_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='播放记录表';

-- ----------------------------
-- Records of sys_video_watched
-- ----------------------------
