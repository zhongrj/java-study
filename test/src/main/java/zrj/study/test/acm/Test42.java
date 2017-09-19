package zrj.study.test.acm;

/**
 * 43. Multiply Strings
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/18
 */
public class Test42 {
    public static void main(String[] args) {
        System.out.println(test("9", "9"));
    }

    private static String test(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int len = num1.length() + num2.length();
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }


        for (int i = 0; i < num2.length(); i++) {
            int x = num2.charAt(num2.length() - i - 1) - 48;
            int flag = 0;
            for (int j = 0; j < num1.length(); j++) {
                int y = num1.charAt(num1.length() - j - 1) - 48,
                        newVal = x * y + result[i + j] + flag;
                flag = newVal / 10;
                result[i + j] = newVal % 10;
            }
            int k = 0;
            while (flag > 0) {
                int temp = result[i + num1.length() + k] + flag;
                flag = temp / 10;
                result[i + num1.length() + k++] = temp % 10;
            }
        }


        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[len - i - 1] = (char) (result[i] + 48);
        }
        if (chars[0] == '0') {
            return new String(chars, 1, len - 1);
        }
        return new String(chars, 0, len);
    }
}
