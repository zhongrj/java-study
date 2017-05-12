package zrj.study.test.spring.aop;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/12
 */
public class Dog implements Animal {
    @Override
    public void walk() {
        System.out.println("A dog walking");
    }
}
