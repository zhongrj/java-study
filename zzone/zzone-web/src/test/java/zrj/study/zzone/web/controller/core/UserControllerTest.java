package zrj.study.zzone.web.controller.core;

import org.junit.Test;
import org.springframework.test.annotation.Commit;
import zrj.study.zzone.core.entity.RSAKey;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.web.controller.BaseControllerTest;
import zrj.study.zzone.web.model.Result;
import zrj.study.zzone.web.model.core.UserModel;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
    @Commit
    public void modifyInfo() throws Exception {
        UserModel userModel = new UserModel();
        User user = new User();
        user.setName("改个名字");

        userModel.setUser(user);
        postJsonLogin("/core/user/modifyInfo", userModel);
    }

}
