package zrj.study.test.acm;

/**
 * 14. Longest Common Prefix
 * Created by Administrator on 2017/9/2.
 */
public class Test16 {
    public static void main(String[] args) {
        System.out.println(test(new String[]{"abcsADRF", "abc51345adfk", "abczx;lkcj"}));
    }

    private static String test(String[] strs) {
        if (strs.length == 0) return "";
        String model = strs[0];
        int curr = 0;
        while (curr < model.length()) {
            for (int i = 0; i < strs.length; i++) {
                try {
                    if (strs[i].charAt(curr) == model.charAt(curr)) {
                        continue;
                    }
                } catch (IndexOutOfBoundsException e) {
                }
                return model.substring(0, curr);
            }
            curr++;
        }
        return model;
    }
}
