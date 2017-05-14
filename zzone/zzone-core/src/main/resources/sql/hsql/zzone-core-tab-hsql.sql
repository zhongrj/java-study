
-- ----------------------------
-- Table structure for core_session
-- ----------------------------
DROP TABLE IF EXISTS core_session;
CREATE TABLE core_session (
  token varchar(100),
  user_id varchar(100),
  create_date datetime,
  expire_date datetime,
);

-- ----------------------------
-- Table structure for core_user
-- ----------------------------
DROP VIEW IF EXISTS core_user_basic;
DROP TABLE IF EXISTS core_user;
CREATE TABLE core_user (
  id varchar(100),
  account varchar(50),
  password varchar(50),
  name varchar(50),
  mobile varchar(50),
  email varchar(50),
  type int,
  status int,
  create_date datetime,
  update_date datetime,
  del_flag int,
);
-- ----------------------------
-- View structure for core_user_basic
-- ----------------------------
CREATE VIEW core_user_basic AS select core_user.id AS id, core_user.account AS account, core_user.name AS name, core_user.mobile AS mobile, core_user.email AS email, core_user.type AS type, core_user.status AS status, core_user.del_flag AS del_flag from core_user;



-- ----------------------------
-- Table structure for core_option
-- ----------------------------
DROP TABLE IF EXISTS core_option;
CREATE TABLE core_option (
  label varchar(100),
  value varchar(100),
  type varchar(100),
  description varchar(200),
  del_flag int,
);





