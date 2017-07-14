package zrj.study.test.thread;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/3
 */
public class ThreadTest6 {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            test();
            Thread.sleep(1000);
        }
    }

    private static void test() {
        final Person p = new Person();              // 依然每次都会new...那么thread的时候为什么要final呢
        System.out.println(p.id);
        p.id = p.id + 1;
    }

    private static class Person {
        private int id;
    }
}
