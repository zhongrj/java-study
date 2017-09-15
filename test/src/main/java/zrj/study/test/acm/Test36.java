package zrj.study.test.acm;

import java.util.HashSet;
import java.util.Set;

/**
 * 37. Sudoku Solver
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/12
 */
public class Test36 {
    public static void main(String[] args) {
        test(new char[][]{});
    }

    private static void test(char[][] board) {
        helper(board, 0, 0);
    }

    private static boolean helper(char[][] board, int i, int j) {

        if (j == 9) {
            i++;
            j = 0;
        }

        if (i == 9) {
            return true;
        }

        if (board[i][j] != '.') {
            return helper(board, i, j + 1);
        }

        Set<Character> set = getSet(board, i, j);
        for (int k = 1; k < 10; k++) {
            if (set.contains(intToChar(k))) {
                continue;
            }
            board[i][j] = intToChar(k);
            if (helper(board, i, j+1)) {
                return true;
            }
        }
        board[i][j] = '.';
        return false;
    }

    private static Set<Character> getSet(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int j1 = 0; j1 < 9; j1++) {
            set.add(board[i][j1]);
        }
        for (int i1 = 0; i1 < 9; i1++) {
            set.add(board[i1][j]);
        }
        i = i / 3 * 3;
        j = j / 3 * 3;
        int iend = i + 3,
                jstart = j,
                jend = j + 3;
        while (i < iend) {
            j = jstart;
            while (j < jend) {
                set.add(board[i][j]);
                j++;
            }
            i++;
        }
        return set;
    }


    private static char intToChar(int n) {
        return (char) (n + 48);
    }

    private static boolean valid(char[][] board, int i, int j, char k) {
        for (int j1 = 0; j1 < 9; j1++) {
            if (board[i][j1] == k) {
                return false;
            }
        }
        for (int i1 = 0; i1 < 9; i1++) {
            if (board[i1][j] == k) {
                return false;
            }
        }
        i = i / 3 * 3;
        j = j / 3 * 3;
        int iend = i + 3,
                jstart = j,
                jend = j + 3;
        while (i < iend) {
            j = jstart;
            while (j < jend) {
                if (board[i][j] == k) {
                    return false;
                }
                j++;
            }
            i++;
        }
        return true;
    }


}
