package zrj.study.test.acm;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test53 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{3,2,1,0,4}));
    }

    private static boolean test(int[] nums) {
        int currFarthest = 0;
        for (int i = 0; i < nums.length && i <= currFarthest; i++) {
            if (i + nums[i] > currFarthest) {
                currFarthest = i + nums[i];
            }
            if (currFarthest >= nums.length - 1) {
                break;
            }
        }
        if (currFarthest < nums.length - 1) {
            return false;
        }
        return true;

    }
}
