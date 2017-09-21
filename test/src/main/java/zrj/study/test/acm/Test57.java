package zrj.study.test.acm;

/**
 * 59. Spiral Matrix II
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test57 {
    public static void main(String[] args) {
        Test47.print(test(3));
    }

    private static int[][] test(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }

        int[][] ds = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0},
        };
        int i = 0, j = 0, dn = 0, a = 1, end = n * n;
        int[] d = ds[dn];
        while (true) {

            result[i][j] = a++;

            if (a == end + 1) {
                break;
            }

            i += d[0];
            j += d[1];

            if (i < 0 || j < 0 || i > n - 1 || j > n - 1 || result[i][j] != 0) {
                i -= d[0];
                j -= d[1];
                dn = (dn + 1) % 4;
                d = ds[dn];
                i += d[0];
                j += d[1];
            }
        }

        return result;
    }

}
