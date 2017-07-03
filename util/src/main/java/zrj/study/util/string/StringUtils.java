package zrj.study.util.string;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/26
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        return (str == null || "".equals(str));
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean equals(String str1, String str2) {
        return (str1 == null && str2 == null) || (str1 != null && str1.equals(str2));
    }

}
