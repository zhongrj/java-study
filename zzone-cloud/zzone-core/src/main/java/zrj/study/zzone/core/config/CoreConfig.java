package zrj.study.zzone.core.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/22
 */
@Configuration
@ComponentScan(basePackages = {"zrj.study.zzone.core"})
public class CoreConfig {

}
