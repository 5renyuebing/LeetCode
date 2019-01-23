package greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 435. Non-overlapping Intervals
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 *
 * @author lcl
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class LeetCode435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        int result = 0;
        int end = intervals[0].start;
        for(Interval interval: intervals){
            if(interval.start < end){
                end = interval.start;
            }
        }
        int maxEnd = intervals[0].end;
        for(Interval interval: intervals){
            if(interval.end > maxEnd){
                maxEnd = interval.end;
            }
        }
        int min = maxEnd;
        Map<Interval,Integer> markMap = new HashMap<>(intervals.length);
        for(Interval interval : intervals){
            markMap.put(interval,1);
        }
        Interval next = null;
        for(int i = 0;i<intervals.length;i++) {
            for (Interval interval : intervals) {
                if (interval.start >= end && interval.end <= min && markMap.get(interval) != 0) {
                    min = interval.end;
                    next = interval;
                }
            }
                if (next != null) {
                    end = min;
                    min = maxEnd;
                    markMap.put(next, 0);
                    next = null;
                    result += 1;
                }
        }
        return intervals.length - result;
    }
    public static void main(String[] args){
        LeetCode435 leetCode435 = new LeetCode435();
        Interval[] a = new Interval[4];
        a[0] = new Interval(1,100);
        a[1] = new Interval(11,22);
        a[2] = new Interval(1,11);
        a[3] = new Interval(2,12);
        System.out.println(leetCode435.eraseOverlapIntervals(a));
    }
}
