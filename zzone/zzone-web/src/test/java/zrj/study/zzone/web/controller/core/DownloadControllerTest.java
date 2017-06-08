package zrj.study.zzone.web.controller.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import zrj.study.zzone.web.controller.BaseControllerTest;
import zrj.study.zzone.web.model.Result;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/8
 */
public class DownloadControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void image() throws Exception {

        Result result = uploadFile("/upload/image", "panda.jpg", "panda.jpg");
        Map map = (Map) result.getContent();
        String id = map.get("panda.jpg").toString();


        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/download/image").param("id", id));
        byte[] bytes = resultActions.andReturn().getResponse().getContentAsByteArray();
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
        ImageIO.write(image, "JPG", new FileOutputStream("/test.jpg"));
//        ImageUtils.showImage(image);              // 不行 干
    }

}
