package zrj.study.test.java8book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/4
 */
public class LambdaTest1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

    }

    @FunctionalInterface
    private interface IPerson {
        void test();

//        void test2();
    }

}
