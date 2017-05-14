package zrj.study.test.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zrj.study.test.spring.test.Config;

import java.io.UnsupportedEncodingException;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@BootstrapWith
//@TestPropertySource(properties = {"hello=你好"})
@ContextConfiguration(classes = Config.class)
@TestPropertySource("classpath:config.properties") // 编码咋搞
//@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class BaseTest {

//    @Autowired
//    private Person ben;
//
//
//    @Test3
//    public void testAutoWired() {
//        Assert.assertEquals("ben", ben.getName());
//    }
//
    @Value("${hello}")
    public String hello;

    @Test
    @Repeat(2)
    @Timed(millis = 20) // 完成时间
    public void testProperties() throws UnsupportedEncodingException {
        System.out.println(new String(hello.getBytes("ISO-8859-1"), "utf-8"));
//        Assert.assertEquals("你好", hello);
    }


}
