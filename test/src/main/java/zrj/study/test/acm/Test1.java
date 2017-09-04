package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-9 中间填+、-或什么都不填（前后合并）得出和为100的所有可能
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/25
 */
public class Test1 {

    public static void main(String[] args) {
        findSum(100, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    private static void findSum(int sum, int... array) {
        String a = "123456789";
        int totalFlags = 1 << array.length - 1;
        int currFlags = 0;
        while (currFlags < totalFlags) {
            int currCut = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < array.length - 1; i++) {
                if ((currFlags >> i) % 2 == 0) {
                    list.add(Integer.parseInt(a.substring(currCut, i + 1)));
                    currCut = i + 1;
                }
            }
            list.add(Integer.parseInt(a.substring(currCut)));
            int[] arrayMeaged = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arrayMeaged[i] = list.get(i);
            }
            plusOrMiner(sum, arrayMeaged);
            currFlags++;
        }
    }

    private static void plusOrMiner(int sum, int[] array) {
        int totalFlags = 1 << array.length - 1;
        int currFlags = 0;
        while (currFlags < totalFlags) {
            int sumTmp = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                sumTmp += array[i + 1] * (2 * ((currFlags >> i) % 2) - 1);
            }
            if (sumTmp == sum) {
                System.out.print(array[0]);
                for (int i = 0; i < array.length - 1; i++) {
                    System.out.print((currFlags >> i) % 2 == 1 ? " + " : " - ");
                    System.out.print(array[i + 1]);
                }
                System.out.println(" = " + sum);
            }
            currFlags++;
        }
    }


}
