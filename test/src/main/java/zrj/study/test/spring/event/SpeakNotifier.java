package zrj.study.test.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
public class SpeakNotifier {

    @EventListener(SpeakEvent.class)
    public void onApplicationEvent(SpeakEvent event) {
        System.out.println("some one say " + event.getMsg());
    }

}
