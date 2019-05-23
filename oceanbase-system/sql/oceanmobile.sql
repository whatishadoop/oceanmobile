/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : oceanmobile

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-06 16:37:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_application
-- ----------------------------
DROP TABLE IF EXISTS `app_application`;
CREATE TABLE `app_application` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `code` varchar(40) DEFAULT NULL,
  `busi_name` varchar(50) DEFAULT NULL,
  `sort` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_application
-- ----------------------------

-- ----------------------------
-- Table structure for app_page
-- ----------------------------
DROP TABLE IF EXISTS `app_page`;
CREATE TABLE `app_page` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `content` longtext,
  `content_parse` longtext,
  `config` longtext,
  `is_enable` char(1) DEFAULT NULL,
  `creator` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `sort` bigint(100) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_page
-- ----------------------------

-- ----------------------------
-- Table structure for ds_file_config
-- ----------------------------
DROP TABLE IF EXISTS `ds_file_config`;
CREATE TABLE `ds_file_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `access_key` text COMMENT 'accessKey',
  `bucket` varchar(255) DEFAULT NULL COMMENT 'Bucket 识别符',
  `host` varchar(255) NOT NULL COMMENT '外链域名',
  `secret_key` text COMMENT 'secretKey',
  `type` varchar(255) DEFAULT NULL COMMENT '空间类型',
  `zone` varchar(255) DEFAULT NULL COMMENT '机房',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_file_config
-- ----------------------------

-- ----------------------------
-- Table structure for ds_file_content
-- ----------------------------
DROP TABLE IF EXISTS `ds_file_content`;
CREATE TABLE `ds_file_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bucket` varchar(255) DEFAULT NULL COMMENT 'Bucket 识别符',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `size` varchar(255) DEFAULT NULL COMMENT '文件大小',
  `type` varchar(255) DEFAULT NULL COMMENT '文件类型：私有或公开',
  `update_time` datetime DEFAULT NULL COMMENT '上传或同步的时间',
  `url` varchar(255) DEFAULT NULL COMMENT '文件url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_file_content
-- ----------------------------

-- ----------------------------
-- Table structure for ds_picture
-- ----------------------------
DROP TABLE IF EXISTS `ds_picture`;
CREATE TABLE `ds_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` datetime DEFAULT NULL COMMENT '上传日期',
  `delete_url` varchar(255) DEFAULT NULL COMMENT '删除的URL',
  `filename` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `height` varchar(255) DEFAULT NULL COMMENT '图片高度',
  `size` varchar(255) DEFAULT NULL COMMENT '图片大小',
  `url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `width` varchar(255) DEFAULT NULL COMMENT '图片宽度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_picture
-- ----------------------------
INSERT INTO `ds_picture` VALUES ('1', '2019-04-23 18:58:42', 'https://sm.ms/delete/39quSxpsmUvI8MG', 'Koala.jpg', '768', '762.53KB   ', 'https://i.loli.net/2019/04/23/5cbeefdfc9148.jpg', 'admin', '1024');
INSERT INTO `ds_picture` VALUES ('2', '2019-04-23 18:58:44', 'https://sm.ms/delete/Yap2j5fzcxNPXOR', 'Chrysanthemum.jpg', '768', '858.78KB   ', 'https://i.loli.net/2019/04/23/5cbeefe19e18e.jpg', 'admin', '1024');
INSERT INTO `ds_picture` VALUES ('3', '2019-04-23 19:02:28', 'https://sm.ms/delete/qHkJPIWGCYXadQR', 'Jellyfish.jpg', '768', '757.52KB   ', 'https://i.loli.net/2019/04/23/5cbef0c15df37.jpg', 'admin', '1024');
INSERT INTO `ds_picture` VALUES ('4', '2019-04-23 19:03:23', 'https://sm.ms/delete/65sbj1kqzyIBpt3', 'Penguins.jpg', '768', '759.60KB   ', 'https://i.loli.net/2019/04/23/5cbef0f87975f.jpg', 'admin', '1024');
INSERT INTO `ds_picture` VALUES ('5', '2019-04-23 19:54:41', 'https://sm.ms/delete/d6s8Kqixh2eayXg', 'Tulips.jpg', '768', '606.34KB   ', 'https://i.loli.net/2019/04/23/5cbefcfebdfd7.jpg', 'admin', '1024');
INSERT INTO `ds_picture` VALUES ('6', '2019-04-23 19:55:47', 'https://sm.ms/delete/H6FKc17TtkDuZjs', 'Tulips.jpg', '768', '606.34KB   ', 'https://i.loli.net/2019/04/23/5cbefd40c8bd9.jpg', 'admin', '1024');
INSERT INTO `ds_picture` VALUES ('7', '2019-04-23 19:57:00', 'https://sm.ms/delete/plrXwUMSZtWP4vj', 'Penguins.jpg', '768', '759.60KB   ', 'https://i.loli.net/2019/04/23/5cbefd89bc660.jpg', 'admin', '1024');
INSERT INTO `ds_picture` VALUES ('8', '2019-04-23 19:57:49', 'https://sm.ms/delete/rxZyshOMoVAKE8X', 'Penguins.jpg', '768', '759.60KB   ', 'https://i.loli.net/2019/04/23/5cbefd960e7ff.jpg', 'admin', '1024');
INSERT INTO `ds_picture` VALUES ('9', '2019-04-29 10:35:38', 'https://sm.ms/delete/6e3vnCfBRVKNY7q', 'Jellyfish.jpg', '768', '757.52KB   ', 'https://i.loli.net/2019/04/29/5cc662f948d03.jpg', 'admin', '1024');

