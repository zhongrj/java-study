package zrj.study.zzone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.dao.UserDao;
import zrj.study.zzone.core.entity.User;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
@Service
@Transactional(readOnly = true)
public class UserService extends BaseService {

    @Autowired
    UserDao userDao;

    @Autowired
    SessionService sessionService;

    @Transactional
    public String login(User user) {

        user = userDao.get(user);

        if (null == user) {
            throw new ZzoneException("用户名或密码错误");
        }

        String token = sessionService.addSession(user);

        return token;
    }

    @Transactional
    public void register(User user) {
        if (userDao.countByAccount(user.getAccount()) > 0) {
            throw new ZzoneException("用户名已存在");
        }
        user.preInsert();
        userDao.insert(user);
    }
}
