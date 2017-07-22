package zrj.study.zzone.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import zrj.study.zzone.core.config.CoreConfig;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/22
 */
@SpringBootApplication
@EnableEurekaClient // 注册服务
@Import({CoreConfig.class})
public class ZzoneCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzoneCoreApplication.class, args);
    }
}
