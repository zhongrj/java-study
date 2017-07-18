package zrj.study.test.java8book;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/15
 */
public class InterfaceTest1 implements A {
    public void test1() {
        test();     // super特指父类，不指接口
    }

    public static void main(String[] args) {
        new InterfaceTest1().test();
        A.test2();
    }
}


/**
 * 原则
 * 1. 优先本类
 * 2. 优先父类
 * 3. 最后覆盖的接口实现
 */


interface A {
    default void test() {
        System.out.println("a");
    }
    static void test2() {// static方法不需要default
        System.out.println("a2");
    }
}

interface B {
    default void test() {
        System.out.println("b");
    }
}