package zrj.study.test.acm;

import java.util.HashSet;
import java.util.Set;

/**
 * 60. Permutation Sequence
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test58 {
    public static void main(String[] args) {
        System.out.println(test(5, 4));
    }

    // 小问题，不想搞了，头炸了
    private static String test(int n, int k) {

        StringBuffer sb = new StringBuffer();
        Set<Integer> already = new HashSet<>();

        int m = 1, m$ = 1, temp;
        while ((temp = m$ * m) < k) {
            m$ = temp;
            m++;
        }

        while (true) {
            int i = 1;
            temp = m + 1;
            while (temp++ < n) {
                while (already.contains(i)) {
                    i++;
                }
                already.add(i);
                sb.append(i++);
            }
            i--;

            temp = (int) Math.ceil(1.0 * k / m$);
            while (temp-- > 0) {
                while (already.contains(++i)) {
                }
            }
            already.add(i);
            sb.append(i);

            k %= m$;

            if (k == 0) {
                i = n;
                while (i > 0) {
                    if (!already.contains(i)) {
                        sb.append(i);
                    }
                    i--;
                }
                break;
            }

            if (k == 1) {
                i = 1;
                while (i <= n) {
                    if (!already.contains(i)) {
                        sb.append(i);
                    }
                    i++;
                }
                break;
            }

            m = m - 1;
            while ((temp = m$ / m) > k) {
                m$ = temp;
                m--;
            }
            m$ = temp;
        }

        return sb.toString();

    }
}
