package zrj.study.test.acm;

/**
 * 5. Longest Palindromic Substring
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/31
 */
public class Test7 {
    public static void main(String[] args) {
        System.out.println(test("1234212331"));
    }

    private static String test(String s) {

        char[] chars = s.toCharArray();
        int start = 0;
        int end = 1;
        for (int m = 0; m < chars.length - 1; m++) {

            int k = 0;
            while (k < 2) {
                int i = m - k, j = m + 1;
                while (i >= 0 && j <= chars.length - 1) {
                    if (chars[i] != chars[j]) {
                        break;
                    }
                    i--;
                    j++;
                }
                if (j - i - 1 > end - start) {
                    start = i + 1;
                    end = j;
                }
                k++;
            }
        }


        return s.substring(start, end);
    }
}
