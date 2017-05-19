package zrj.study.test.java;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/16
 */
public class Outer {

    public void out() {

    }

    private class Inner {
        public void out() {

        }

        public void in() {
            this.out();// 内部类的方法
            Outer.this.out();// 外部类的方法
        }
    }
}
