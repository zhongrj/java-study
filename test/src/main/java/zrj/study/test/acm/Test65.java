package zrj.study.test.acm;

/**
 * 69. Sqrt(x)
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/21
 */
public class Test65 {
    public static void main(String[] args) {
        System.out.println(test(1));
    }

    private static int test(int x) {
        int i = 2;
        while (true) {
            int j = x / i;
            if (i == j || i + 1 == j || i == j + 1) {
                return Math.min(i, j);
            } else {
                i = (i + j) / 2;
            }
        }
    }
}
