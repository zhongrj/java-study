package zrj.study.test.acm;

/**
 * 11. Container With Most Water
 * Created by Administrator on 2017/9/2.
 */
public class Test13 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{3, 4, 1, 6, 7, 3, 7, 1}));
    }

    public static int test(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            int curr = Math.min(height[i], height[j]) * (j - i);
            max = curr > max ? curr : max;

            if (height[i] < height[j]) {
                int curri = height[i];
                while (height[i] <= curri && i < j) {
                    i++;
                }
            } else {
                int currj = height[j];
                while (height[j] <= currj && i < j) {
                    j--;
                }
            }
        }
        return max;
    }
}
