package zrj.study.test.spring.ioc;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/10
 */
public class Person extends Animal {

    private String name;
    private String gender;
    private int age;

//    @Autowired @Qualifier("wang1")
    @Resource(name = "wang1")
    private Dog dog;

    @PostConstruct
    public void init() {
        System.out.println("person init");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
