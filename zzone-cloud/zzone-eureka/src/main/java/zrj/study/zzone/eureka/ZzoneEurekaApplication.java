package zrj.study.zzone.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/22
 */
@SpringBootApplication
@EnableEurekaServer
public class ZzoneEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZzoneEurekaApplication.class, args);
    }
}
