package zrj.study.test.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
public class SomeOne implements ApplicationEventPublisherAware{

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void saySomething(String msg) {
        publisher.publishEvent(new SpeakEvent(this, msg));
//        System.out.println("someone say msg");
    }

}
