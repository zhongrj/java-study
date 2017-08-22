package zrj.study.test.jvm;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/9
 */
//

public class Bar {
    int a = 1;
    static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }
}
