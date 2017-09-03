package zrj.study.test.acm;

/**
 * 12. Integer to Roman
 * Created by Administrator on 2017/9/2.
 */
public class Test14 {
    public static void main(String[] args) {
        System.out.println(test(123));
    }


    // 答案没什么意思...
    private static String answer(int num) {
        return "";
    }



    // 有问题
    private static String test(int num) {
        StringBuffer sb = new StringBuffer();

        for (Map map : MAPS) {
            if (num >= map.amount) {
                int times = num / map.amount;
                appendTimes(sb, map.symbol, num / map.amount);
                num %= map.amount;
            }
        }
        return sb.toString();
    }

    private static void appendTimes(StringBuffer sb, String symbol, int times) {
        while (times-- > 0) {
            sb.append(symbol);
        }
    }

    private static final Map[] MAPS = new Map[]{
            new Map(1000, "M"),
            new Map(500, "D"),
            new Map(100, "C"),
            new Map(50, "L"),
            new Map(10, "X"),
            new Map(5, "V"),
            new Map(1, "I"),
    };

    private static class Map {
        int amount;
        String symbol;

        public Map(int amount, String symbol) {
            this.amount = amount;
            this.symbol = symbol;
        }
    }

}
