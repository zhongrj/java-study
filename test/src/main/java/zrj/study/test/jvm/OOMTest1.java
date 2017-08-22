package zrj.study.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/4
 */
public class OOMTest1 {

    private int a;
    private int b;
    private char c;

    public static void main(String[] args) {
        List<OOMTest1> list = new ArrayList();
        int i = 1;
        while (true) {
//            System.out.println(i++);
            list.add(new OOMTest1());
            if (i == 500000) {
                System.out.println();
            }
        }
    }
}