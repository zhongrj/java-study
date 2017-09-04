package zrj.study.test.acm;

/**
 * 13. Roman to Integer
 * Created by Administrator on 2017/9/2.
 */
public class Test15 {
    public static void main(String[] args) {
        System.out.println(test("DCXXI"));
    }

    private static final int[] AMOUNT = new int[]{1, 5, 10, 50, 100, 500, 1000};
    private static final String SYMBOL = "IVXLCDM";


    private static int test(String s) {

        int result = 0, curr = 0;

        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > -1; i--) {
            int amount = AMOUNT[SYMBOL.indexOf(chars[i])];
            if (amount >= curr) {
                curr = amount;
                result += amount;
            } else {
                result -= amount;
            }
        }

        return result;
    }

}
