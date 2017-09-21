package zrj.study.test.acm;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 56. Merge Intervals
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/19
 */
public class Test54 {
    public static void main(String[] args) {
        System.out.println(test(Arrays.asList(new Interval[]{
                new Interval(1, 3),
                new Interval(2,6),
                new Interval(8, 10),
                new Interval(15, 18),
        })));
    }

    private static List<Interval> test(List<Interval> intervals) {

        intervals = intervals.stream().sorted(Comparator.comparingInt(i -> i.start)).collect(Collectors.toList());

        List<Interval> result = new ArrayList<>();
        Interval temp = null;
        for (Interval interval : intervals) {
            if (temp != null) {
                if (temp.end >= interval.start && temp.start <= interval.end) {
                    if (temp.end < interval.end) {
                        temp.end = interval.end;
                    }
                    if (temp.start > interval.start) {
                        temp.start = interval.start;
                    }
                } else {
                    result.add(temp);
                    temp = interval;
                }
            } else {
                temp = interval;
            }
        }
        if (temp != null) {
            result.add(temp);
        }
        return result;
    }

    private static boolean isCollide(Interval temp, Interval interval) {
        return temp.end > interval.start && temp.start < interval.end;
    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return String.format("[%s, %s]", start, end);
        }
    }
}
