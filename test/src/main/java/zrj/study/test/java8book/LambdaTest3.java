package zrj.study.test.java8book;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/4
 */
public class LambdaTest3 {

    public static void main(String[] args) {
        final Integer a = 0;
        new Thread(() -> {
            System.out.println(a);
        }).start();
    }
}
