package zrj.study.test.spring.event;

import org.springframework.context.annotation.Bean;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
public class Config {

    @Bean
    public SomeOne someOne() {
        return new SomeOne();
    }

    @Bean
    public SpeakNotifier speakNotifier() {
        return new SpeakNotifier();
    }
}
