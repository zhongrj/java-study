package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.core.service.UserService;
import zrj.study.zzone.web.controller.BaseController;
import zrj.study.zzone.web.model.Result;

import javax.validation.Valid;


/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(@RequestBody @Valid User user) {
        return new Result(Result.SUCCESS, "登录成功", userService.login(user));
    }

    @RequestMapping("/register")
    public Result register(@RequestBody @Valid User user) {
        userService.register(user);
        return new Result(Result.SUCCESS, "注册成功");
    }

    @RequestMapping("/hello")
    public Result hello(@RequestAttribute("user") User user) {
        return new Result(Result.SUCCESS, "你好, " + user.getName(), "hello");
    }

}
