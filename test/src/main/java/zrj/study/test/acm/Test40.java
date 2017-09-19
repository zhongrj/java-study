package zrj.study.test.acm;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. First Missing Positive
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/18
 */
public class Test40 {
    public static void main(String[] args) {
        System.out.println(answer(new int[]{1, 2, 0}));
    }

    private static int test(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n > 0) {
                set.add(n);
            }
        }

        int i = 0;
        while (true) {
            if (!set.contains(++i)) {
                return i;
            }
        }

    }

    // 也算O(n), 算swap的次数
    private static int answer(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 0 && n < nums.length && n - 1 != i && nums[n - 1] != n) {
                swap(nums, i--, n - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
