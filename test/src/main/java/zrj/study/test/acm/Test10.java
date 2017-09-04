package zrj.study.test.acm;

/**
 * 8. String to Integer (atoi)
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/1
 */
public class Test10 {
    public static void main(String[] args) {
        test("");
    }

    // 这题太蠢，不做
    private static int test(String str) {
        if ("".equals(str))
            return 0;
        return Integer.parseInt(str);
    }
}
