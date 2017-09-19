package zrj.study.test.acm;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test48 {
    public static void main(String[] args) {
        System.out.println(test(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static List<List<String>> test(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = null;
            if ((list = map.get(key)) == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
