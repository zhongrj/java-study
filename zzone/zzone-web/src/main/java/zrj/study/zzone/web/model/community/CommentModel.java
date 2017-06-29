package zrj.study.zzone.web.model.community;

import org.hibernate.validator.constraints.NotEmpty;
import zrj.study.zzone.web.model.BaseModel;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/29
 */
public class CommentModel extends BaseModel {

    @NotEmpty(message = "贴子id不能为空")
    private String postId;

    @NotEmpty(message = "内容不能为空")
    private String content;

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
