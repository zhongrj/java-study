package zrj.study.test.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/4
 */
public class LambdaVar {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        final int[] a = {0};
        list.forEach((i) -> {
            System.out.println(i);
            System.out.println(a[0]++);
        });


    }

}
