package zrj.study.test.acm;

/**
 * 65. Valid Number
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test63 {
    public static void main(String[] args) {
        System.out.println(test("2e10"));
    }

    private static boolean test(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean e = false, dot = false, num = false, sign = false;
        for (char c : s.toCharArray()) {
            if (c >= 48 && c <= 58) {
                num = true;
            } else if (c == 'e') {
                if (e || !num) {
                    return false;
                }
                e = true;
                dot = false;
                num = false;
                sign = false;
            } else if (c == '.') {
                if (dot || e) {
                    return false;
                }
                dot = true;
            } else if (c == '-' || c == '+') {
                if (sign || num || dot) {
                    return false;
                }
                sign = true;
            } else {
                return false;
            }
        }
        return num;
    }
}
