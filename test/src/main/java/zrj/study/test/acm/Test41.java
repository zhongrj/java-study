package zrj.study.test.acm;

/**
 * 42. Trapping Rain Water
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/18
 */
public class Test41 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private static int test(int[] height) {
        int water = 0;

        // 找最大值坐标
        int maxIndex = 0;
        for (int i = 0, max = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        // 最大值左边
        for (int i = 0, left = 0; i < maxIndex; i++) {
            int h = height[i];
            if (h > left) {
                left = h;
            } else {
                water += left - h;
            }
        }

        // 最大值右边
        for (int i = height.length - 1, right = 0; i > maxIndex; i--) {
            int h = height[i];
            if (h > right) {
                right = h;
            } else {
                water += right - h;
            }
        }

        return water;
    }
}
