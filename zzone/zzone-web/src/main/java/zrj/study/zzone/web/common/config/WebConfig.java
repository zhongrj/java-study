package zrj.study.zzone.web.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import zrj.study.zzone.web.interceptor.AuthInterceptor;
import zrj.study.zzone.web.interceptor.LogInterceptor;

/**
 * Web层配置
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/18
 */
@Configuration
@ComponentScan(basePackages = {"zrj.study.zzone"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(authInterceptor()).addPathPatterns("/*")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/key/get")
                .excludePathPatterns("/test/*")
                .excludePathPatterns("/code/get");
        super.addInterceptors(registry);
    }


}
