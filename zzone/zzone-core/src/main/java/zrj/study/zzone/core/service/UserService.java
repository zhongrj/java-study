package zrj.study.zzone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.util.string.StringUtils;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.dao.UserDao;
import zrj.study.zzone.core.entity.User;

import java.util.regex.Pattern;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
@Service
@Transactional(readOnly = true)
public class UserService extends BaseService {

    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{11}");

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$");

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

        if (StringUtils.isBlank(user.getMobile()) || !PHONE_PATTERN.matcher(user.getMobile()).matches()){
            throw new ZzoneException("手机号格式错误");
        }

        if (StringUtils.isBlank(user.getMobile()) || !EMAIL_PATTERN.matcher(user.getMobile()).matches()){
            throw new ZzoneException("邮箱格式错误");
        }

        if (userDao.countByAccount(user.getAccount()) > 0) {
            throw new ZzoneException("用户名已存在");
        }
        user.preInsert();
        userDao.insert(user);
    }

    public static void main(String[] args) {
        String a = "aa@as.co";
        System.out.println(StringUtils.isNotBlank(a) && EMAIL_PATTERN.matcher(a).matches());
    }
}
