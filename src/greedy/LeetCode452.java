package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input
 * is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter
 * and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end.
 * There will be at most 104 balloons.
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart
 * and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows
 * that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum
 * number of arrows that must be shot to burst all balloons.
 *
 * @author lcl
 */

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }
        Map<int[],Integer> markMap = new HashMap<>(points.length);
        for(int[] point:points){
            markMap.put(point,1);
        }
        int begin = points[0][0] - 1;
        for(int[] point:points){
            if(begin > point[0] - 1){
                begin = point[0] - 1;
            }
        }
        int end = points[0][1] + 1;
        for(int[] point:points){
            if(end < point[1] + 1){
                end = point[1] + 1;
            }
        }
        int result = 0;
        int beginNum = begin;
        int endNum = end;
        int[] next = null;
        for(int i = 0;i<points.length;i++){
            for(int[] point:points){
                if(point[0] > beginNum && point[1] < endNum && markMap.get(point) != 0){
                    next = point;
                    endNum = point[1];
                }
            }
            if(next != null){
                result++;
                beginNum = next[1];
                markMap.put(next,0);
                endNum = end;
                next = null;
            }
            else {
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        LeetCode452 leetCode452 = new LeetCode452();
        int[][] a = {{1,2147483647}};
        System.out.println(leetCode452.findMinArrowShots(a));

    }
}
