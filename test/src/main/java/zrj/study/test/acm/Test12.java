package zrj.study.test.acm;

/**
 * TODO 答案66666
 * 10. Regular Expression Matching
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/1
 */
public class Test12 {
    public static void main(String[] args) {
//        System.out.println(test("aaa", "a*a"));// 不知道怎么解决这种匹配...
        System.out.println(isMatch("abcd", "d*"));
    }

    // 答案
    public static boolean isMatch(String s, String p) {

        if (p.length() == 0) {
            return s.length() == 0;
        } else if (s.length() == 0) {
            return (p.length() > 1 && p.charAt(1) == '*') && isMatch(s, p.substring(2));
        } else if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            } else {
                if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                    return isMatch(s.substring(1), p);
                } else {
                    return false;
                }
            }
        } else {
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static boolean test(String s, String p) {
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int i = 0, j = 0;
        while (i < ss.length && j < ps.length) {

            if (j < ps.length - 1 && ps[j + 1] == '*') {
                if (ps[j] == '.') {
                    return true;
                } else {
                    while (ps[j] == ss[i]) {
                        i++;
                        if (i == ss.length && j == ps.length - 2) {
                            return true;
                        }
                    }
                }
                j++;
            } else {
                if (ps[j] == '.') {
                    i++;
                } else {
                    if (ps[j] != ss[i]) {
                        return false;
                    }
                    i++;
                }
            }
            j++;
        }

        return i == ss.length && j == ps.length;
    }
}
