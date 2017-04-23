package zrj.study.util.sort;

import java.util.List;

/**
 * @author zhongrj@yonyou.com
 * @date 2017/4/18
 * @company 友金所
 */
public class BaseSort {

    /**
     * 交换数组中的两个对象
     * @param array 对象所在数组
     * @param i 对象1下标
     * @param j 对象2下标
     */
    public static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 交换list中的两个对象
     * @param list 对象所在list
     * @param i 对象1下标
     * @param j 对象2下标
     * @param <E> 泛型
     */
    public static <E> void swap(List<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * 比较两个对象
     * @param a 对象1
     * @param b 对象2
     * @return a - b
     */
    public static int compare(Comparable a, Comparable b) {
        if (a != null) {
            return a.compareTo(b);
        }
        if (b != null) {
            return -b.compareTo(a);
        }
        return 0;
    }

    /**
     * 打印数组
     * @param array 数组
     */
    public static void print(Object[] array) {
        for (Object o : array) {
            System.out.printf("%s ", o);
        }
    }

    /**
     * 打印list
     * @param list list
     * @param <E> 泛型
     */
    public static <E> void print(List<E> list) {
        for (E e : list) {
            System.out.printf("%s ", e);
        }
    }


}
