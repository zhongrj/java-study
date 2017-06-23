package zrj.study.zzone.web.controller.core;

import org.junit.Assert;
import org.junit.Test;
import zrj.study.zzone.web.controller.BaseControllerTest;
import zrj.study.zzone.web.model.Result;

import java.util.Map;


/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/8
 */
public class UploadControllerTest extends BaseControllerTest {

    @Test
    public void image() throws Exception {
        Result result = uploadFile("/core/upload/image", "panda.jpg", "panda.jpg");
        Map map = (Map) result.getContent();
        Assert.assertNotNull(map.get("panda.jpg"));
    }


}
