package zrj.study.test.acm;

/**
 * 6. ZigZag Conversion
 *
 * 不知道题目什么意思...
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/1
 */
public class Test8 {
    public static void main(String[] args) {
        System.out.println(test("abcdefghijk", 4));
    }

    private static String test(String s, int numRows) {
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < buffers.length; i++) {
            buffers[i] = new StringBuffer();
        }
        char[] chars = s.toCharArray();
        int rows = numRows;
        int j = 0;
        int start = 0;
        int flag = -1;
        for (int i = 0; i < chars.length; i++) {

            if (j == rows) {
                j = 0;
                if (numRows <= 2) {
                    rows = numRows;
                } else {
                    rows += 2 * flag;
                    if (rows < 1 || rows > numRows) {
                        flag *= -1;
                        rows += 4 * flag;
                    }
                    start = (numRows - rows) / 2;
                }
            }
            buffers[start + (j++ % rows)].append(chars[i]);

        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < buffers.length; i++) {
            result.append(buffers[i].toString());
        }
        return result.toString();
    }
}
