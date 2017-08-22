package zrj.study.zzone.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/24
 */
@SpringBootApplication
@EnableEurekaClient // 注册服务
public class ZzoneRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZzoneRibbonApplication.class, args);
    }


}
