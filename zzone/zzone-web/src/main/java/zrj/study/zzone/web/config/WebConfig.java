package zrj.study.zzone.web.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import zrj.study.zzone.web.interceptor.AuthInterceptor;
import zrj.study.zzone.web.interceptor.LogInterceptor;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/18
 */
@Configuration
@ComponentScan(basePackages = {"zrj.study.zzone"})
@ConfigurationProperties(prefix = "spring")
public class WebConfig extends WebMvcConfigurerAdapter {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println(test);
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(authInterceptor()).addPathPatterns("/*")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/key/get")
                .excludePathPatterns("/test/*");
        super.addInterceptors(registry);
    }



}
