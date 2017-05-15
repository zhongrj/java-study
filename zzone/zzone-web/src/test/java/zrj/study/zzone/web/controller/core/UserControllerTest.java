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
        userModel.setKeyId(rsaKey.getId());
        User user = new User();
        user.setAccount("aaa");
        user.setPassword(encryptUseBCBase64("123123", rsaKey.getRsaPublicKey()));
        user.setName("测试注册");
        user.setMobile("13606161711");
        user.setEmail("123123123@w.sl");
        userModel.setUser(user);

        postJsonUnlogin("/register", userModel);

        account = user.getAccount();
        password = "123123";
        login();
    }

}
