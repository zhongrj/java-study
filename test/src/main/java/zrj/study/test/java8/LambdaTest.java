package zrj.study.test.java8;

import java.util.Comparator;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/17
 */
public class LambdaTest {

    @org.junit.Test
    public void lambdaTest() {
        Comparator c = (o1, o2) -> 0;

        System.out.println(c.compare(1, 2));
        c.equals(1);            //...
        System.out.println(c.equals(1));

        IAnimal animal = () -> System.out.println("walk ");
        animal.walk();
    }

    private static interface IAnimal{
        void walk();
//        void sleep(long time);
    }


}
