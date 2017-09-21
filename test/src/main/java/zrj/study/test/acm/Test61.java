package zrj.study.test.acm;

/**
 * 63. Unique Paths II
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test61 {
    public static void main(String[] args) {
        System.out.println(test(new int[][]{
                {0, 0, 1},
        }));
    }

    private static int test(int[][] obstacleGrid) {
        int m = obstacleGrid.length,
                n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        obstacleGrid[i][j] = 1;
                    } else if (i == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    } else if (j == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}
