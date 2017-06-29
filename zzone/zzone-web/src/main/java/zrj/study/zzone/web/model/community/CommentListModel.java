package zrj.study.zzone.web.model.community;

import org.hibernate.validator.constraints.NotEmpty;
import zrj.study.zzone.web.model.PageModel;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/28
 */
public class CommentListModel extends PageModel {

    @NotEmpty(message = "贴子id不能为空")
    private String postId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
