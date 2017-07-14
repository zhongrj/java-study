package zrj.study.test.java8book;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/5
 */
public class StreamTest2 {
    public static void main(String[] args) {
        String[] arrayOfWords = {"Goodbye", "World", "Goodbye"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

//        streamOfwords.forEach(System.out::println);

//        System.out.println(streamOfwords.anyMatch(a -> a.contains("g")));

        // findAny
//        streamOfwords.filter(a -> true).findAny().ifPresent(System.out::println);

        // findFirst
//        streamOfwords.findFirst().ifPresent(System.out::println);

        // reduce方法的使用
//        System.out.println(streamOfwords.reduce("1", (a, b) -> {
//            System.out.println(a);
//            System.out.println(b);
//            return a + b;
//        }));

        // 转换int流
//        streamOfwords.mapToInt(String::length).forEach(System.out::println);

        // 找勾股定理
//        int a = 8;
//        IntStream.rangeClosed(1, 100)
//                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
//                .forEach(o -> System.out.printf("%d, %d, %d\n", o[0], o[1], o[2]));

        // 无限流截断
//        Stream.iterate(0, a -> {
//            System.out.println(a);
//            return a+1;
//        }).limit(10).forEach(System.out::println);


        List<String> list = Arrays.asList("String1", "String2", "string3");
        list.stream()
                .map(String::hashCode)
                .sorted()
                .forEach(a -> {
                    System.out.println(a);
                });


    }

}
