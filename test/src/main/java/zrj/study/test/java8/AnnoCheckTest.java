package zrj.study.test.java8;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.util.Optional;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/22
 */
public class AnnoCheckTest {

    @Test
    public void notNullTest() {
        hello("hello");
        hello(null);
    }

    private void hello(/**这有啥用**/@NotNull String a) {
        System.out.println("hello " + a);
    }


//    @Test
//    public void optionalTest() {
//        Optional // ?
//
//    }


}
