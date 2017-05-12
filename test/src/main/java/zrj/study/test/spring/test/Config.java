package zrj.study.test.spring.test;

import org.springframework.context.annotation.Bean;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/12
 */
public class Config {

    @Bean
    public Person ben() {
        return new Person("ben");
    }

}
