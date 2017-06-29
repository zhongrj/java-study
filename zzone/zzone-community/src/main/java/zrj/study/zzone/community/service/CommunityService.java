package zrj.study.zzone.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.zzone.community.dao.CommentDao;
import zrj.study.zzone.community.dao.PostDao;
import zrj.study.zzone.community.entity.Comment;
import zrj.study.zzone.community.entity.Post;
import zrj.study.zzone.core.service.SequenceService;

import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/26
 */
@Service
@Transactional(readOnly = true)
public class CommunityService {

    private final static String POST_SEQUENCE_ID = "post_id";

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private SequenceService sequenceService;

    @Transactional
    public void post(String userId, String title, String content) {

        Post post = new Post();
        post.preInsert();
        post.setId(String.valueOf(sequenceService.getNext(POST_SEQUENCE_ID)));
        post.setTitle(title);
        post.setCreateBy(userId);
        post.setCommentCount(1);
        postDao.insert(post);

        Comment comment = new Comment();
        comment.preInsert();
        comment.setPostId(post.getId());
        comment.setContent(content);
        comment.setCreateBy(userId);
        commentDao.insert(comment);

    }


    public PageInfo<Post> postList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Post> list = postDao.list(null);
        PageInfo<Post> page = new PageInfo<>(list);
        return page;
    }

    public PageInfo<Comment> commentList(String postId, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Comment param = new Comment();
        param.setPostId(postId);
        List<Comment> list = commentDao.list(param);
        PageInfo<Comment> page = new PageInfo<>(list);
        return page;
    }

    @Transactional
    public void comment(String userId, String postId, String content) {
        Comment comment = new Comment();
        comment.preInsert();
        comment.setPostId(postId);
        comment.setContent(content);
        comment.setCreateBy(userId);
        commentDao.insert(comment);
    }
}
