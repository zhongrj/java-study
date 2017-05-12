package zrj.study.test.spring.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import zrj.study.test.spring.ioc.Person;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
public class MyValidate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (person.getAge() < 50) {
            System.out.println("不足50岁");
            errors.reject("age", "too young");
        }
    }
}
