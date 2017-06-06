
-- ----------------------------
-- View structure for core_user_basic
-- ----------------------------
CREATE VIEW core_user_basic AS select core_user.id AS id, core_user.account AS account, core_user.name AS name, core_user.mobile AS mobile, core_user.email AS email, core_user.type AS type, core_user.status AS status, core_user.del_flag AS del_flag from core_user;


-- ----------------------------
-- Records of core_user
-- ----------------------------
INSERT INTO core_user VALUES ('0a27d82c021e456fb8b4f9e0fe343c1c', 'admin', 'admin', '超级管理员', '13660677179', '329063269@qq.com', '9', '0', '2017-04-27 16:10:40', '2017-04-27 16:10:40', '0');


-- ----------------------------
-- Records of core_option
-- ----------------------------
INSERT INTO core_option VALUES ('离线', '0', 'user_status', '用户状态', '0');
INSERT INTO core_option VALUES ('在线', '1', 'user_status', '用户状态', '0');




