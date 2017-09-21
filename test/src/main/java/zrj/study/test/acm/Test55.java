package zrj.study.test.acm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test55 {
    public static void main(String[] args) {

        System.out.println(test(new ArrayList<>(Arrays.asList(new Interval[]{
                new Interval(2,5),
                new Interval(6,7),
                new Interval(8,9),
        })), new Interval(0, 10)));
    }

    private static List<Interval> test(List<Interval> intervals, Interval newInterval) {
        boolean overlap = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (overlap) {
                if (newInterval.end < interval.start) {
                    return intervals;
                } else {
                    newInterval.end = Math.max(newInterval.end, interval.end);
                    intervals.remove(i);
                    i--;
                }
            } else {
                if (newInterval.end < interval.start) {
                    intervals.add(i, newInterval);
                    return intervals;
                } else if (newInterval.start <= interval.end) {
                    overlap = true;
                    interval.start = Math.min(newInterval.start, interval.start);
                    interval.end = Math.max(newInterval.end, interval.end);
                    newInterval = interval;
                }
            }
        }

        if (!overlap) {
            intervals.add(newInterval);
        }
        return intervals;
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
