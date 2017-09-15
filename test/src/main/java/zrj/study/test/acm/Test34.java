package zrj.study.test.acm;

/**
 * 35. Search Insert Position
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/11
 */
public class Test34 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{1, 3, 4}, 1));
    }

    private static int test(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid, midVal;
        while (low <= high) {
            mid = (low + high) >>> 1;
            midVal = nums[mid];

            if (target < midVal) {
                high = mid - 1;
            } else if (target > midVal) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }
}
