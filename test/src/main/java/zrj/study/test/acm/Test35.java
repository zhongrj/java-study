package zrj.study.test.acm;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/11
 */
public class Test35 {
    public static void main(String[] args) {
        System.out.println(test(new char[][]{{}}));
    }

    private static boolean test(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if ('.' == c) {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }

        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if ('.' == c) {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }


        return subValid(board, 0, 0);
    }

    private static boolean subValid(char[][] board, int i0, int j0) {
        if (i0 == 9) {
            return true;
        }

        Set<Character> set = new HashSet<>();
        for (int i = i0; i < i0 + 3; i++) {
            for (int j = j0; j < j0 + 3; j++) {
                char c = board[i][j];
                if ('.' == c) {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }

        j0 = (j0 + 3) % 9;
        if (j0 == 0) {
            i0 += 3;
        }
        return subValid(board, i0, j0);
    }
}
