package zrj.study.test.java8book;

import zrj.study.test.java8.StreamTest;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/17
 */
public class FutureTest3 {

    public static void main(String[] args) {

//        CompletableFuture f1 = getFuture("f1");
//        CompletableFuture f2 = getFuture("f2");
//        f1.join();
//        f2.join();
//        System.out.println(123);


        // 这样不行......
//        List list1 = Stream.iterate(0, a -> a + 1).limit(10)
//                .map(a -> String.valueOf(a))
//                .map(a -> CompletableFuture.supplyAsync(
//                        () -> FutureTest2.map(a)
//                ))
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList());
//        System.out.println(list1);


        // 得这样
        Executor executor = Executors.newFixedThreadPool(8, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);          // 守护线程（如果不存在用户线程则退出）
            return t;
        });
        List<CompletableFuture> list2 = Stream.iterate(0, a -> a + 1).limit(10)
                .map(a -> String.valueOf(a))
                .map(a -> CompletableFuture.supplyAsync(
                        () -> FutureTest2.map(a),
                        executor// 默认executor只有几个线程
                ))
                .collect(Collectors.toList());
        System.out.println("异步执行完成");
        List list3 = list2.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(list3);
    }

    public static CompletableFuture getFuture(String name){
        return CompletableFuture.supplyAsync(() -> FutureTest2.map(name));
    }


}
