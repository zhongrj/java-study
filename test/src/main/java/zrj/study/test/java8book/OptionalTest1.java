package zrj.study.test.java8book;

import org.apache.ibatis.annotations.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/15
 */
public class OptionalTest1 {
    public static void main(String[] args) {
        Person person = new Person();
        Car car = new Car();
        car.insurance = new Insurance();
        person.car = car;
        Optional<String> name =
                Optional.of(person).map(Person::getCar)
                        .map(Car::getInsurance)
                        .map(Insurance::getName);
        System.out.println(name.get());

        Person person2 = new Person();
        String name2 =
                Optional.of(person2).map(Person::getCar)
                        .map(Car::getInsurance)
                        .map(Insurance::getName)
                        .orElse("12313");
        System.out.println(name2);

    }
}


class Person {
    public Car car;

    public Car getCar() {
        return car;
    }
}

class Car {
    public Insurance insurance;

    public Insurance getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name = "1";

    public String getName() {
        return name;
    }
}