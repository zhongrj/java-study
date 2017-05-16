package zrj.study.test.sql.hsql;

import org.hsqldb.jdbc.JDBCDriver;

import java.sql.*;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class Test3 {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("CREATE TABLE test(name VARCHAR(100))");
    }
}