-- ----------------------------
-- Table structure for mon_log
-- ----------------------------
DROP TABLE IF EXISTS `mon_log`;
CREATE TABLE `mon_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `exception_detail` text,
  `log_type` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `params` text,
  `request_ip` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6434 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mon_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `pid` bigint(20) NOT NULL COMMENT '上级部门',
  `create_time` datetime DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '大数据产品部', '0', '2019-03-25 09:14:05', '');
INSERT INTO `sys_dept` VALUES ('2', '规划部', '7', '2019-03-25 09:15:32', '');
INSERT INTO `sys_dept` VALUES ('5', '运营部', '7', '2019-03-25 09:20:44', '');
INSERT INTO `sys_dept` VALUES ('6', '前端部', '8', '2019-03-25 09:52:18', '');
INSERT INTO `sys_dept` VALUES ('7', '规划系统部', '1', '2019-03-25 11:04:50', '');
INSERT INTO `sys_dept` VALUES ('8', '研发系统部', '1', '2019-03-25 11:04:53', '');
INSERT INTO `sys_dept` VALUES ('9', '业务部', '7', '2019-03-25 11:05:34', '');
INSERT INTO `sys_dept` VALUES ('10', '后端部', '8', '2019-03-25 11:05:58', '');
INSERT INTO `sys_dept` VALUES ('11', '大数据部', '8', '2019-03-25 11:07:58', '');
INSERT INTO `sys_dept` VALUES ('12', '测试部', '7', '2019-03-25 11:10:24', '\0');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '字典名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', 'user_status', '用户状态');
INSERT INTO `sys_dict` VALUES ('4', 'dept_status', '部门状态');
INSERT INTO `sys_dict` VALUES ('5', 'job_status', '岗位状态');

-- ----------------------------
-- Table structure for sys_dict_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_detail`;
CREATE TABLE `sys_dict_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL COMMENT '字典标签',
  `value` varchar(255) NOT NULL COMMENT '字典值',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  `dict_id` bigint(11) DEFAULT NULL COMMENT '字典id',
  PRIMARY KEY (`id`),
  KEY `FK5tpkputc6d9nboxojdbgnpmyb` (`dict_id`),
  CONSTRAINT `FK5tpkputc6d9nboxojdbgnpmyb` FOREIGN KEY (`dict_id`) REFERENCES `sys_dict` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_detail
-- ----------------------------
INSERT INTO `sys_dict_detail` VALUES ('1', '激活', 'true', '1', '1');
INSERT INTO `sys_dict_detail` VALUES ('2', '锁定', 'false', '2', '1');
INSERT INTO `sys_dict_detail` VALUES ('11', '正常', 'true', '1', '4');
INSERT INTO `sys_dict_detail` VALUES ('12', '停用', 'false', '2', '4');
INSERT INTO `sys_dict_detail` VALUES ('13', '正常', 'true', '1', '5');
INSERT INTO `sys_dict_detail` VALUES ('14', '停用', 'false', '2', '5');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `sort` bigint(20) NOT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmvhj0rogastlctflsxf1d6k3i` (`dept_id`),
  CONSTRAINT `FKmvhj0rogastlctflsxf1d6k3i` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('2', '部门研发经理', '', '2019-03-29 14:01:30', '2', '8');
