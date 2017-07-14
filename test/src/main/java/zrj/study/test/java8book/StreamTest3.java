package zrj.study.test.java8book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/13
 */
public class StreamTest3 {
    public static void main(String[] args) {
        Stream<String> stream = Arrays.stream(new String[]{"Gbodyaa", "zxcliasdj", "12312"});

        // 收集器
//        List<String> list = stream.collect(Collectors.toList());
//        System.out.println(list);

//        Stream.iterate(0, a -> a + 124).limit(1000).parallel().filter(a -> {
//            System.out.println(a);
//            return a * a % 3 == 0;
//        }).sorted().forEach(System.out::println);

        // 关于并行
//        List temp = new ArrayList();
//        List list = Stream.iterate(0, a -> a + 1).limit(1000).filter(a -> {
//            temp.add(a);
//            return a % 3 == 0;
//        }).parallel().sorted().collect(Collectors.toList());
//        System.out.println(temp);
//        System.out.println(list);

    }
}
