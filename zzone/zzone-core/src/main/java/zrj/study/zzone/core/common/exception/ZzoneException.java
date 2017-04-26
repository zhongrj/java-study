package zrj.study.zzone.core.common.exception;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
public class ZzoneException extends RuntimeException {

    public ZzoneException(String msg) {
        super(msg);
    }

    public ZzoneException(String msg, Exception e) {
        super(msg, e);
    }
}
