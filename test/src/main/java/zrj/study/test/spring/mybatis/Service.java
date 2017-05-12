package zrj.study.test.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.test.spring.mybatis.dao.*;
import zrj.study.test.spring.mybatis.dao.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/12
 */
@Transactional(readOnly = true)
public class Service {

    @Autowired
    private DataSource dataSource;

    @Transactional
    public void rollback1() throws SQLException {
        Connection connection = DataSourceUtils.getConnection(dataSource); // 保证和spring事务管理用的是同一个connection
        Statement statement = connection.createStatement();
        statement.addBatch("INSERT INTO test (name) VALUES (\"123\")");
        statement.executeBatch();
        throw new RuntimeException("不许提交");
    }

    @Autowired
    private TestDao testDao;

    @Transactional
    public void rollback2() {
        zrj.study.test.spring.mybatis.dao.Test test = new Test();
        test.setName("123123");
        testDao.insert(test);
        throw new RuntimeException("不许提交");
    }


    @Transactional
    public void insert() throws SQLException {
        Connection connection = DataSourceUtils.getConnection(dataSource); // 保证和spring事务管理用的是同一个connection
        Statement statement = connection.createStatement();
        statement.addBatch("INSERT INTO test (name) VALUES (\"123123\")");
        statement.executeBatch();
    }

}
