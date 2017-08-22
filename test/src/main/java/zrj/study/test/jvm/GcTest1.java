package zrj.study.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/7
 */
public class GcTest1 {
    public static void main(String[] args) {
        List a = new ArrayList();
        while (true) {
            a.add(new Object());
            a.remove(0);
        }
    }
}
