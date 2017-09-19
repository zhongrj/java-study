package zrj.study.test.acm;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test49 {
    public static void main(String[] args) {
        System.out.println(test(2, 3));
    }

    private static double test(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return 1 / test(x, -n);
        }

        double half = test(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half / x;
        }
    }
}
