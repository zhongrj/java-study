package zrj.study.test.acm;

/**
 * 73. Set Matrix Zeroes
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/25
 */
public class Test68 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 0, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1}
        };
        test(matrix);
        Test47.print(matrix);
    }

    private static void test(int[][] matrix) {
        helper(matrix, 0, 0);
    }

    private static void helper(int[][] matrix, int i, int j) {
        if (j == matrix[i].length) {
            i++;
            j = 0;
        }
        if (i == matrix.length) {
            return;
        }

        if (matrix[i][j] == 0) {
            helper(matrix, i, j + 1);
            setRowAndColZero(matrix, i, j);
        } else {
            helper(matrix, i, j + 1);
        }
    }

    private static void setRowAndColZero(int[][] matrix, int i, int j) {
        for(int k = 0; k < matrix[i].length; k++) {
            matrix[i][k] = 0;
        }
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }
}
