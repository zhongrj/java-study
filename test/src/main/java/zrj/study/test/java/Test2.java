package zrj.study.test.java;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/21
 */
public class Test2 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;

        Integer e = 333;
        Integer f = 333;
        Integer i = 332;

        Long g = 3L;
        Long h = 334L;

        // 直接比较对象
        System.out.println(c == d);
        System.out.println(e == f);

        // 全部调用intValue或longValue再相加，再比较
        System.out.println(a + b == c);
        System.out.println(a + i == e);
        System.out.println(a + b == g);
        System.out.println(a + e == h);
    }

}
