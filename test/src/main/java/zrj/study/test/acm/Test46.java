package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 47. Permutations II
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test46 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{1, 1, 4}));
    }

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
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < temp.size(); i++) {
            Integer index = temp.get(i);
            if (set.contains(nums[index])) {
                continue;
            }
            set.add(nums[index]);
            left.remove(index);
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            newList.add(nums[index]);
            helper(nums, newList, left, result);
            left.add(0, index);
        }
    }
}
