package zrj.study.test.acm;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/31
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(test("au"));
    }

    public static String test(String string) {
        if ("".equals(string)) {
            return "";
        }

        int[] max = new int[]{0, 1};
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer index = map.get(c);
            if (index != null && index >= start) {
                if (i - start > max[1] - max[0]) {
                    max[0] = start;
                    max[1] = i;
                }
                start = index + 1;
            }
            map.put(c, i);
        }
        if (chars.length - start > max[1] - max[0]) {
            max[0] = start;
            max[1] = chars.length;
        }

        return string.substring(max[0], max[1]);
    }
}
