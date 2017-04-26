package zrj.study.zzone.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.core.service.KeyService;
import zrj.study.zzone.web.model.Result;
import zrj.study.zzone.web.model.core.UserModel;

import javax.servlet.http.HttpServletResponse;

/**
 * 测试接口
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/26
 */
@RestController
@RequestMapping("/test/")
public class TestController extends BaseController {

    @Autowired
    private KeyService keyService;

    /**
     * 前端加密demo
     */
    @RequestMapping("encrypt")
    public void encrypt(HttpServletResponse response) {
        returnResource(response, "classpath:html/encrypt.html");
    }

    /**
     * 解密测试
     */
    @RequestMapping("decrypt")
    public Result decrypt(@RequestBody UserModel userModel) {
        User user = userModel.getUser();
        user.setPassword(decryptBase64(user.getPassword(), keyService.get(userModel.getKeyId())));
        return new Result(Result.SUCCESS, "解密成功", userModel);
    }



}
