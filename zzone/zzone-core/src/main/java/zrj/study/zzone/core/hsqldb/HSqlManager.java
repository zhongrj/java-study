package zrj.study.zzone.core.hsqldb;

import org.hsqldb.util.DatabaseManagerSwing;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class HSqlManager {

    public static void main(String[] args) {

        /**
         * url: jdbc:hsqldb:hsql://localhost/zzone
         * 其他配置为默认
         */

        DatabaseManagerSwing.main(args);
    }

}
