package zrj.study.zzone.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import zrj.study.zzone.web.config.WebConfig;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/18
 */
@SpringBootApplication
@Import({WebConfig.class})
public class ZzoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzoneApplication.class, args);
    }

}
