package zrj.study.test.acm;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * Created by Administrator on 2017/9/3.
 */
public class Test19 {
    public static void main(String[] args) {
        System.out.println(test("23"));
    }

    private final static String[][] LETTERS = new String[][]{
            null,
            null,
            new String[]{"a", "b", "c"},
            new String[]{"d", "e", "f"},
            new String[]{"g", "h", "i"},
            new String[]{"j", "k", "l"},
            new String[]{"m", "n", "o"},
            new String[]{"p", "q", "r", "s"},
            new String[]{"t", "u", "v"},
            new String[]{"w", "x", "y", "z"}
    };

    private static List<String> test(String digits) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {

            char c = digits.charAt(i);
            String[] letters = LETTERS[Character.getNumericValue(c)];

            int oldLength = result.size();
            if (0 == oldLength) {
                for (int j = 0; j < letters.length; j++) {
                    result.add(letters[j]);
                }
                continue;
            }

            int count = letters.length - 1;
            while (count-- > 0) {
                for (int j = 0; j < oldLength; j++) {
                    result.add(result.get(j));
                }
            }

            for (int j = 0; j < letters.length; j++) {
                int temp = (j + 1) * oldLength;
                for (int k = j * oldLength; k < temp; k++) {
                    result.set(k, result.get(k) + letters[j]);
                }
            }

        }

        return result;
    }
}
