package zrj.study.zzone.web.common.aop.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import zrj.study.util.json.JsonUtils;
import zrj.study.zzone.core.common.cache.CacheManage;

import java.io.*;
import java.lang.reflect.Type;

/**
 * 请求日志切面
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/28
 */
@ControllerAdvice
public class LogRequestBodyAdvice implements RequestBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(LogRequestBodyAdvice.class);

    @Override

    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }


    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log(body);
        return body;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log(body);
        return body;
    }

    private void log(Object body) {
        try {
            logger.info("Request: {} | Params: {}", CacheManage.REQUEST_URI.get(), JsonUtils.toJsonString(body));
        } catch (Exception e) {
            logger.warn("请求日志异常", e);
        }
    }

}
