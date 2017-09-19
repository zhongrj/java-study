package zrj.study.test.acm;

import java.util.HashSet;
import java.util.Set;

/**
 * 45. Jump Game II
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/18
 */
public class Test44 {
    public static void main(String[] args) {
        System.out.println(test(new int[]{2,3,1,1,4}));
    }


    // 答案， 6666
    private static int answer(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    //
    private static int test(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int step = 0;
        Set<Integer> set1 = new HashSet<>(),
                set2 = new HashSet<>();
        set1.add(0);
        while (true) {
            for (int i : set1) {
                int limit = nums[i];
                if (i + limit >= nums.length - 1) {
                    return step;
                }
                int temp = limit;
                while (temp > 0) {
                    int target = i + temp;
                    if (limit < temp + nums[target]) {
                        set2.add(target);
                    }
                    temp--;
                }
            }

            step++;
            Set<Integer> temp = set1;
            set1 = set2;
            set2 = temp;
            set2.clear();
        }
    }

}
