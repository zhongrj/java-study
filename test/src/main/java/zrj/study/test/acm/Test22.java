package zrj.study.test.acm;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/4
 */
public class Test22 {
    public static void main(String[] args) {
        System.out.println(test("({[})"));
    }

    private static boolean test(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                try {
                    char p = stack.pop();
                    if (p == '(' && c != ')'
                            || (p == '{' && c != '}')
                            || (p == '[' && c != ']')) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
