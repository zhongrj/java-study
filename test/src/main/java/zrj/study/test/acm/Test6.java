package zrj.study.test.acm;

/**
 * 4. Median of Two Sorted Arrays
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/31
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{1, 2}, new int[]{3, 4}));
    }

    private static double test(int[] nums1, int[] nums2) {


        int sum = nums1.length + nums2.length;
        int k = (sum + 1) / 2;
        int l = (sum + 2) / 2;
        double result = 0;

        int i = -1, j = -1;
        while (true) {

            if (i + j + 2 == k) {
                if (i == -1) {
                    result += nums2[j] / 2.0;
                } else if (j == -1) {
                    result += nums1[i] / 2.0;
                } else {
                    result += nums1[i] > nums2[j] ? nums1[i] / 2.0 : nums2[j] / 2.0;
                }
            }
            if (i + j + 2 == l) {
                if (i == -1) {
                    result += nums2[j] / 2.0;
                } else if (j == -1) {
                    result += nums1[i] / 2.0;
                } else {
                    result += nums1[i] > nums2[j] ? nums1[i] / 2.0 : nums2[j] / 2.0;
                }
                break;
            }

            if (i == nums1.length - 1) {
                j++;
            } else if (j == nums2.length - 1) {
                i++;
            } else if (nums1[i + 1] > nums2[j + 1]) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }
}
