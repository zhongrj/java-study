package zrj.study.test.acm;

import java.util.Stack;

/**
 * 29. Divide Two Integers
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/5
 */
public class Test28 {
    public static void main(String[] args) {
        System.out.println(test(5, 2));

        System.out.println(true ^ true);
    }


    private static int test(int dividend, int divisor) {

        if (divisor == 0 || dividend == 0x80000000 && divisor == -1) {
            return 0x7FFFFFFF;
        }

        if (divisor == 1) {
            return dividend;
        }

        boolean sign = ((dividend >= 0) == (divisor >= 0));

        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        if (dividend > divisor) {
            return 0;
        }

        int result = divisor,
                times = 1;

        Stack<int[]> stack = new Stack<>();

        while (true) {
            int sum = result + result;
            if (sum < dividend || sum >= 0) {
                break;
            } else if (sum == dividend) {
                times = times + times;
                return sign ? times : 0 - times;
            }
            stack.push(new int[]{times, result});
            result = sum;
            times += times;
        }

        if (stack.isEmpty()) {
            return sign ? 1 : -1;
        }
        int[] stackPop = stack.pop();

        while (true) {
            int sum = result + stackPop[1];
            if (sum < dividend || sum >= 0) {
                if (stack.isEmpty()) {
                    break;
                }
                stackPop = stack.pop();
                continue;
            } else if (result == dividend) {
                times = times + stackPop[0];
                break;
            }
            result = sum;
            times += stackPop[0];
        }

        return sign ? times : 0 - times;
    }
}
