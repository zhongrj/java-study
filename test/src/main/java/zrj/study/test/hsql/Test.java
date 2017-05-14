package zrj.study.test.hsql;

import org.hsqldb.jdbc.JDBCDriver;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Driver driver = JDBCDriver.driverInstance;
        Properties properties = new Properties();
        properties.setProperty("user", "sa");
        properties.setProperty("a", "true");
        Connection conn2 = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "sa", "");
        Connection conn = driver.connect("jdbc:hsqldb:mem:testdb", properties);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from core_user");

        while (rs.next()) {
            System.out.println("id: " + rs.getInt("id"));
            System.out.println("account: " + rs.getString("account"));
            System.out.println("name: " + rs.getString("name"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
