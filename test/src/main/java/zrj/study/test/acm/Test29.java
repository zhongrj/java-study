package zrj.study.test.acm;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/6
 */
public class Test29 {
    public static void main(String[] args) {
        System.out.println(test("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

    private static List<Integer> test(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int length = words[0].length();

        for (int i = 0; i < length; i++) {
            int start = i, curr = start;
            List<String> list = new ArrayList<>(Arrays.asList(words));

            while (curr + length <= s.length() && curr + list.size() * length <= s.length()) {

                String word = s.substring(curr, curr + length);

                if (!list.remove(word)) {
                    String temp = s.substring(start, start + length);
                    while (!temp.equals(word) && start < curr) {
                        list.add(temp);
                        start += length;
                        temp = s.substring(start, start + length);
                    }
                    start += length;
                }

                curr += length;

                if (list.isEmpty()) {
                    result.add(start);
                }

            }
        }

        return result;
    }
}
