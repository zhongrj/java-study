package zrj.study.zzone.web.model.community;

import org.hibernate.validator.constraints.NotEmpty;
import zrj.study.zzone.web.model.BaseModel;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/26
 */
public class PostModel extends BaseModel {

    @NotEmpty(message = "标题不能为空")
    private String title;

    @NotEmpty(message = "内容不能为空")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
