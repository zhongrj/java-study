package zrj.study.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/7
 */
public class PermGenOOM1 {
    public static void main(String[] args) {
        int i = 0;
        List list = new ArrayList<>();
        while (true) {
            list.add(String.valueOf(i++).intern());
            if (false) {
                break;
            }
        }
        System.out.println(list);
    }
}
