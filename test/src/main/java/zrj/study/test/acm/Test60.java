package zrj.study.test.acm;

/**
 * 62. Unique Paths
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test60 {
    public static void main(String[] args) {
//        System.out.println(test(23, 12));
        System.out.println(test2(36, 7));
        System.out.println(test3(36, 7));
    }

    private static int test3(int m, int n) {
        m--;
        n--;
        if (m == 0 || n == 0) {
            return 1;
        }
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        int result = 1;
        for (int i = m + n, j = 1; i > m; i--) {
            result *= i;
            while (j <= n && result % j == 0) {
                result /= j++;
            }
        }
        return result;


//        return factorialn(m + n, m + 1) / factorialn(n, 1);// 分子一下就爆了
    }

    private static int factorialn(int n, int m) {
        if (n == m) {
            return m;
        }
        return n * factorialn(n - 1, m);
    }

    private static int test2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return test2(m - 1, n) + test2(m, n - 1);
    }

    private static int test(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        return helper(0, 0, matrix, m, n);
    }

    private static int helper(int i, int j, int[][] matrix, int m, int n) {

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        int count = 0;
//        if (j > 0 && matrix[i][j - 1] == 0) {
//            matrix[i][j - 1] = 1;
//            count += helper(i, j - 1, matrix, m, n);
//            matrix[i][j - 1] = 0;
//        }
        if (j < n - 1 && matrix[i][j + 1] == 0) {
            matrix[i][j + 1] = 1;
            count += helper(i, j + 1, matrix, m, n);
            matrix[i][j + 1] = 0;
        }
//        if (i > 0 && matrix[i - 1][j] == 0) {
//            matrix[i - 1][j] = 1;
//            count += helper(i - 1, j, matrix, m, n);
//            matrix[i - 1][j] = 0;
//        }
        if (i < m - 1 && matrix[i + 1][j] == 0) {
            matrix[i + 1][j] = 1;
            count += helper(i + 1, j, matrix, m, n);
            matrix[i + 1][j] = 0;
        }

        return count;

    }
}
