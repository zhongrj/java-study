package zrj.study.test.acm;

/**
 * 53. Maximum Subarray
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test51 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    private static int test(int[] nums) {
        int max = -0x80000000, sum = 0;
        for (int n : nums) {
            sum += n;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
