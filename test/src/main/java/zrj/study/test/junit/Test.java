package zrj.study.test.junit;

import org.junit.runner.RunWith;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/6
 */
@RunWith(MyRunner.class)
public class Test {


    public String a;

    @org.junit.Test
    public void test() {
        System.out.println("hello " + a);
    }

}
