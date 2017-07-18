package zrj.study.test.java8book;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/17
 */
public class FutureTest2 {
    public static void main(String[] args) {
        List list = Arrays.asList("123", "321", "123124514", "abc", "cba", "adfadfa")
                .stream().parallel()
                .map(a -> map(a))
                .collect(Collectors.toList());

        System.out.println(list);
    }


    public static String map(String string) {
        try {
            int a = new Random().nextInt(10000);
            System.out.printf("%s, start----%d\n", string, a);
            Thread.sleep(a);
            System.out.printf("%s, end\n", string);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return string;
    }
}
