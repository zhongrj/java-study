package zrj.study.test.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/15
 */
public class Test {

    // 同一个conn未提交能看到数据吗?
    @org.junit.Test
    public void sameConn() throws Exception {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 数据库连接url
        String url = "jdbc:mysql://localhost:3306/test";
        // 获取数据库连接
        Connection conn = DriverManager.getConnection(url, "root", "");

        conn.setAutoCommit(false);

        String sql = "INSERT INTO test ( name ) VALUES ( 'test' )";

        Statement stmt = conn.createStatement();
        stmt.execute(sql);

        String select = "select * from test where name = 'test'";
        ResultSet resultSet = stmt.executeQuery(select);
//        ResultSet resultSet = conn.createStatement().executeQuery(select);        // 有什么区别
        while (resultSet.next()) {  // 可以的...
            System.out.print(resultSet.getString(1) + "\t");
            System.out.println(resultSet.getString(2));
        }

        conn.rollback();
    }


    // 不同conn未提交能看到数据吗?
    @org.junit.Test
    public void diffConn() throws Exception {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 数据库连接url
        String url = "jdbc:mysql://localhost:3306/test";
        // 获取数据库连接
        Connection conn = DriverManager.getConnection(url, "root", "");

        Connection conn2 = DriverManager.getConnection(url, "root", "");

        conn.setAutoCommit(false);

        String sql = "INSERT INTO test ( name ) VALUES ( 'test' )";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);

        String select = "select * from test where name = 'test'";
        ResultSet resultSet = conn2.createStatement().executeQuery(select);        // 有什么区别
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1) + "\t");
            System.out.println(resultSet.getString(2));
        }

        conn.rollback();
    }



}
