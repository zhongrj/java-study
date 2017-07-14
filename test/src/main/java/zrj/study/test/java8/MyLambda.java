package zrj.study.test.java8;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/3
 */
public class MyLambda {


    public static void main(String[] args) {
        MyLambda a = MyLambda.create(MyLambda::new);
        System.out.println(a);
    }

    public static MyLambda create(MySupplier<MyLambda> supplier) {
        return supplier.get();
    }

    private static interface MySupplier<T>{
        T get();
    }

}
