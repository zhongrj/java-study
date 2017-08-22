package zrj.study.test.jvm;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/18
 */
public class GcTest2 {
    public static void main(String[] args) {
//        test();
        {
            byte[] bytes = new byte[64 * 1024 * 1024];
//            bytes = null;
        }
//        int a = 1;
        System.gc();
    }

    private static void test() {
        byte[] bytes = new byte[64 * 1024 * 1024];
    }
}
