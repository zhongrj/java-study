package zrj.study.util.string;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/26
 */
public class StringUtils {

    public static boolean isBlank(Object str) {
        return (str == null || "".equals(str));
    }

    public static boolean isNotBlank(Object str) {
        return !isBlank(str);
    }

}
