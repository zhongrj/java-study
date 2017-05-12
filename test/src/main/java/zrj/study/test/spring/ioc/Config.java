package zrj.study.test.spring.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/10
 */
//@Configuration
//@ComponentScan
public class Config {

    @Bean({"ben", "SBben"})/*(initMethod = "init")*/
    public Person ben(@Value("${hello}")String hello, @Value("#{wang2.name}")String name2) {
        System.out.println(hello + " " + name2);
        Person person = new Person();
        person.setName("ben");
        person.setAge(15);
        return person;
    }

    @Bean
//    @Primary // 当多个注入冲突时优先选择
    public Dog wang1(@Value("#{@wang2}")Dog wang2) {
        System.out.println(wang2.getName());
        Dog dog = new Dog();
        dog.setName("旺财1");
        return dog;
    }

    @Bean
    public Dog wang2() {
        Dog dog = new Dog();
        dog.setName("旺财2");
        return dog;
    }

    @Bean// 想配置父类来着，好像不行
    public Animal animal() {
        Animal animal = new Animal(){};
        animal.setCanRun(true);
        return animal;
    }

    @Bean
    public Person jane(@Qualifier("wang2") Dog dog) { // 因为person里面配置了@Qualifier("wang1")所以这里被覆盖了
        Person person = new Person();
        person.setDog(dog);
        return person;
    }

    @Bean
    public PropertyPlaceholderConfigurer configurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(new ClassPathResource("config.properties"));
        propertyPlaceholderConfigurer.setFileEncoding("UTF-8");
        return propertyPlaceholderConfigurer;
    }



}
