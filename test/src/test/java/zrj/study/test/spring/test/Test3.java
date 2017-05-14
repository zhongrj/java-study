package zrj.study.test.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import zrj.study.test.spring.common.BaseTestConfiguration;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
@RunWith(SpringRunner.class)
@BaseTestConfiguration
//@ActiveProfiles("dev") // 激活profile
public class Test3 {

    @Autowired
    private Person ben;

    @Test
    public void test() {
        System.out.println(ben.getName());
    }
}
