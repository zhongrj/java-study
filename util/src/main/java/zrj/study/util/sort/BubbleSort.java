package zrj.study.util.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序
 * @author zhongrj
 * @date 2017/4/18
 */
public class BubbleSort extends BaseSort {

    /**
     * @param array 数组
     */
    public static void sort(Comparable[] array) {
        int length = array.length;
        for (int start = 0, end = length; start < end - 1; end--) {
            for (int i = start + 1; i < end; i++) {
                if (compare(array[i - 1], array[i]) > 0) {
                    swap(array, i - 1, i);
                }
            }
        }
    }

    /**
     * @param list list
     * @param <E> 泛型
     */
    public static <E extends Comparable> void sort(List<E> list){
        int length = list.size();
        for (int start = 0, end = length; start < end - 1; end--) {
            for (int i = start + 1; i < end; i++) {
                if (compare(list.get(i - 1), list.get(i)) > 0) {
                    swap(list, i - 1, i);
                }
            }
        }
    }

    /**
     * 测试方法...
     */
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,5,4,2,4,3,5,9,5,1,6,7,3,5,7,16,5,7,12,5,74,1,2,45,4};
        sort(a);
        print(a);
        System.out.println();
        List<Integer> b = Arrays.asList(a);
        sort(b);
        print(b);
    }
}
