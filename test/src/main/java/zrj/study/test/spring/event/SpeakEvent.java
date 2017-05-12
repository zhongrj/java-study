package zrj.study.test.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
public class SpeakEvent extends ApplicationEvent {

    private String msg;

    public SpeakEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
