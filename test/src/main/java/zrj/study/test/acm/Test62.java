package zrj.study.test.acm;

/**
 * 64. Minimum Path Sum
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test62 {
    public static void main(String[] args) {
        System.out.println(test(new int[][]{
                {1, 2, 3},
                {3, 2, 3},
                {1, 2, 3},
        }));
    }

    private static int test(int[][] grid) {
        int m = grid.length,
                n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
