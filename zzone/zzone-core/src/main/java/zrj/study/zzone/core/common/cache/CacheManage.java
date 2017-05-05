package zrj.study.zzone.core.common.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存管理
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/27
 */
public class CacheManage {

    // --------------------------------------- 本地缓存配置 ---------------------------------------

    private static final Map<String, Object> LOCAL_CACHE = new HashMap<>(); // 本地对象缓存

    private static Map getCache() {
        return LOCAL_CACHE;
    }


    // --------------------------------------- 本地线程变量 ---------------------------------------

    public static final ThreadLocal<String> SERIAL_NO = new ThreadLocal<>();
    public static final ThreadLocal<String> REQUEST_URI = new ThreadLocal<>();


    // --------------------------------------- 公共方法 ---------------------------------------

    public static Object get(String key) {
        return getCache().get(key);
    }

    public static void put(String key, Object e) {
        getCache().put(key, e);
    }

    public static void remove(String key) {
        getCache().remove(key);
    }

}
