package zrj.study.test.spring.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
@Configuration
@EnableWebMvc
@ComponentScan("zrj.study.test.spring.springmvc")
public class Config extends WebMvcConfigurerAdapter {

}
