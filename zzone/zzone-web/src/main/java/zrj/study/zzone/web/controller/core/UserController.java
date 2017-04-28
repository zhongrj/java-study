package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zrj.study.zzone.core.entity.RSAKey;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.core.service.CodeService;
import zrj.study.zzone.core.service.KeyService;
import zrj.study.zzone.core.service.UserService;
import zrj.study.zzone.web.controller.BaseController;
import zrj.study.zzone.web.model.Result;
import zrj.study.zzone.web.model.core.UserModel;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * 用户Controller
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private KeyService keyService;

    @Autowired
    private CodeService codeService;

    @RequestMapping("/login")
    public Result login(@RequestBody @Valid UserModel userModel) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("token", userService.login(userModel.getUser()));
        return new Result(Result.SUCCESS, "登录成功", resultMap); // 可多个设备同时登陆, 一个用户可对应多个token
    }

    @RequestMapping("/register")
    public Result register(@RequestBody @Valid UserModel userModel) {

        // 校验验证码
        codeService.checkCode(userModel.getMacId(), userModel.getCodeTxt());

        User user = userModel.getUser();

        // 密码解密
        RSAKey rsaKey = keyService.get(userModel.getKeyId());
        user.setPassword(decryptBase64((user.getPassword()), rsaKey));

        // 注册
        userService.register(user);

        // 业务成功后删除密钥
        keyService.remove(userModel.getKeyId());

        return new Result(Result.SUCCESS, "注册成功");
    }

    @RequestMapping("/hello")
    public Result hello(@RequestAttribute("user") User user) {
        return new Result(Result.SUCCESS, "你好, " + user.getName(), user);
    }


}
