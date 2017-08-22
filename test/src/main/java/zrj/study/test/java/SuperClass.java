package zrj.study.test.java;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/16
 */
public class SuperClass {


    static {
        a = 1; // 可以赋值
//        System.out.println(a);// 不能访问
        System.out.println("SuperClass");
    }
    static int a = 0;

    static class SubClass extends SuperClass {

//        static int a = 0;
        static {
            System.out.println("SuperClass");
        }
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println(SuperClass.SubClass.a);

        SuperClass.SubClass[] s = new SuperClass.SubClass[10];
//        System.out.println();
    }
}