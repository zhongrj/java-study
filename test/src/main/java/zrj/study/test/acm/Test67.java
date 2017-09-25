package zrj.study.test.acm;

/**
 * ※※※※
 * TODO 好难
 * 72. Edit Distance
 * ※※※※
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/22
 */
public class Test67 {
    public static void main(String[] args) {
        System.out.println(minDistance("algorithm",
                "altruistic"));
    }



    // 不能这么做，用数组动态规划
    private static int minDistance(String word1, String word2) {

        if (word1.length() == 0) {
            return word2.length();
        }

        if (word2.length() == 0) {
            return word1.length();
        }

        if (word1.length() == 1) {
            return word2.contains(word1) ? word2.length() - 1 : word2.length();
        }

        if (word2.length() == 1) {
            return word1.contains(word2) ? word1.length() - 1 : word1.length();
        }

        if (word1.charAt(0) == word2.charAt(0)) {
            return minDistance(word1.substring(1), word2.substring(1));
        } else {
            if (word1.length() == word2.length()) {
                if (word1.charAt(1) == word2.charAt(1)) {
                    return 1 + minDistance(word1.substring(2), word2.substring(2));
                } else {
                    if (word1.charAt(0) == word2.charAt(1)) {
                        return 1 + minDistance(word1.substring(1), word2.substring(2));
                    } else if (word1.charAt(1) == word2.charAt(0)) {
                        return 1 + minDistance(word1.substring(2), word2.substring(1));
                    } else {
                        return 1 + minDistance(word1.substring(1), word2.substring(1));
                    }
                }
            } else if (word1.length() > word2.length()) {
                if (word1.charAt(1) == word2.charAt(1)) {
                    return 1 + minDistance(word1.substring(2), word2.substring(2));
                }
                return 1 + minDistance(word1.substring(1), word2);
            } else {
                if (word1.charAt(1) == word2.charAt(1)) {
                    return 1 + minDistance(word1.substring(2), word2.substring(2));
                }
                return 1 + minDistance(word1, word2.substring(1));
            }
        }

    }
}
