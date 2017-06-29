package zrj.study.zzone.web.controller.community;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zrj.study.zzone.community.entity.Comment;
import zrj.study.zzone.community.entity.Post;
import zrj.study.zzone.community.service.CommunityService;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.web.controller.BaseController;
import zrj.study.zzone.web.model.PageModel;
import zrj.study.zzone.web.model.Result;
import zrj.study.zzone.web.model.community.CommentListModel;
import zrj.study.zzone.web.model.community.CommentModel;
import zrj.study.zzone.web.model.community.PostModel;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/26
 */
@RestController
@RequestMapping("/community/")
public class CommunityController extends BaseController {

    @Autowired
    private CommunityService communityService;

    @RequestMapping("post")
    public Result post(@RequestAttribute("user") User user, @RequestBody @Valid PostModel postModel) {
        communityService.post(user.getId(), postModel.getTitle(), postModel.getContent());
        return new Result(Result.SUCCESS, "发贴成功");
    }

    @RequestMapping("postList")
    public Result postList(@RequestBody @Valid PageModel pageModel) {
        PageInfo<Post> page = communityService.postList(pageModel.getPageNo(), pageModel.getPageSize());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", page.getTotal());
        resultMap.put("list", page.getList());
        return new Result(Result.SUCCESS, "获取发贴列表成功", resultMap);
    }

    @RequestMapping("commentList")
    public Result commentList(@RequestBody @Valid CommentListModel commentListModel) {
        PageInfo<Comment> page = communityService.commentList(commentListModel.getPostId(), commentListModel.getPageNo(), commentListModel.getPageSize());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", page.getTotal());
        resultMap.put("list", page.getList());
        return new Result(Result.SUCCESS, "获取评论列表成功", resultMap);
    }

    @RequestMapping("comment")
    public Result comment(@RequestAttribute("user") User user, @RequestBody CommentModel commentModel){
        communityService.comment(user.getId(), commentModel.getPostId(), commentModel.getContent());
        return new Result(Result.SUCCESS, "评论成功");
    }

}
