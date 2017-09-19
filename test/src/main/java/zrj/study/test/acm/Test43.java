package zrj.study.test.acm;

import sun.nio.cs.ext.ISCII91;

/**
 * 44. Wildcard Matching
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/18
 */
public class Test43 {
    public static void main(String[] args) {
        System.out.println(isMatch("ab", "*"));
    }

    private static boolean isMatch(String s, String p) {

        if (s.length() == 0) {
            return p.length() == 0;
        }

        if (p.length() == 0) {
            return false;
        }

        if (p.length() == 1) {
            if ("*".equals(p)) {
                return true;
            } else if ("?".equals(p)) {
                return s.length() == 1;
            } else {
                return p.equals(s);
            }
        }

        if ('*' == p.charAt(1)) {
            return ('?' == p.charAt(0) || s.charAt(0) == p.charAt(0))
                    && (isMatch(s.substring(1), p.substring(2)) || isMatch(s.substring(1), p));
        } else {
            return ('?' == p.charAt(0) || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p.substring(1));
        }
    }
}
