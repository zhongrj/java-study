package zrj.study.zzone.web.controller.aop.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import zrj.study.util.json.JsonUtils;
import zrj.study.zzone.core.common.cache.CacheManage;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/28
 */
@ControllerAdvice
public class LogResponseBodyAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(LogResponseBodyAdvice.class);


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log(body);
        return body;
    }

    private void log(Object body) {
        try {
            logger.info("SerialNo: {} | Response: {} | Result: {}", CacheManage.SERIAL_NO.get(), CacheManage.REQUEST_URI.get(), JsonUtils.toJsonString(body));
            CacheManage.SERIAL_NO.remove();
            CacheManage.REQUEST_URI.remove();
        } catch (Exception e) {
            logger.warn("响应日志异常", e);
        }
    }

}