INSERT INTO `sys_job` VALUES ('8', '大数据开发', '', '2019-03-29 14:52:28', '3', '11');
INSERT INTO `sys_job` VALUES ('10', '产品经理', '\0', '2019-03-29 14:55:51', '4', '2');
INSERT INTO `sys_job` VALUES ('11', '前端开发', '', '2019-03-31 13:39:30', '6', '6');
INSERT INTO `sys_job` VALUES ('12', '软件测试', '', '2019-03-31 13:39:43', '5', '2');
INSERT INTO `sys_job` VALUES ('19', '部门经理', '', '2019-03-31 14:58:15', '1', '1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `i_frame` bit(1) DEFAULT NULL COMMENT '是否外链',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) DEFAULT NULL COMMENT '组件',
  `pid` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `sort` bigint(20) NOT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `path` varchar(255) DEFAULT NULL COMMENT '链接地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '2018-12-18 15:11:29', '\0', '系统管理', null, '0', '1', 'system', 'system');
INSERT INTO `sys_menu` VALUES ('2', '2018-12-18 15:14:44', '\0', '用户管理', 'system/user/index', '1', '2', 'peoples', 'user');
INSERT INTO `sys_menu` VALUES ('3', '2018-12-18 15:16:07', '\0', '角色管理', 'system/role/index', '1', '3', 'role', 'role');
INSERT INTO `sys_menu` VALUES ('4', '2018-12-18 15:16:45', '\0', '权限管理', 'system/permission/index', '1', '4', 'permission', 'permission');
INSERT INTO `sys_menu` VALUES ('5', '2018-12-18 15:17:28', '\0', '菜单管理', 'system/menu/index', '1', '5', 'menu', 'menu');
INSERT INTO `sys_menu` VALUES ('6', '2018-12-18 15:17:48', '\0', '系统监控', '', '0', '10', 'monitor', 'monitor');
INSERT INTO `sys_menu` VALUES ('7', '2018-12-18 15:18:26', '\0', '操作日志', 'monitor/log/operationLog', '76', '11', 'log', 'logs');
INSERT INTO `sys_menu` VALUES ('8', '2018-12-18 15:19:01', '\0', '系统缓存', 'monitor/redis/index', '6', '13', 'redis', 'redis');
INSERT INTO `sys_menu` VALUES ('9', '2018-12-18 15:19:34', '\0', 'SQL监控', 'monitor/sql/index', '51', '14', 'sqlMonitor', 'druid');
INSERT INTO `sys_menu` VALUES ('12', '2018-12-24 20:37:35', '\0', '实时控制台', 'monitor/log/msg', '6', '16', 'codeConsole', 'msg');
INSERT INTO `sys_menu` VALUES ('14', '2018-12-27 10:13:09', '\0', '邮件工具', 'tools/email/index', '36', '24', 'email', 'email');
INSERT INTO `sys_menu` VALUES ('17', '2018-12-28 15:09:49', '\0', '设计小程序', 'appmanage/AppDesigner', '42', '0', 'zujian', 'appdesigner');
INSERT INTO `sys_menu` VALUES ('28', '2019-01-07 20:34:40', '\0', '定时任务', 'system/timing/index', '1', '21', 'timing', 'timing');
INSERT INTO `sys_menu` VALUES ('30', '2019-01-11 15:45:55', '\0', '代码生成', 'generator/index', '36', '22', 'dev', 'generator');
INSERT INTO `sys_menu` VALUES ('32', '2019-01-13 13:49:03', '\0', '异常日志', 'monitor/log/errorLog', '76', '12', 'error', 'errorLog');
INSERT INTO `sys_menu` VALUES ('35', '2019-03-25 09:46:00', '\0', '部门管理', 'system/dept/index', '1', '6', 'dept', 'dept');
INSERT INTO `sys_menu` VALUES ('36', '2019-03-29 10:57:35', '\0', '系统工具', '', '0', '20', 'sys-tools', 'sys-tools');
INSERT INTO `sys_menu` VALUES ('37', '2019-03-29 13:51:18', '\0', '岗位管理', 'system/job/index', '1', '7', 'Steve-Jobs', 'job');
INSERT INTO `sys_menu` VALUES ('38', '2019-03-29 19:57:53', '\0', '接口文档', 'tools/swagger/index', '36', '23', 'swagger', 'swagger2');
INSERT INTO `sys_menu` VALUES ('39', '2019-04-10 11:49:04', '\0', '字典管理', 'system/dict/index', '1', '8', 'dictionary', 'dict');
INSERT INTO `sys_menu` VALUES ('42', '2019-04-25 13:58:03', '\0', '应用管理', '', '0', '0', 'fwb', 'appmanage');
INSERT INTO `sys_menu` VALUES ('43', '2019-04-25 14:13:23', '\0', '组装小程序', '', '42', '999', 'add', 'assemble');
INSERT INTO `sys_menu` VALUES ('44', '2019-04-25 14:14:43', '\0', '管理小程序', '', '42', '999', 'chain', 'app');
INSERT INTO `sys_menu` VALUES ('45', '2019-04-25 14:15:29', '\0', '模板管理', '', '42', '999', 'anq', 'apptemplate');
INSERT INTO `sys_menu` VALUES ('46', '2019-04-25 16:07:31', '\0', '决策管理', '', '0', '999', 'fwb', 'rulesmanage');
INSERT INTO `sys_menu` VALUES ('47', '2019-04-25 16:12:10', '\0', '决策表设计', '', '46', '999', 'tools', 'ruletable');
INSERT INTO `sys_menu` VALUES ('48', '2019-04-25 16:13:40', '\0', '业务决策配置', '', '46', '999', 'timing', 'ruleconfig');
INSERT INTO `sys_menu` VALUES ('49', '2019-04-25 16:14:31', '\0', '决策日志', '', '46', '999', 'index', 'rulelog');
INSERT INTO `sys_menu` VALUES ('50', '2019-04-25 16:15:15', '\0', '决策测试', '', '46', '999', 'user', 'ruletest');
INSERT INTO `sys_menu` VALUES ('51', '2019-04-25 16:43:55', '\0', '性能监控', 'monitor/index', '6', '999', 'system', 'monitor');
INSERT INTO `sys_menu` VALUES ('52', '2019-04-25 16:45:36', '\0', 'Redis监控', '', '51', '999', 'monitor', 'redis');
INSERT INTO `sys_menu` VALUES ('53', '2019-04-25 16:46:17', '\0', 'Tomcat监控', '', '51', '999', 'monitor', 'tomcat');
INSERT INTO `sys_menu` VALUES ('54', '2019-04-25 16:47:13', '\0', 'Server监控', '', '51', '999', 'monitor', 'server');
INSERT INTO `sys_menu` VALUES ('55', '2019-04-25 16:47:49', '\0', 'Jvm监控', '', '51', '999', 'monitor', 'jvm');
INSERT INTO `sys_menu` VALUES ('56', '2019-04-25 16:56:18', '\0', '容器控制台', '', '6', '17', 'monitor', 'dockerconsole');
INSERT INTO `sys_menu` VALUES ('57', '2019-04-25 18:08:45', '\0', '系统公告', 'system/announcement/Editor', '1', '999', 'gonggao', 'announcement');
INSERT INTO `sys_menu` VALUES ('58', '2019-04-25 18:11:06', '\0', '系统配置', 'system/configinfo/YamlEdit', '1', '999', 'system', 'configinfo');
INSERT INTO `sys_menu` VALUES ('59', '2019-04-25 18:19:30', '\0', '控件使用', 'tools/control/MarkDown', '36', '999', 'zujian', 'control');
INSERT INTO `sys_menu` VALUES ('60', '2019-04-25 18:29:49', '\0', '数据存储', '', '0', '999', 'date', 'datastorage');
INSERT INTO `sys_menu` VALUES ('61', '2019-04-25 18:31:04', '\0', '图标库', 'datastorage/icon/IconSelect', '60', '999', 'date', 'icon');
INSERT INTO `sys_menu` VALUES ('62', '2019-04-25 18:32:02', '\0', '图片管理', 'datastorage/picture', '60', '999', 'date', 'picture');
INSERT INTO `sys_menu` VALUES ('63', '2019-04-25 18:33:34', '\0', '文件管理', 'datastorage/file', '60', '999', 'date', 'file');
INSERT INTO `sys_menu` VALUES ('64', '2019-04-25 18:40:37', '\0', '流程管理', '', '0', '996', 'dept', 'processmanage');
INSERT INTO `sys_menu` VALUES ('65', '2019-04-25 18:41:38', '\0', '流程设计', '', '64', '999', 'develop', 'designer');
INSERT INTO `sys_menu` VALUES ('66', '2019-04-25 18:42:38', '\0', '流程监听', '', '64', '999', 'ipvisits', 'listener');
INSERT INTO `sys_menu` VALUES ('67', '2019-04-25 18:43:49', '\0', '流程表达式', '', '64', '999', 'icon', 'expression');
INSERT INTO `sys_menu` VALUES ('68', '2019-04-25 18:45:11', '\0', '流程实例', '', '64', '999', 'index', 'instance');
INSERT INTO `sys_menu` VALUES ('69', '2019-04-25 18:45:46', '\0', '历史任务', '', '64', '999', 'java', 'historytask');
INSERT INTO `sys_menu` VALUES ('70', '2019-04-25 18:46:22', '\0', '历史流程', '', '64', '999', 'timing', 'historytask');
INSERT INTO `sys_menu` VALUES ('71', '2019-04-25 18:50:47', '\0', '消息中心', '', '0', '999', 'gonggao', 'messagecenter');
INSERT INTO `sys_menu` VALUES ('72', '2019-04-25 18:51:55', '\0', '消息管理', '', '71', '999', 'visits', 'manage');
INSERT INTO `sys_menu` VALUES ('73', '2019-04-25 18:52:23', '\0', '消息模板', '', '71', '999', 'zujian', 'template');
INSERT INTO `sys_menu` VALUES ('74', '2019-04-25 19:03:11', '\0', '数据立方', '', '60', '999', 'qiniu', 'kylincube');
INSERT INTO `sys_menu` VALUES ('75', '2019-04-25 19:05:05', '\0', '全文检索', '', '60', '999', 'index', 'essesrch');
INSERT INTO `sys_menu` VALUES ('76', '2019-04-29 11:24:15', '\0', '日志管理', 'monitor/log/index', '6', '999', 'sqlMonitor', 'logmanage');
INSERT INTO `sys_menu` VALUES ('77', '2019-04-29 11:39:02', '\0', '请求跟踪', '', '51', '999', 'sqlMonitor', 'requesttrace');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `alias` varchar(255) DEFAULT NULL COMMENT '别名',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pid` int(11) NOT NULL COMMENT '上级权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '超级管理员', '2018-12-03 12:27:48', 'ADMIN', '0');
INSERT INTO `sys_permission` VALUES ('2', '用户管理', '2018-12-03 12:28:19', 'USER_ALL', '0');
INSERT INTO `sys_permission` VALUES ('3', '用户查询', '2018-12-03 12:31:35', 'USER_SELECT', '2');
INSERT INTO `sys_permission` VALUES ('4', '用户创建', '2018-12-03 12:31:35', 'USER_CREATE', '2');
INSERT INTO `sys_permission` VALUES ('5', '用户编辑', '2018-12-03 12:31:35', 'USER_EDIT', '2');
INSERT INTO `sys_permission` VALUES ('6', '用户删除', '2018-12-03 12:31:35', 'USER_DELETE', '2');
INSERT INTO `sys_permission` VALUES ('7', '角色管理', '2018-12-03 12:28:19', 'ROLES_ALL', '0');
INSERT INTO `sys_permission` VALUES ('8', '角色查询', '2018-12-03 12:31:35', 'ROLES_SELECT', '7');
INSERT INTO `sys_permission` VALUES ('10', '角色创建', '2018-12-09 20:10:16', 'ROLES_CREATE', '7');
INSERT INTO `sys_permission` VALUES ('11', '角色编辑', '2018-12-09 20:10:42', 'ROLES_EDIT', '7');
INSERT INTO `sys_permission` VALUES ('12', '角色删除', '2018-12-09 20:11:07', 'ROLES_DELETE', '7');
INSERT INTO `sys_permission` VALUES ('13', '权限管理', '2018-12-09 20:11:37', 'PERMISSION_ALL', '0');
INSERT INTO `sys_permission` VALUES ('14', '权限查询', '2018-12-09 20:11:55', 'PERMISSION_SELECT', '13');
INSERT INTO `sys_permission` VALUES ('15', '权限创建', '2018-12-09 20:14:10', 'PERMISSION_CREATE', '13');
INSERT INTO `sys_permission` VALUES ('16', '权限编辑', '2018-12-09 20:15:44', 'PERMISSION_EDIT', '13');
INSERT INTO `sys_permission` VALUES ('17', '权限删除', '2018-12-09 20:15:59', 'PERMISSION_DELETE', '13');
INSERT INTO `sys_permission` VALUES ('18', '缓存管理', '2018-12-17 13:53:25', 'REDIS_ALL', '0');
INSERT INTO `sys_permission` VALUES ('19', '新增缓存', '2018-12-17 13:53:44', 'REDIS_CREATE', '18');
INSERT INTO `sys_permission` VALUES ('20', '缓存查询', '2018-12-17 13:54:07', 'REDIS_SELECT', '18');
INSERT INTO `sys_permission` VALUES ('21', '缓存编辑', '2018-12-17 13:54:26', 'REDIS_EDIT', '18');
INSERT INTO `sys_permission` VALUES ('22', '缓存删除', '2018-12-17 13:55:04', 'REDIS_DELETE', '18');
INSERT INTO `sys_permission` VALUES ('23', '图床管理', '2018-12-27 20:31:49', 'PICTURE_ALL', '0');
INSERT INTO `sys_permission` VALUES ('24', '查询图片', '2018-12-27 20:32:04', 'PICTURE_SELECT', '23');
INSERT INTO `sys_permission` VALUES ('25', '上传图片', '2018-12-27 20:32:24', 'PICTURE_UPLOAD', '23');
INSERT INTO `sys_permission` VALUES ('26', '删除图片', '2018-12-27 20:32:45', 'PICTURE_DELETE', '23');
INSERT INTO `sys_permission` VALUES ('29', '菜单管理', '2018-12-28 17:34:31', 'MENU_ALL', '0');
INSERT INTO `sys_permission` VALUES ('30', '菜单查询', '2018-12-28 17:34:41', 'MENU_SELECT', '29');
INSERT INTO `sys_permission` VALUES ('31', '菜单创建', '2018-12-28 17:34:52', 'MENU_CREATE', '29');
INSERT INTO `sys_permission` VALUES ('32', '菜单编辑', '2018-12-28 17:35:20', 'MENU_EDIT', '29');
INSERT INTO `sys_permission` VALUES ('33', '菜单删除', '2018-12-28 17:35:29', 'MENU_DELETE', '29');
INSERT INTO `sys_permission` VALUES ('35', '定时任务管理', '2019-01-08 14:59:57', 'JOB_ALL', '0');
INSERT INTO `sys_permission` VALUES ('36', '任务查询', '2019-01-08 15:00:09', 'JOB_SELECT', '35');
INSERT INTO `sys_permission` VALUES ('37', '任务创建', '2019-01-08 15:00:20', 'JOB_CREATE', '35');
INSERT INTO `sys_permission` VALUES ('38', '任务编辑', '2019-01-08 15:00:33', 'JOB_EDIT', '35');
INSERT INTO `sys_permission` VALUES ('39', '任务删除', '2019-01-08 15:01:13', 'JOB_DELETE', '35');
INSERT INTO `sys_permission` VALUES ('40', '部门管理', '2019-03-29 17:06:55', 'DEPT_ALL', '0');
INSERT INTO `sys_permission` VALUES ('41', '部门查询', '2019-03-29 17:07:09', 'DEPT_SELECT', '40');
INSERT INTO `sys_permission` VALUES ('42', '部门创建', '2019-03-29 17:07:29', 'DEPT_CREATE', '40');
INSERT INTO `sys_permission` VALUES ('43', '部门编辑', '2019-03-29 17:07:52', 'DEPT_EDIT', '40');
INSERT INTO `sys_permission` VALUES ('44', '部门删除', '2019-03-29 17:08:14', 'DEPT_DELETE', '40');
INSERT INTO `sys_permission` VALUES ('45', '岗位管理', '2019-03-29 17:08:52', 'USERJOB_ALL', '0');
INSERT INTO `sys_permission` VALUES ('46', '岗位查询', '2019-03-29 17:10:27', 'USERJOB_SELECT', '45');
INSERT INTO `sys_permission` VALUES ('47', '岗位创建', '2019-03-29 17:10:55', 'USERJOB_CREATE', '45');
INSERT INTO `sys_permission` VALUES ('48', '岗位编辑', '2019-03-29 17:11:08', 'USERJOB_EDIT', '45');
INSERT INTO `sys_permission` VALUES ('49', '岗位删除', '2019-03-29 17:11:19', 'USERJOB_DELETE', '45');
INSERT INTO `sys_permission` VALUES ('50', '字典管理', '2019-04-10 16:24:51', 'DICT_ALL', '0');
INSERT INTO `sys_permission` VALUES ('51', '字典查询', '2019-04-10 16:25:16', 'DICT_SELECT', '50');
INSERT INTO `sys_permission` VALUES ('52', '字典创建', '2019-04-10 16:25:29', 'DICT_CREATE', '50');
INSERT INTO `sys_permission` VALUES ('53', '字典编辑', '2019-04-10 16:27:19', 'DICT_EDIT', '50');
INSERT INTO `sys_permission` VALUES ('54', '字典删除', '2019-04-10 16:27:30', 'DICT_DELETE', '50');

-- ----------------------------
-- Table structure for sys_quartz_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_quartz_job`;
CREATE TABLE `sys_quartz_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bean_name` varchar(255) DEFAULT NULL COMMENT 'Spring Bean名称',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron 表达式',
  `is_pause` bit(1) DEFAULT NULL COMMENT '状态：1暂停、0启用',
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `method_name` varchar(255) DEFAULT NULL COMMENT '方法名称',
  `params` varchar(255) DEFAULT NULL COMMENT '参数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `update_time` datetime DEFAULT NULL COMMENT '创建或更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_quartz_job
-- ----------------------------
INSERT INTO `sys_quartz_job` VALUES ('1', 'visitsTask', '0 0 0 * * ?', '\0', '更新访客记录', 'run', null, '每日0点创建新的访客记录', '2019-01-08 14:53:31');
INSERT INTO `sys_quartz_job` VALUES ('2', 'testTask', '0/5 * * * * ?', '', '测试1', 'run1', 'test', '带参测试，多参使用json', '2019-01-13 14:20:50');
INSERT INTO `sys_quartz_job` VALUES ('3', 'testTask', '0/5 * * * * ?', '', '测试', 'run', '', '不带参测试', '2019-04-09 16:16:44');

-- ----------------------------
-- Table structure for sys_quartz_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_quartz_log`;
CREATE TABLE `sys_quartz_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `baen_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `cron_expression` varchar(255) DEFAULT NULL,
  `exception_detail` text,
  `is_success` bit(1) DEFAULT NULL,
  `job_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_quartz_log
-- ----------------------------
INSERT INTO `sys_quartz_log` VALUES ('1', 'visitsTask', '2019-04-24 02:15:29', '0 0 0 * * ?', null, '', '更新访客记录', 'run', null, '3033');
INSERT INTO `sys_quartz_log` VALUES ('2', 'visitsTask', '2019-04-25 09:31:49', '0 0 0 * * ?', null, '', '更新访客记录', 'run', null, '3333');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `data_scope` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '2018-11-23 11:04:37', '管理员', '系统所有权', '全部');
INSERT INTO `sys_role` VALUES ('2', '2018-11-23 13:09:06', '普通用户', '用于测试菜单与权限', '自定义');

