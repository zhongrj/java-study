package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 68. Text Justification
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/21
 */
public class Test64 {
    public static void main(String[] args) {
        System.out.println(test(new String[]{"What","must","be","shall","be."}, 12));
    }


    // 垃圾题目，干
    private static List<String> test(String[] words, int maxWidth) {

        int i = 0;
        List<String> list = new LinkedList<>();
        List<String> result = new ArrayList<>();
        while (i < words.length) {
            String curr = words[i];
            int len = curr.length();
            do {
                list.add(curr);
                if (i++ == words.length - 1) {
                    break;
                }
                curr = words[i];
                len += 1 + curr.length();
            } while (len <= maxWidth);

            int slen = 0;
            if (list.size() > 1) {
                slen = (maxWidth - len + curr.length() + 1) / (list.size() - 1);
            }

            StringBuilder sb = new StringBuilder();
            sb.append(list.remove(0));

            if (i == words.length) {
                while (list.size() > 0) {
                    sb.append(" ");
                    sb.append(list.remove(0));
                }
            } else {
                if (list.size() > 0) {
                    sb.append(getNSpace((maxWidth - len + curr.length() + 1) % (list.size())));
                } else {
                    sb.append(getNSpace(maxWidth - sb.length()));
                }

                while (list.size() > 0) {
                    sb.append(getNSpace(slen + 1));
                    sb.append(list.remove(0));
                }
            }

            result.add(sb.toString());
        }
        return result;
    }

    private static String getNSpace(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
