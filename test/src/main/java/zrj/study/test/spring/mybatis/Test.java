package zrj.study.test.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/12
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        ApplicationContext act = new AnnotationConfigApplicationContext(Config.class);
        Service service = act.getBean(Service.class);

        //  不能回滚
        // datasource每次getConnection都不是同一个 连接池吧
        // 那么框架是怎么回滚的呢?
        // conn.setAutoCommit( false );
        // conn.commit();
        // conn.rollback();
        // 或者还有别的方法回滚？
        // getConnectionHolder
        //
        // 原来靠的是DataSourceUtils.getConnection(dataSource);
        // 那么估计mybatis-spring也用了这个吧
        // mybatis-spring 的引用中有
//        <dependency>
//          <groupId>org.springframework</groupId>
//          <artifactId>spring-jdbc</artifactId>
//          <version>${spring.version}</version>
//          <scope>provided</scope>
//        </dependency>
        // 那么就很好解释了
//        service.rollback1();

//        service.rollback2();

//        service.insert();
    }

}
