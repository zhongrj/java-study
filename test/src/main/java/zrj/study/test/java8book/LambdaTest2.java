package zrj.study.test.java8book;

import java.util.function.Function;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/4
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        LambdaTest2 l = new LambdaTest2();
        System.out.println((l.test(Object::toString)));
    }

    public <R> R test(Function<LambdaTest2, R> function) {
        return function.apply(this);
    }
}
