package zrj.study.test.image;

import zrj.study.util.validate.ValidateCodeUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/27
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // 生成验证码图片并保存
        for (int i = 0; i < 50; i++) {
            int len = 4;
            String code = ValidateCodeUtils.createRandomCode(4);
            BufferedImage image = ValidateCodeUtils.createImage(code, 4 * 50, 70);
            ImageIO.write(image, "jpg", new File("D:/Captcha/" + code + ".jpg"));
        }
    }
}
