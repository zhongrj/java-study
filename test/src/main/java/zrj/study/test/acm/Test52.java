package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test52 {
    public static void main(String[] args) {
        System.out.println(test(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }));
    }

    private static List<Integer> test(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) {
            return result;
        }

        int[][] direction = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0}
        };

        int[] d = direction[0];

        int RStart = -1, CStart = -1, REnd = matrix.length, CEnd = matrix[0].length, i = 0, j = 0;
        while (RStart + 1 != REnd && CStart + 1 != CEnd) {

            result.add(matrix[i][j]);

            i += d[0];
            j += d[1];

            if (j == CEnd) {
                d = direction[1];
                RStart++;
                i++;
                j--;
            } else if (i == REnd) {
                d = direction[2];
                CEnd--;
                i--;
                j--;
            } else if (j == CStart) {
                d = direction[3];
                REnd--;
                i--;
                j++;
            } else if (i == RStart) {
                d = direction[0];
                CStart++;
                i++;
                j++;
            }
        }


        return result;
    }
}
