package zrj.study.test.spring.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.test.spring.BaseTest;
import zrj.study.test.spring.mybatis.*;

import java.sql.SQLException;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/12
 */
@ContextConfiguration(classes = zrj.study.test.spring.mybatis.Config.class)
//@TestExecutionListeners(listeners = TransactionalTestExecutionListener.class)
@Transactional // 这个好像有用
public class Test1 extends BaseTest {

    @Autowired
    private Service service;

    @Test
//    @Rollback // 没反应..
//    @Commit     // 提交
    public void testTransaction() throws SQLException {
        System.out.println("123");
        service.insert();
    }
}
