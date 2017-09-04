package zrj.study.test.acm;

/**
 * 9. Palindrome Number
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/1
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println(test(1000000001));
    }

    // 不允许额外空间 // reverse吧
    private static boolean test(int x) {
        if (x < 0) {
            return false;
        }

        return x == Test9.answer(x);
    }
}
