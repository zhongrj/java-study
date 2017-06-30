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
    public User login(User user) {

        user = userDao.get(user);

        if (null == user) {
            throw new ZzoneException("用户名或密码错误");
        }

        switch (user.getStatus()) {
            case User.STATUS_FREEZED:
                throw new ZzoneException("该用户已被冻结");
            case User.STATUS_BLACKLIST:
                throw new ZzoneException("该用户为黑名单用户");
        }

        String token = sessionService.addSession(user);
        user.setToken(token);

        return user;
    }

    @Transactional
    public void register(User user) {

        // 校验
        checkAccount(user.getAccount());
        checkName(user.getName());
        checkMobile(user.getMobile());
        checkEmail(user.getEmail());

        user.preInsert();
        user.generateUUID();
        user.setType(User.TYPE_USER);
        user.setStatus(User.STATUS_NORMAL);
        userDao.insert(user);
    }

    @Transactional
    public void modifyInfo(String id, User user) {

        // 校验
//        checkName(user.getName());
//        checkMobile(user.getMobile());
//        checkEmail(user.getEmail());
//        不用校验重复

        user.setId(id);
        userDao.update(user);
    }


    private void checkAccount(String account) {
        if (userDao.countByField("account", account) > 0) {
            throw new ZzoneException("该用户名已存在");
        }
    }

    private void checkName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new ZzoneException("用户昵称不能为空");
        }
        if (userDao.countByField("name", name) > 0) {
            throw new ZzoneException("该昵称已存在");
        }
    }

    private void checkMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            throw new ZzoneException("手机号不能为空");
        }
        if (!PHONE_PATTERN.matcher(mobile).matches()) {
            throw new ZzoneException("手机号格式错误");
        }
        if (userDao.countByField("mobile", mobile) > 0) {
            throw new ZzoneException("该手机已绑定");
        }
    }

    private void checkEmail(String email) {
        if (StringUtils.isBlank(email)) {
            throw new ZzoneException("邮箱不能为空");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ZzoneException("邮箱格式错误");
        }
        if (userDao.countByField("email", email) > 0) {
            throw new ZzoneException("该邮箱已绑定");
        }
    }
}
