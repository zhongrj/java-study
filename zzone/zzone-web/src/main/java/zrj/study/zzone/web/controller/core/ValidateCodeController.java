package zrj.study.zzone.web.controller.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.util.validate.ValidateCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 验证码Controller
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/26
 */
@RestController
@RequestMapping("/code/")
public class ValidateCodeController {

    /**
     * 获取验证码
     */
    @RequestMapping("get")
    public void get(HttpServletResponse response) {

        BufferedImage image = ValidateCodeUtils.createImage(70, 26);

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(image, "JPEG", out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
