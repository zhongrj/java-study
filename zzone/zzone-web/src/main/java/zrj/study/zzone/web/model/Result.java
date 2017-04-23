package zrj.study.zzone.web.model;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
public class Result {


    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    /** 常用 **/
    public static final Result UNLOGIN = new Result(FAILURE, "会话超时");
    public static final Result EXCEPTION = new Result(FAILURE, "系统异常");



    private String status;
    private String msg;
    private Object content;

    public Result(String status, String msg) {
        this(status, msg, null);
    }

    public Result(String status, String msg, Object content) {
        this.status = status;
        this.msg = msg;
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
