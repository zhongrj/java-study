package zrj.study.test.acm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定数组、和，返回数组中两数之和等于给定和
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/28
 */
public class Test3 {
    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{1, 3, 4}, 4)).forEach(System.out::println);
    }

    private static int[] twoSum(int[] nums, int sum) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(sum - nums[i])) {
                result[0] = map.get(sum - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
