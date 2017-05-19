package zrj.study.test.collection;

import java.util.*;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/16
 */
public class Test {

    @org.junit.Test
    public void arrayCopy() {
        int[] a = new int[]{0,2,1,3,54,1,12};
        int[] b = new int[4];

        System.arraycopy(a, 1, b, 0, 3);
        for (int c : b) {
            System.out.println(c);
        }
    }

    @org.junit.Test
    public void testArrayClass() {
        Object[] a = new Object[10];
        a = new String[10];
        System.out.println(a.getClass() == String[].class);
        System.out.println(a.getClass() == Object[].class);
        Object[] b = Arrays.copyOf(a, a.length, Object[].class);
        System.out.println(b.getClass() == Object[].class);
    }


    @org.junit.Test
    public void arrayListTest() {
        ArrayList list = new ArrayList();
        list.add(1);

        List list1 = (List) list.clone();
        list1.add(2);
        for (Object i : list1) {
            System.out.println(i);
        }

        List list2 = new ArrayList(10);
        list2.set(0, 1);// 只能在size内赋值，虽然elementData.length>2            ArrayList里面的size和elementData.length的区别
//        list2.get(-1);

    }


    @org.junit.Test
    public void vectorTest() {
        Vector list = new Vector();
        list.add(1);
        System.out.println(list.get(0));
        System.out.println(list.capacity());

        Enumeration enumeration = list.elements();
        if (enumeration.hasMoreElements()) {
//            list.remove(0);           // 这样搞也不安全
            System.out.println(enumeration.nextElement());
        }

        System.out.println(list.toArray().length);
    }

    @org.junit.Test
    public void linkedListTest() {
        List list = new LinkedList();
        list.add(1);
        list.get(0);
        list.stream();
        list.forEach(e -> System.out.println(e));
    }


    @org.junit.Test
    public void hashMapTest() {
        Map map = new HashMap();

    }

}
