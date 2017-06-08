package zrj.study.zzone.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.core.service.CodeService;
import zrj.study.zzone.core.service.KeyService;
import zrj.study.zzone.web.model.BaseModel;
import zrj.study.zzone.web.model.Result;
import zrj.study.zzone.web.model.core.UserModel;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * 测试接口
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/26
 */
@RestController
@RequestMapping("/test/")
public class TestController extends BaseController {

    @Autowired
    private KeyService keyService;

    @Autowired
    private CodeService codeService;


    /**
     * 获取html页面
     */
    @RequestMapping("html/{html}")
    public void upload(@PathVariable(name = "html") String html, HttpServletResponse response) {
        returnResource(response, "classpath:html/" + html + ".html");
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

    /**
     * 验证码测试
     */
    @RequestMapping("checkCode")
    public Result checkCode(@RequestBody BaseModel baseModel) {
        codeService.checkCode(baseModel.getMacId(), baseModel.getCodeTxt());
        return new Result(Result.SUCCESS, "验证码正确");
    }

    /**
     * 获取视频流
     */
    @RequestMapping("videoStream")
    public void videoStream(HttpServletResponse response) {
        returnResource(response, "classpath:html/pingpang.mp4");
    }

    /**
     * 返回资源文件内容
     * 临时用用
     *
     * @param response http响应
     * @param path     资源路径
     */
    private void returnResource(HttpServletResponse response, String path) {
        try {
            File file = ResourceUtils.getFile(path);
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            throw new ZzoneException("返回资源异常", e);
        }
    }

}
