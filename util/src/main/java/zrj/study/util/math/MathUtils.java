package zrj.study.util.math;

/**
 * 数学工具类
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/21
 */
public class MathUtils {

    /**
     * 递归法求最大公约数
     * @author 来源网络 http://blog.csdn.net/lwcumt/article/details/8029241
     * @param m 第一个数
     * @param n 第二个数
     * @return 最大公约数
     */
    public static long maxCommonDivisor(long m, long n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            long temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {// 若余数为0,返回最大公约数
            return n;
        } else { // 否则,进行递归,把n赋给m,把余数赋给n
            return maxCommonDivisor(n, m % n);
        }
    }

    /**
     * 求最小公倍数
     * @author 来源网络 http://blog.csdn.net/lwcumt/article/details/8029241
     * @param m 第一个数
     * @param n 第二个数
     * @return 最小公倍数
     */
    public static long minCommonMultiple(long m, long n) {
        return m * n / maxCommonDivisor(m, n);
    }

}
