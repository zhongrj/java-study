package zrj.study.test.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/22
 */
public class TLimit {

    private static class TLimit1 extends TLimit{}
    private static class TLimit2 extends TLimit1{}

    public static void main(String[] args) {

        extendTest(new TLimit2());
//        extendTest(new TLimit());     // 不行


        List<? extends Integer> list = null;    // 读取者
//        list.add(1); // 不给你写
        Integer i = list.get(1); // 但可以读

        List<? super Integer> list2 = null;     // 写入者
        list2.add(1); // 随意写
//        Integer i2 = list2.get(1); // 不知道读出来用什么类型接收的

//        Collections.copy();   // 这个方法很好的说明了这个东西的作用 PECS原则

    }

    private static <T extends TLimit1> void extendTest(T t) {}


    private static class TTT<T> {
        public static void main(String[] args) {
            superTest(new TTT<TLimit>());
//            superTest(new TTT<TLimit2>()); // 不行

            new TTT<TLimit>().test();
        }
        private static void superTest(TTT<? super TLimit1> ttt){}

        private T test() { return (T) new Object(); }
    }
}
