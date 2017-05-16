package zrj.study.util.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    // 不知道是否线程安全
    // 网上说是线程安全的
    private static final ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toJsonString(Object object) throws JsonProcessingException {
        return toJson(object);
    }

    private static String toJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <E> E parseToObject(String json, Class<E> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }
}

