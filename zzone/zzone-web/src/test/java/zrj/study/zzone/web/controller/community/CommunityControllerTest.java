package zrj.study.zzone.web.controller.community;

import org.junit.Test;
import org.springframework.test.annotation.Commit;
import zrj.study.zzone.web.controller.BaseControllerTest;
import zrj.study.zzone.web.model.PageModel;
import zrj.study.zzone.web.model.community.CommentListModel;
import zrj.study.zzone.web.model.community.CommentModel;
import zrj.study.zzone.web.model.community.PostModel;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/26
 */
public class CommunityControllerTest extends BaseControllerTest {

    @Test
//    @Commit
    public void post() throws Exception {

        PostModel postModel = new PostModel();
        initBaseModel(postModel);
        postModel.setTitle("测试一下发帖5");
        postModel.setContent("我是楼主");
        postJsonLogin("/community/post", postModel);

    }

    @Test
    public void postList() throws Exception {

        PageModel pageModel = new PageModel();
        initBaseModel(pageModel);
        pageModel.setPageNo(1);
        pageModel.setPageSize(1);
        postJsonLogin("/community/postList", pageModel);

    }

    @Test
    public void commentList() throws Exception {

        CommentListModel commentListModel = new CommentListModel();
        initBaseModel(commentListModel);
        commentListModel.setPostId("6");
        commentListModel.setPageNo(1);
        commentListModel.setPageSize(1);
        postJsonLogin("/community/commentList", commentListModel);

    }

    @Test
    @Commit
    public void comment() throws Exception {
        CommentModel commentModel = new CommentModel();
        initBaseModel(commentModel);
        commentModel.setPostId("6");
        commentModel.setContent("测试回贴");
        postJsonLogin("/community/comment", commentModel);
    }

}
