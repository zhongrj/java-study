package zrj.study.test.acm;

/**
 * 58. Length of Last Word
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test56 {
    public static void main(String[] args) {
        System.out.println(test("Hello World"));
    }

    private static int test(String s) {
        int index = s.length() - 1;
        if (index == -1 || s.charAt(index) == ' ') {
            return 0;
        } else {
            int count = 1;
            while (index-- > 0) {
                if (s.charAt(index) == ' ') {
                    return count;
                } else {
                    count++;
                }
            }
            return count;
        }
    }
}
