package zrj.study.test.java8book;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/17
 */
public class FutureTest1 {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = () -> {
            if (true) {
                throw new RuntimeException("异常");
            }
            Thread.sleep(10000);
            return new Random().nextInt(100);
        };
        FutureTask<Integer> future = new FutureTask(callable);
        new Thread(future).start();
        System.out.println("dosomething");
        try {
            System.out.println(future.get(100000l, TimeUnit.MILLISECONDS));
        } catch (TimeoutException e) {
            System.out.println("超时");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("dosomething");
    }
}
