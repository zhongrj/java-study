package zrj.study.test.spring.test;

import org.junit.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.test.spring.BaseTest;
import zrj.study.test.spring.mybatis.*;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
@ContextConfiguration(classes = zrj.study.test.spring.mybatis.Config.class)
@Transactional // 事务管理 默认不提交？
public class Test2 extends BaseTest {

    @Test
    @Sql("classpath:sql/test.sql")
    @Commit // 也作用与@Sql
    public void testSQL() {
        System.out.println("66666");
    }


}
