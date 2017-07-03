package zrj.study.zzone.web.controller.core;

import org.junit.Test;
import org.springframework.test.annotation.Commit;
import zrj.study.zzone.core.entity.RSAKey;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.web.controller.BaseControllerTest;
import zrj.study.zzone.web.model.core.UserModel;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/15
 */
public class UserControllerTest extends BaseControllerTest {

    @Test
//    @Commit
    public void register() throws Exception {
        UserModel userModel = new UserModel();
        initBaseModel(userModel);
        userModel.setCodeTxt(getCodeTxt());
        RSAKey rsaKey = getKey();
        User user = new User();
        user.setAccount("aaab");
        user.setPassword(encryptUseBCBase64("123123", rsaKey.getRsaPublicKey()));
        user.setName("测试注册1");
        user.setMobile("13660677133");
        user.setEmail("329053269a@pp.com");
        userModel.setUser(user);

        postJsonUnlogin("/core/user/register", userModel);

        account = user.getAccount();
        password = "123123";
        login();
    }


    @Test
    public void info() throws Exception {
        postJsonLogin("/core/user/info", null);
    }

    @Test
    public void logout() throws Exception {
        postJsonLogin("/core/user/logout", null);
    }

    @Test
//    @Commit
    public void modifyInfo() throws Exception {
        UserModel userModel = new UserModel();
        initBaseModel(userModel);
        User user = new User();
        user.setName("改个名字");
        user.setMobile("13663666176");
        user.setEmail("1231233425345@qq.com");
        userModel.setUser(user);
        postJsonLogin("/core/user/modifyInfo", userModel);
    }

    @Test
    @Commit
    public void modigyPassword() throws Exception {
        UserModel userModel = new UserModel();
        initBaseModel(userModel);
        User user = new User();
        RSAKey rsaKey = getKey();
        user.setPassword(encryptUseBCBase64("user", rsaKey.getRsaPublicKey()));
        userModel.setUser(user);
        postJsonLogin("/core/user/modifyPassword", userModel);
    }

}