-- ----------------------------
-- Table structure for sys_roles_depts
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_depts`;
CREATE TABLE `sys_roles_depts` (
  `role_id` bigint(20) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`dept_id`),
  KEY `FK7qg6itn5ajdoa9h9o78v9ksur` (`dept_id`),
  CONSTRAINT `FK7qg6itn5ajdoa9h9o78v9ksur` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`),
  CONSTRAINT `FKrg1ci4cxxfbja0sb0pddju7k` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_depts
-- ----------------------------
INSERT INTO `sys_roles_depts` VALUES ('2', '7');

-- ----------------------------
-- Table structure for sys_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_menus`;
CREATE TABLE `sys_roles_menus` (
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`menu_id`,`role_id`) USING BTREE,
  KEY `FKcngg2qadojhi3a651a5adkvbq` (`role_id`) USING BTREE,
  CONSTRAINT `FKcngg2qadojhi3a651a5adkvbq` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKq1knxf8ykt26we8k331naabjx` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_menus
-- ----------------------------
INSERT INTO `sys_roles_menus` VALUES ('1', '1');
INSERT INTO `sys_roles_menus` VALUES ('2', '1');
INSERT INTO `sys_roles_menus` VALUES ('3', '1');
INSERT INTO `sys_roles_menus` VALUES ('4', '1');
INSERT INTO `sys_roles_menus` VALUES ('5', '1');
INSERT INTO `sys_roles_menus` VALUES ('6', '1');
INSERT INTO `sys_roles_menus` VALUES ('7', '1');
INSERT INTO `sys_roles_menus` VALUES ('8', '1');
INSERT INTO `sys_roles_menus` VALUES ('9', '1');
INSERT INTO `sys_roles_menus` VALUES ('12', '1');
INSERT INTO `sys_roles_menus` VALUES ('14', '1');
INSERT INTO `sys_roles_menus` VALUES ('17', '1');
INSERT INTO `sys_roles_menus` VALUES ('28', '1');
INSERT INTO `sys_roles_menus` VALUES ('30', '1');
INSERT INTO `sys_roles_menus` VALUES ('32', '1');
INSERT INTO `sys_roles_menus` VALUES ('35', '1');
INSERT INTO `sys_roles_menus` VALUES ('36', '1');
INSERT INTO `sys_roles_menus` VALUES ('37', '1');
INSERT INTO `sys_roles_menus` VALUES ('38', '1');
INSERT INTO `sys_roles_menus` VALUES ('39', '1');
INSERT INTO `sys_roles_menus` VALUES ('42', '1');
INSERT INTO `sys_roles_menus` VALUES ('43', '1');
INSERT INTO `sys_roles_menus` VALUES ('44', '1');
INSERT INTO `sys_roles_menus` VALUES ('45', '1');
INSERT INTO `sys_roles_menus` VALUES ('46', '1');
INSERT INTO `sys_roles_menus` VALUES ('47', '1');
INSERT INTO `sys_roles_menus` VALUES ('48', '1');
INSERT INTO `sys_roles_menus` VALUES ('49', '1');
INSERT INTO `sys_roles_menus` VALUES ('50', '1');
INSERT INTO `sys_roles_menus` VALUES ('51', '1');
INSERT INTO `sys_roles_menus` VALUES ('52', '1');
INSERT INTO `sys_roles_menus` VALUES ('53', '1');
INSERT INTO `sys_roles_menus` VALUES ('54', '1');
INSERT INTO `sys_roles_menus` VALUES ('55', '1');
INSERT INTO `sys_roles_menus` VALUES ('56', '1');
INSERT INTO `sys_roles_menus` VALUES ('57', '1');
INSERT INTO `sys_roles_menus` VALUES ('58', '1');
INSERT INTO `sys_roles_menus` VALUES ('59', '1');
INSERT INTO `sys_roles_menus` VALUES ('60', '1');
INSERT INTO `sys_roles_menus` VALUES ('61', '1');
INSERT INTO `sys_roles_menus` VALUES ('62', '1');
INSERT INTO `sys_roles_menus` VALUES ('63', '1');
INSERT INTO `sys_roles_menus` VALUES ('64', '1');
INSERT INTO `sys_roles_menus` VALUES ('65', '1');
INSERT INTO `sys_roles_menus` VALUES ('66', '1');
INSERT INTO `sys_roles_menus` VALUES ('67', '1');
INSERT INTO `sys_roles_menus` VALUES ('68', '1');
INSERT INTO `sys_roles_menus` VALUES ('69', '1');
INSERT INTO `sys_roles_menus` VALUES ('70', '1');
INSERT INTO `sys_roles_menus` VALUES ('71', '1');
INSERT INTO `sys_roles_menus` VALUES ('72', '1');
INSERT INTO `sys_roles_menus` VALUES ('73', '1');
INSERT INTO `sys_roles_menus` VALUES ('74', '1');
INSERT INTO `sys_roles_menus` VALUES ('75', '1');
INSERT INTO `sys_roles_menus` VALUES ('76', '1');
INSERT INTO `sys_roles_menus` VALUES ('77', '1');
INSERT INTO `sys_roles_menus` VALUES ('1', '2');
INSERT INTO `sys_roles_menus` VALUES ('2', '2');
INSERT INTO `sys_roles_menus` VALUES ('3', '2');
INSERT INTO `sys_roles_menus` VALUES ('4', '2');
INSERT INTO `sys_roles_menus` VALUES ('5', '2');
INSERT INTO `sys_roles_menus` VALUES ('6', '2');
INSERT INTO `sys_roles_menus` VALUES ('12', '2');
INSERT INTO `sys_roles_menus` VALUES ('17', '2');
INSERT INTO `sys_roles_menus` VALUES ('35', '2');
INSERT INTO `sys_roles_menus` VALUES ('36', '2');
INSERT INTO `sys_roles_menus` VALUES ('37', '2');
INSERT INTO `sys_roles_menus` VALUES ('38', '2');
INSERT INTO `sys_roles_menus` VALUES ('42', '2');
INSERT INTO `sys_roles_menus` VALUES ('43', '2');
INSERT INTO `sys_roles_menus` VALUES ('44', '2');
INSERT INTO `sys_roles_menus` VALUES ('45', '2');

