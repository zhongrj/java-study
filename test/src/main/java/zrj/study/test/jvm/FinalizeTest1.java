package zrj.study.test.jvm;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/7
 */
public class FinalizeTest1 {

    private static FinalizeTest1 O;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("有人要回收我");
        O = this;
    }

    public static void main(String[] args) throws InterruptedException {
        O = new FinalizeTest1();

        O = null;
        System.gc();
        Thread.sleep(1000);

        if (O != null) {
            System.out.println("我还在");
        }

        O = null;
        System.gc();
        Thread.sleep(5000);

        if (O == null) {
            System.out.println("我死了");
        }

    }
}
