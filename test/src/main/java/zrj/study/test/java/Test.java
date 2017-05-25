package zrj.study.test.java;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/17
 */
public class Test {

    @org.junit.Test
    public void testBound() {
        /**
         * 两个大正数相加越界等于负数
         * 两个大负数相加越界等于正数或0
         * 一正一负相加不可能越界
         *
         * 其实画个数轴就很清楚了, 0~255, 0~127代表正数的0~127, 128~255代表-128~-1
         * 两个小负数相加虽然也超过了255, 但是却能算出正确答案, 这就是补码的神奇之处吧（轮回, 只要是它能表达的它都能算对）
         */
        byte a = -127;
        byte b = -126;
        byte c = (byte) (a + b);
        byte d = 126;
        byte e = (byte) (a - d);
        System.out.println(c);
        System.out.println(e);
        byte f = -128;
        byte g = (byte) (f + f);
        System.out.println(g);
    }


    @org.junit.Test
    public void compareTest() {
        int b = (1 << 31) - 1;        // int最大正数
        int a = -b;
        System.out.println(a > b);      // false
        System.out.println(a - b > 0);  // true
    }


    @org.junit.Test
    public void systemArrayCopyTest() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.arraycopy(a, 1, a, 2, 2);        // 并不会出问题
        for (int b : a) {
            System.out.println(b);
        }
    }

    @org.junit.Test
    public void assertTest() {
        int i = 1;
        assert i == 1;
        System.out.println("pass");
        assert i == 2;
        System.out.println("no pass");
    }

    @org.junit.Test
    public void charTest() {
        char a = 'a';
        char b = (char) (a + 256);
        System.out.println(b);
    }

}
