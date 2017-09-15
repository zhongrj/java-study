package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/13
 */
public class Test38 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{2, 3, 6, 7}, 7));
    }

    private static List<List<Integer>> test(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] candidates, int target, int start, int sum, List<Integer> trace, List<List<Integer>> result) {
        for (int i = start; i < candidates.length; i++) {
            int newSum = sum + candidates[i];
            if (newSum > target) {
                break;
            } else if (newSum == target) {
                List<Integer> item = new ArrayList<>();
                for (Integer n : trace) {
                    item.add(n);
                }
                item.add(candidates[i]);
                result.add(item);
            } else {
                trace.add(candidates[i]);
                helper(candidates, target, i, newSum, trace, result);
                trace.remove(trace.size() - 1);
            }
        }
    }
}
