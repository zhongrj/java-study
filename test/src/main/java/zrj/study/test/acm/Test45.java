package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 46. Permutations
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/18
 */
public class Test45 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{1, 2, 3}));
    }

    // 比答案慢好多...
    private static List<List<Integer>> test(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, new ArrayList<>(), Stream.iterate(0, a -> a + 1).limit(nums.length).collect(Collectors.toList()), result);

        return result;
    }

    private static void helper(int[] nums, List<Integer> list, List<Integer> left, List<List<Integer>> result) {

        if (left.isEmpty()) {
            result.add(list);
        }

        List<Integer> temp = new ArrayList<>();
        temp.addAll(left);
        for (int i : temp) {
            left.remove(new Integer(i));
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            newList.add(nums[i]);
            helper(nums, newList, left, result);
            left.add(0, i);
        }

    }
}
