package zrj.study.test.spring.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.test.spring.test.Config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
@Retention(RetentionPolicy.RUNTIME) // 很关键
@ContextConfiguration(classes = Config.class)
//@Transactional // 没有配置PlatformTransactionManager不能用
public @interface BaseTestConfiguration {
}
