package zrj.study.test.acm;

/**
 * 48. Rotate Image
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test47 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };
        int[][] matrix2 = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16},
        };
        test(matrix);
        print(matrix);
    }

    private static void test(int[][] matrix) {
        int length = matrix.length - 1,
                temp;
        double quarter = length / 2.0;

        for (int i = 0; i <= quarter; i++) {
            for (int j = 0; j < quarter; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[length - j][i];
                matrix[length - j][i] = matrix[length - i][length - j];
                matrix[length - i][length - j] = matrix[j][length - i];
                matrix[j][length - i] = temp;
            }
        }
    }


    private static void print(int[][] matrix) {
        System.out.println("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  [");
            int[] row = matrix[i];
            if (row.length > 0) {
                System.out.printf("%s", row[0]);
                for (int j = 1; j < row.length; j++) {
                    System.out.printf(", %s", row[j]);
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

}
