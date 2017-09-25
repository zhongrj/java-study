package zrj.study.test.acm;

/**
 * 70. Climbing Stairs
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/21
 */
public class Test66 {
    public static void main(String[] args) {
        System.out.println(test(5));
    }

    private static int test(int n) {
        int i = 1, j = 1;
        while (n-- > 1) {
            int temp = j;
            j += i;
            i = temp;
        }
        return j;
    }
}
