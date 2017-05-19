package zrj.study.test.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/19
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext act = new AnnotationConfigApplicationContext(Config.class);
        Person person = act.getBean(Person.class);
//        person.insert();
        for (Person.Row row : person.getList()) {
            System.out.print(row.getId() + "\t");
            System.out.println(row.getName());
        }
    }

}
