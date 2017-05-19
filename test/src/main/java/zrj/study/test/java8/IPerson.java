package zrj.study.test.java8;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/16
 */
public interface IPerson {
    default void work() {
        System.out.println("是人就能工作");
    }
}

interface IAnimal{
    default void walk() {
        System.out.println("是动物就能走路");
    }
}



class Person implements IPerson, IAnimal { // java8可以多继承了..
    public static void main(String[] args) {
        Person p = new Person();
        p.work();
        p.walk();
    }
}