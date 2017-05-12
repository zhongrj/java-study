package zrj.study.test.spring.aop;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void say(String msg) {
        System.out.println(name + " say " + msg);
    }

    public void walk(int distance) {
        System.out.println(name + " walk " + distance + " meter !");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
