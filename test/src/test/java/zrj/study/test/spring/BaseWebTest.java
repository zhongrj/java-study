package zrj.study.test.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import zrj.study.test.spring.springmvc.Config;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/15
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Config.class)
public class BaseWebTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test() {
        Assert.assertNotNull(this.mockMvc);
    }
}
