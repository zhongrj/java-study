package zrj.study.test.acm;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Created by Administrator on 2017/9/3.
 */
public class Test18 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{-1, 2, 1, -4}, 1));
    }

    private static int test(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum <= target) {
                    while (j < k && nums[j++] == nums[j]) {
                    }
                } else {
                    while (j < k && nums[k--] == nums[k]) {
                    }
                }
            }
        }

        return result;
    }
}
