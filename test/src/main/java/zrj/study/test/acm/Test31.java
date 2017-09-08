package zrj.study.test.acm;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/7
 */
public class Test31 {
    public static void main(String[] args) {

//        System.out.println(test(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"));
        System.out.println(test("()((())(()))(()))))((())))()()())(())()()("));
    }


    // 那里错了, 见了鬼
    private static int test(String s) {
        int max = 0;
        int start = -1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    start = start == -1 ? stack.pop() : Math.min(start, stack.pop());
                } else {
                    if (start == -1) continue;
                    max = Math.max(max, i - start);
                    start = -1;
                }
            }
        }

        if (start == -1) {
            return max;
        }

        int end = s.length();
        if (!stack.isEmpty()) {
            int index = stack.pop();
            max = Math.max(max, end - index - 1);
            end = index;
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (index < start) {
                break;
            }
            end = index;
        }
        max = Math.max(max, end - start);

        return max;
    }
}
