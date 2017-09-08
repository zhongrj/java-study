package zrj.study.test.acm;

import java.util.Arrays;

/**
 * 33. Search in Rotated Sorted Array
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/7
 */
public class Test32 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{4,5,6,7,8,1,2,3}, 8));
    }

    private static int test(int[] nums, int target) {

        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int lowVal = nums[low], highVal = nums[high];

            if (highVal > lowVal) {
                return binarySearch(nums, low, high, target);
            }

            if (target == lowVal) {
                return low;
            } else if (target == highVal) {
                return high;
            }

            if (target < lowVal && target > highVal) {
                return -1;
            } else if (target > lowVal) {
                high = (low++ + high) >>> 1;
            } else {
                low = (low + high--) >>> 1;
            }

        }

        return -1;
    }

    private static int binarySearch(int[] arrays, int fromIndex, int toIndex, int target) {
        int low = fromIndex, high = toIndex;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = arrays[mid];
            if (midVal == target) {
                return mid;
            } else if (target > midVal) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
