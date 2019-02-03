package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 279. Perfect Squares
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * @author lcl
 *
 * 分割整数问题：两种思路：
 * 1.根据题目中提到的完全平方数最少，提取关键字“最少”，考虑最短路径问题，使用图的广度优先遍历求解最短路径问题。
 * 2.使用动态规划，寻找状态转移方程。该问题的最后一步求和，步长为[1,n]，因此状态转移方程为：num[n] = min(num[n], num[n-i**2] + 1)
 */

public class LeetCode279 {
    public int numSquares(int n) {
        int[] minStep = new int[n+1];
        for(int i = 1;i<=n;i++){

            if((int)Math.sqrt(i) * (int)Math.sqrt(i) == i){
                minStep[i] = 1;
            }
            else {
                List<Integer> numsList = new ArrayList<>();
                for(int j = 1;j<= Math.sqrt(i);j++){
                    numsList.add(minStep[i - j*j] + 1);
                }
                Collections.sort(numsList);
                minStep[i] = numsList.get(0);
            }
        }
        return minStep[n];
    }
    public static void main(String[] args){
        LeetCode279 leetCode279 = new LeetCode279();
        leetCode279.numSquares(12);
        System.out.println(Math.sqrt(11));
        System.out.println(Math.sqrt(11) * Math.sqrt(11) == 11);
    }
}
