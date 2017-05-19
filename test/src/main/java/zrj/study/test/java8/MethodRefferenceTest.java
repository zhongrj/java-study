package zrj.study.test.java8;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/19
 */
public class MethodRefferenceTest {

    @Test
    public void test() {
        Car car = Car.create(Car::new); // 传入构造方法
        List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::boom);
        cars.forEach(Car::repair);
        Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}

class Car{
    public static Car create(Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void boom(Car car) {
        System.out.println(car.toString() + " boom~");
    }

    public void follow(Car car) {
        System.out.println(this.toString() + " following " + car.toString());
    }

    public void repair() {
        System.out.println(this.toString() + " being repaired");
    }
}
