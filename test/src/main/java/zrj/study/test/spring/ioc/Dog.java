package zrj.study.test.spring.ioc;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/10
 */
//@Component("wang1")
public class Dog extends Animal {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
