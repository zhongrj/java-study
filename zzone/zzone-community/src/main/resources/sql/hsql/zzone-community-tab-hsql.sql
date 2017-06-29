
-- ----------------------------
-- Table structure for community_post
-- ----------------------------
DROP TABLE IF EXISTS community_post;
CREATE TABLE community_post (
  id int AUTO_INCREMENT,
  title varchar(100),
  comment_count,
  create_by varchar(100),
  create_date datetime,
  del_flag int,
);

-- ----------------------------
-- Table structure for community_comment
-- ----------------------------
DROP TABLE IF EXISTS community_comment;
CREATE TABLE community_comment (
  id int AUTO_INCREMENT,
  post_id varchar(100),
  content tinytext,
  create_by varchar(100),
  create_date datetime,
  del_flag int,
);


