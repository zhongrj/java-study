package zrj.study.zzone.community.entity;

import zrj.study.zzone.core.entity.BaseEntity;
import zrj.study.zzone.core.entity.User;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/26
 */
public class Comment extends BaseEntity {

    private User user;
    private String postId;
    private String content;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
