package zrj.study.test.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zrj.study.test.spring.test.Config;

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
//    @Test
//    public void testAutoWired() {
//        Assert.assertEquals("ben", ben.getName());
//    }
//
    @Value("${hello}")
    public String hello;

    @Test
    public void testProperties() {
        System.out.println(hello);
//        Assert.assertEquals("你好", hello);
    }


}
