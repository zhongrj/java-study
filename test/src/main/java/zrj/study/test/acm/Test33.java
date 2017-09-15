package zrj.study.test.acm;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 34. Search for a Range
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/11
 */
public class Test33 {
    public static void main(String[] args) {
        Arrays.stream(test(new int[]{1, 2, 3}, 2)).forEach(System.out::println);
    }

    private static int[] test(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid, midValue;
        while (low <= high) {
            mid = (low + high) >>> 1;
            midValue = nums[mid];
            if (target < midValue) {
                high = mid - 1;
            } else if (target > midValue) {
                low = mid + 1;
            } else {
                int temp = mid;
                while (--temp >= 0 && nums[temp] == target) {}
                while (++mid < nums.length && nums[mid] == target) {}

                return new int[]{++temp, --mid};
            }
        }

        return new int[]{-1, -1};
    }
}
