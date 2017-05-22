package zrj.study.test.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/22
 */
public class StreamTest {

    @Test
    public void test1() {
        Collection<Person> list = Arrays.asList(
                new Person("1", "ben1"),
                new Person("2", "ben2"),
                new Person("3", "ben3")
        );
        list.stream()
                .filter(person -> Integer.parseInt(person.id) > 1)
                .forEach(person -> System.out.println(person.name));

        int sum = list.stream()
                .filter(person -> person.name.contains("ben"))
                .mapToInt(person -> Integer.parseInt(person.id))
                .sum();
        System.out.println(sum);
    }

    private static class Person{
        String id;
        String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

}
