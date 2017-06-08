package zrj.study.zzone.web.controller.aop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.web.model.Result;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/6
 */
@ControllerAdvice
//@ResponseBody
public class ExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler({ZzoneException.class})
    public Result handleServiceException(ZzoneException e) {
        if (null == e.getCause()) {
            logger.error(e.getMessage());
        } else {
            logger.error(e.getMessage(), e);
        }
        return new Result(Result.FAILURE, e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        logger.warn("参数校验不通过: {}", msg);
        return new Result(Result.FAILURE, msg);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result handleBindException(Exception e) {
        logger.warn("数据格式错误: {}", e.getMessage());
        return Result.WRONG_DATA;
    }

    @ExceptionHandler({Exception.class})
    public Result handleException(Exception e) {
        logger.error("未知错误", e);
        return Result.EXCEPTION;
    }

}