-- ----------------------------
-- Table structure for sys_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_permissions`;
CREATE TABLE `sys_roles_permissions` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`,`permission_id`) USING BTREE,
  KEY `FKboeuhl31go7wer3bpy6so7exi` (`permission_id`) USING BTREE,
  CONSTRAINT `FK4hrolwj4ned5i7qe8kyiaak6m` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKboeuhl31go7wer3bpy6so7exi` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_permissions
-- ----------------------------
INSERT INTO `sys_roles_permissions` VALUES ('1', '1');
INSERT INTO `sys_roles_permissions` VALUES ('2', '3');
INSERT INTO `sys_roles_permissions` VALUES ('2', '4');
INSERT INTO `sys_roles_permissions` VALUES ('2', '8');
INSERT INTO `sys_roles_permissions` VALUES ('2', '14');
INSERT INTO `sys_roles_permissions` VALUES ('2', '23');
INSERT INTO `sys_roles_permissions` VALUES ('2', '24');
INSERT INTO `sys_roles_permissions` VALUES ('2', '25');
INSERT INTO `sys_roles_permissions` VALUES ('2', '26');
INSERT INTO `sys_roles_permissions` VALUES ('2', '30');
INSERT INTO `sys_roles_permissions` VALUES ('2', '41');
INSERT INTO `sys_roles_permissions` VALUES ('2', '46');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `enabled` bigint(20) DEFAULT NULL COMMENT '状态：1启用、0禁用',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `last_password_reset_time` datetime DEFAULT NULL COMMENT '最后修改密码的日期',
  `dept_id` bigint(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_kpubos9gc2cvtkb0thktkbkes` (`email`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE,
  KEY `FK5rwmryny6jthaaxkogownknqp` (`dept_id`),
  KEY `FKfftoc2abhot8f2wu6cl9a5iky` (`job_id`),
  CONSTRAINT `FK5rwmryny6jthaaxkogownknqp` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`),
  CONSTRAINT `FKfftoc2abhot8f2wu6cl9a5iky` FOREIGN KEY (`job_id`) REFERENCES `sys_job` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'https://i.loli.net/2019/04/04/5ca5b971e1548.jpeg', '2018-08-23 09:11:56', 'admin@sinovatio.rules', '1', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '2019-04-04 16:00:46', '2', '18888888888', '10');
INSERT INTO `sys_user` VALUES ('3', 'https://aurora-1255840532.cos.ap-chengdu.myqcloud.rules/8918a306ea314404835a9196585c4b75.jpeg', '2018-12-27 20:05:26', 'test@sinovatio.rules', '1', 'e10adc3949ba59abbe56e057f20f883e', 'test', '2019-04-01 09:15:24', '2', '17777777777', '12');

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE,
  KEY `FKq4eq273l04bpu4efj0jd0jb98` (`role_id`) USING BTREE,
  CONSTRAINT `sys_users_roles_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `sys_users_roles_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES ('1', '1');
INSERT INTO `sys_users_roles` VALUES ('3', '2');

-- ----------------------------
-- Table structure for sys_visits
-- ----------------------------
DROP TABLE IF EXISTS `sys_visits`;
CREATE TABLE `sys_visits` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `ip_counts` bigint(20) DEFAULT NULL,
  `pv_counts` bigint(20) DEFAULT NULL,
  `week_day` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_11aksgq87euk9bcyeesfs4vtp` (`date`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_visits
-- ----------------------------
INSERT INTO `sys_visits` VALUES ('20', '2019-04-18 16:20:41', '2019-04-18', '0', '2', 'Thu');
INSERT INTO `sys_visits` VALUES ('21', '2019-04-19 10:43:33', '2019-04-19', '1', '11', 'Fri');
INSERT INTO `sys_visits` VALUES ('22', '2019-04-22 14:21:35', '2019-04-22', '1', '4', 'Mon');
INSERT INTO `sys_visits` VALUES ('23', '2019-04-23 09:27:19', '2019-04-23', '1', '70', 'Tue');
INSERT INTO `sys_visits` VALUES ('24', '2019-04-24 02:15:27', '2019-04-24', '1', '20', 'Wed');
INSERT INTO `sys_visits` VALUES ('25', '2019-04-25 09:31:49', '2019-04-25', '1', '19', 'Thu');
INSERT INTO `sys_visits` VALUES ('26', '2019-04-28 15:21:04', '2019-04-28', '1', '7', 'Sun');
INSERT INTO `sys_visits` VALUES ('27', '2019-04-29 10:08:33', '2019-04-29', '1', '37', 'Mon');
INSERT INTO `sys_visits` VALUES ('28', '2019-05-06 09:50:17', '2019-05-06', '1', '5', 'Mon');

-- ----------------------------
-- Table structure for tls_email_config
-- ----------------------------
DROP TABLE IF EXISTS `tls_email_config`;
CREATE TABLE `tls_email_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `from_user` varchar(255) DEFAULT NULL COMMENT '收件人',
  `host` varchar(255) DEFAULT NULL COMMENT '邮件服务器SMTP地址',
  `pass` varchar(255) DEFAULT NULL COMMENT '密码',
  `port` varchar(255) DEFAULT NULL COMMENT '端口',
  `user` varchar(255) DEFAULT NULL COMMENT '发件者用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tls_email_config
-- ----------------------------
INSERT INTO `tls_email_config` VALUES ('5', 'jinlu.hansome@163.rules', 'smtp.163.rules', '45A9CA95DC808187', '255', 'jinlu.hansome@163.rules');

-- ----------------------------
-- Table structure for tls_gen_config
-- ----------------------------
DROP TABLE IF EXISTS `tls_gen_config`;
CREATE TABLE `tls_gen_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author` varchar(255) DEFAULT NULL COMMENT '开发者',
  `cover` bit(1) DEFAULT NULL COMMENT '是否覆盖',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `pack` varchar(255) DEFAULT NULL COMMENT '至于哪个包下',
  `path` varchar(255) DEFAULT NULL COMMENT '前端代码生成的路径',
  `api_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tls_gen_config
-- ----------------------------
INSERT INTO `tls_gen_config` VALUES ('1', 'admin', '\0', 'oceanmobile-system', 'rules.sinovatio.modules.system', 'E:\\workspace\\me\\eladmin-qt\\src\\views\\system\\dictDetail', 'E:\\workspace\\me\\eladmin-qt\\src\\api');

-- ----------------------------
-- Table structure for tls_verification_code
-- ----------------------------
DROP TABLE IF EXISTS `tls_verification_code`;
CREATE TABLE `tls_verification_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(255) DEFAULT NULL COMMENT '验证码',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `status` bit(1) DEFAULT NULL COMMENT '状态：1有效、0过期',
  `type` varchar(255) DEFAULT NULL COMMENT '验证码类型：email或者短信',
  `value` varchar(255) DEFAULT NULL COMMENT '接收邮箱或者手机号码',
  `scenes` varchar(255) DEFAULT NULL COMMENT '业务名称：如重置邮箱、重置密码等',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tls_verification_code
-- ----------------------------