package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test50 {
    public static void main(String[] args) {
        System.out.println(test(4));
    }

    private static List<List<String>> test(int n) {
        List<List<String>> result = new ArrayList<>();

        helper(result, new int[n][n], 0, n);

        return result;
    }

    private static void helper(List<List<String>> result, int[][] matrix, int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 2) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (matrix[row][j] == 0) {
                // 也可以用clone数组的办法,但是要用深度拷贝
                List<int[]> list = setInvalid(matrix, n, row, j);// 去除...
                matrix[row][j] = 2;
                helper(result, matrix, row + 1, n);
                matrix[row][j] = 0;
                recover(matrix, list);// 恢复...
            }
        }
    }

    private static void recover(int[][] matrix, List<int[]> list) {
        for (int[] ints : list) {
            matrix[ints[0]][ints[1]] = 0;
        }
    }

    private static List<int[]> setInvalid(int[][] matrix, int n, int row, int col) {
        List<int[]> list = new ArrayList<>();
        for (int i = row + 1, left, right; i < n; i++) {
            left = col + row - i;
            if (left >= 0) {
                if (matrix[i][left] == 0) {
                    list.add(new int[]{i, left});
                    matrix[i][left] = 1;
                }
            }
            right = col + i - row;
            if (right < n) {
                if (matrix[i][right] == 0) {
                    list.add(new int[]{i, right});
                    matrix[i][right] = 1;
                }
            }
            if (matrix[i][col] == 0) {
                list.add(new int[]{i, col});
                matrix[i][col] = 1;
            }
        }
        return list;
    }


}
