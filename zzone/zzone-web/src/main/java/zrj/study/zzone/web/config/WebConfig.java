package zrj.study.zzone.web.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import zrj.study.zzone.community.config.CommunityConfig;
import zrj.study.zzone.core.common.config.CoreConfig;
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
@Import({CoreConfig.class, CommunityConfig.class})
@ComponentScan(basePackages = {"zrj.study.zzone.web.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/test/**")
                .excludePathPatterns("/core/user/login")
                .excludePathPatterns("/core/user/register")
                .excludePathPatterns("/core/key/get")
                .excludePathPatterns("/core/code/get")
                .excludePathPatterns("/core/upload/image")                   // temp
                .excludePathPatterns("/core/download/image")                 // temp
                .excludePathPatterns("/core/option/get");
        super.addInterceptors(registry);
    }

    @Bean
    public FilterRegistrationBean characterEncodingFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CharacterEncodingFilter("UTF-8"));
        return filterRegistrationBean;
    }


}
