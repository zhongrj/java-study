package zrj.study.zzone.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/22
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZzoneZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZzoneZuulApplication.class, args);
    }
}
