package zrj.study.test.file;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/25
 */
public class FileTest1 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://172.29.2.64/cma", "cmadata", "1*mysql");
        PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(0) FROM app_rcmd_record WHERE id = ?");

        Files.lines(Paths.get("D:\\initstatus.txt"), StandardCharsets.ISO_8859_1)
                .map(line -> {
                    Matcher m = Pattern.compile("^.*id\\s=\\s'(.*)';$").matcher(line);
                    m.find();
                    return m.group(1);
                })
                .forEach(id -> {
                    try {
                        pstmt.setString(1, id);
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            int count = rs.getInt(1);
                            if (count == 1) {
//                                System.out.print("ok");
                            } else {
                                System.out.printf("%s has %d records\n", id, count);
                            }
                        } else {
                            System.out.printf("Not exist: %s\n", id);
                        }
                    } catch (Exception e) {
                        System.out.printf("Exception: %s\n", id);
                    }
                });

    }
}
