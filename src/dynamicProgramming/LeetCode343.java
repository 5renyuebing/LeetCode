package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 343. Integer Break
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the
 * product of those integers. Return the maximum product you can get.
 *
 * @author lcl
 *
 * 动态规划： 状态转移公式F[n] = max{F[n-1], n-1, F[n-2]*2, (n-2)*2, F[n-3]*3, (n-3)*3, ......}
 * 即最后一步可能长度为[1, n]，对于该范围内的情况都要计算，并取max值
 */
public class LeetCode343 {
    public int integerBreak(int n) {
        int[] maxNum = new int[n + 1];
        for(int i = 2;i<= n;i++){
            List<Integer> choiseList = new ArrayList<>();
            choiseList.add(i - 1);
            for(int j = 2; j< i-1; j++){
                choiseList.add(j * maxNum[i - j]);
                choiseList.add(j * (i - j));
            }
            Collections.sort(choiseList);
            maxNum[i] = choiseList.get(choiseList.size() - 1);
        }
        return maxNum[n];
    }
}
