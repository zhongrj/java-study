package zrj.study.test.acm;

import java.util.*;

/**
 * 40. Combination Sum II
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/13
 */
public class Test39 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{2, 2, 2}, 4));
    }

    private static List<List<Integer>> test(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] candidates, int target, int start, int sum, List<Integer> trace, List<List<Integer>> result) {
//        Set<Integer> ignore = new HashSet<>();
        for (int i = start; i < candidates.length; i++) {
            if (trace.isEmpty() && i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
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
                helper(candidates, target, i + 1, newSum, trace, result);
                trace.remove(trace.size() - 1);
            }
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
//            ignore.add(candidates[i]);
        }
    }
}
