package zrj.study.test.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext act2 = new AnnotationConfigApplicationContext(zrj.study.test.spring.event.Config.class);
        SomeOne someOne = act2.getBean(SomeOne.class);
        someOne.saySomething("1231123123");
    }
}
