package zrj.study.test.acm;

/**
 * 33. Search in Rotated Sorted Array
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/7
 */
public class Test32 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{8, 9, 2, 3, 4}, 9));
    }

    private static int test(int[] nums, int target) {

        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + high >>> 1;
            int lowVal = nums[low], highVal = nums[high], midVal = nums[mid];

            if (target == lowVal) {
                return low;
            } else if (target == highVal) {
                return high;
            } else if (target == midVal) {
                return mid;
            }

            if (highVal > lowVal) {
                return binarySearch(nums, low, high, target);
            }


            if (target > lowVal) {
                if (midVal < lowVal) {
                    high = mid - 1;
                    low++;
                } else if (target > midVal) {
                    low = mid + 1;
                    high--;
                } else {
                    return binarySearch(nums, low + 1, mid - 1, target);
                }
            } else if (target < highVal) {
                if (highVal < midVal) {
                    low = mid + 1;
                    high--;
                } else if (target < midVal) {
                    high = mid - 1;
                    low++;
                } else {
                    return binarySearch(nums, mid + 1, high - 1, target);
                }
            } else {
                return -1;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] arrays, int fromIndex, int toIndex, int target) {
        int low = fromIndex, high = toIndex;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arrays[mid];
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
