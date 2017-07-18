package zrj.study.test.java8book;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/18
 */
public class StreamTest4 {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 100)
                .mapToObj(String::valueOf)
                .map(a -> {
                    System.out.println("1");
                    return a;
                })
//                .sorted(Comparator.comparingInt(String::hashCode)) // 会分隔上下的执行
                .map(a -> {
                    System.out.println("2");
                    return a;
                })
//                .sorted(Comparator.comparingInt(String::hashCode))
                .forEach(System.out::println);
    }

}
