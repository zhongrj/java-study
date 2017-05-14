package zrj.study.test.hsql;

import org.hsqldb.server.Server;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class Test2 {

    public static void main(String[] args) {
        Server.main(new String[]{"-database.0", "db/zzone", "-dbname.0", "zzone"});
        System.out.println(123);
    }
}
