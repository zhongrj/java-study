package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/4
 */
public class Test20 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{-1, 0, 1, 2, -1, -4}, -1));
    }

    private static List<List<Integer>> test(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }

                    while (sum <= target && k < l && nums[k++] == nums[k]) {
                    }
                    while (sum > target && k < l && nums[l--] == nums[l]) {
                    }
                }
            }
        }

        return result;
    }
}
