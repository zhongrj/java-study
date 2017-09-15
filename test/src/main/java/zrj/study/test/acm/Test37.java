package zrj.study.test.acm;

/**
 * 38. Count and Say
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/12
 */
public class Test37 {
    public static void main(String[] args) {
        System.out.println(test(5));
    }

    private static String test(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = test(n - 1);
        char curr = '.';
        int count = 0;
        StringBuffer result = new StringBuffer();
        for (char c : pre.toCharArray()) {
            if (c != curr && curr != '.') {
                result.append(count);
                result.append(curr);
                count = 0;
            }
            curr = c;
            count++;
        }
        result.append(count);
        result.append(curr);
        return result.toString();
    }
}
