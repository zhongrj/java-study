package zrj.study.test.acm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 31. Next Permutation
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/6
 */
public class Test30 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 2};
        test(nums);
        Arrays.stream(nums).forEach(i -> System.out.printf("%d, ", i));
    }

    private static void test(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[--i]) {
                int j = i;
                while (++j <= nums.length - 1) {
                    if (nums[j] <= nums[i]) {
                        break;
                    }
                }
                swap(nums, i, j - 1);
                Arrays.sort(nums, i + 1, nums.length);              // 其实可以用reverse
                return;
            }
        }

        Arrays.sort(nums, 0, nums.length);              // 其实可以用reverse

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
