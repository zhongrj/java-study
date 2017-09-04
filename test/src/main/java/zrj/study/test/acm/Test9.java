package zrj.study.test.acm;

/**
 * 7. Reverse Integer
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/1
 */
public class Test9 {
    public static void main(String[] args) {
        System.out.println(test(2147483647));
        System.out.println(answer(2147483647));
    }


    // 答案
    public static int answer(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            if (result > 0x7FFFFFFF / 10 || result < 0x80000000 / 10) {
                return 0;
            }
            result = result * 10 + tail;
            x /= 10;
        }
        return result;
    }

    private static int test(int x) {
        int flag = x > 0 ? 1 : -1;
        x *= flag;

        StringBuffer result = new StringBuffer();
        while (x > 0) {
            result.append(String.valueOf(x % 10));
            x /= 10;
        }

        try {
            return flag * Integer.parseInt(result.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
