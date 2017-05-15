package zrj.study.zzone.web.model;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
public class Result {

    /** 状体码 **/
    public static final String SUCCESS = "0000";
    public static final String FAILURE = "9999";

    /** 常用 **/
    public static final Result UNLOGIN = new Result("9998", "会话超时");
    public static final Result WRONG_DATA = new Result(FAILURE, "数据格式错误");
    public static final Result EXCEPTION = new Result(FAILURE, "系统异常");


    private String code;
    private String msg;
    private Object content;

    public Result() {
    }

    public Result(String code, String msg) {
        this(code, msg, null);
    }

    public Result(String code, String msg, Object content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
