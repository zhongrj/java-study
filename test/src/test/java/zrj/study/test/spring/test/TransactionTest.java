package zrj.study.test.spring.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional
public class TransactionTest extends BaseTest {

    @Autowired
    private Service service;

    @Test
    @Rollback // 没反应..
    public void testTransaction() throws SQLException {
        service.insert();
    }
}
