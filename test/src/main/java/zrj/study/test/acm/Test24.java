package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/4
 */
public class Test24 {
    public static void main(String[] args) {
        System.out.println(test(3));
    }

    private static List<String> test(int n) {
        List<String> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        branch(result, "(", 1, 0, n);

        return result;
    }


    // 可以不用String，用StringBuffer，每次删除最后一个字符，详情请看答案...
    private static void branch(List<String> result, String item, int left, int right, int n) {
        if (right == n) {
            result.add(item);
            return;
        }

        if (left < n) {
            branch(result, item + "(", left + 1, right, n);
        }
        if (left > right) {
            branch(result, item + ")", left, right + 1, n);
        }
    }


}
