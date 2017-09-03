package zrj.study.test.acm;

import java.util.*;

/**
 * 15. 3Sum
 * Created by Administrator on 2017/9/2.
 */
public class Test17 {
    public static void main(String[] args) {
//        System.out.println(test(new int[]{-1, 0, 1, 2, -1, -4}));
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(answer(nums));
//        Arrays.stream(nums).forEach(System.out::println);

    }

    // 答案
    private static List<List<Integer>> answer(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (sum <= 0) {
                    while (j < k && nums[j++] == nums[j]) {
                    }
                } else {
                    while (j < k && nums[k--] == nums[k]) {
                    }
                }
            }

            while (i < nums.length - 2 && nums[i++] == nums[i]) {
            }
        }

        return result;
    }

    // 不能出现重复
    private static List<List<Integer>> test(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                Integer index = map.get(0 - nums[i] - nums[j]);
                if (null != index && index > j) {
                    result.add(Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j]));
                }
            }
        }
        return result;
    }

}
