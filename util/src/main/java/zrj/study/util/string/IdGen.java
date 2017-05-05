package zrj.study.util.string;

import java.util.UUID;

/**
 * id生成器
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/5
 */
public class IdGen {

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
