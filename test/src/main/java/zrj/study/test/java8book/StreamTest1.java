package zrj.study.test.java8book;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/5
 */
public class StreamTest1 {
    public static void main(String[] args) {

        List<Entity> list = new ArrayList<>();
        list.add(new Entity(new String("12"), "1"));
        list.add(new Entity(new String("12"), "2"));
        list.add(new Entity("xzcvzxv", "3"));
//        list.forEach(System.out::println);

        List list2 = list.stream().filter(entity -> entity.getId().contains("1")).collect(toList());
        System.out.println(list2);

        List<String> list3 = list.stream().map(Entity::getId).collect(toList());
        System.out.println(list3);

        list.stream().distinct().forEach(System.out::println);
        list.stream().map(Entity::getId).distinct().forEach(System.out::println);

    }
}
