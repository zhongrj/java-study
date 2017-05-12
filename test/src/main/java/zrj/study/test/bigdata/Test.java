package zrj.study.test.bigdata;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/8
 */
public class Test {

    public int b = 1;
    public static int d = 0;

    public void test() {
        int c = 1;
        class A {
            int a;

            void test() {
                System.out.println(c);
            }
        }
        new A().test();

        class B extends Thread {
            @Override
            public void run() {
                System.out.println(c);
            }
        }
        new B().start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(c);
            }
        }.start();
//        c = 2;
    }

    public static class C {
        void test() {
            System.out.println(d);
        }
    }

    public static void main(String[] zzz) {
        new Test().test();
        new C().test();


        String a = "a" + "b";
        String b = "ab";
        System.out.println(a == b);

        try {
            throw new OutOfMemoryError("test");
        } catch (Throwable t) {
//            t.printStackTrace();
            for (StackTraceElement traceElement : t.getStackTrace())
                System.out.println("\tat " + traceElement);
        }
    }

}
