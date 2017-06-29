package zrj.study.zzone.community.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/26
 */
@Configuration
@MapperScan(basePackages = "zrj.study.zzone.community.dao")
@ComponentScan(basePackages = {"zrj.study.zzone.community.service"})
public class CommunityConfig {
}
