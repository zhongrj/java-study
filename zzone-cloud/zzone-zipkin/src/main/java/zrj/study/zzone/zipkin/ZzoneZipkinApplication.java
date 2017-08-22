package zrj.study.zzone.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/24
 */
@SpringBootApplication
@EnableZipkinServer
public class ZzoneZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZzoneZipkinApplication.class, args);
    }
}
