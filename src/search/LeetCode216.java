package search;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 216. Combination Sum III
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9
 * can be used and each combination should be a unique set of numbers.
 * Note:
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author lcl
 */

public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] markArray = new int[10];
        List<List<Integer>> result = new ArrayList<>();
        addResult(k,n,markArray, result,0,new ArrayList<>());
        return result;
    }
    private static void addResult(int k, int n, int[] markArray, List<List<Integer>> result, int currentSum, List<Integer> currentNums){
        if(currentSum > n || (currentNums.size() == k && currentSum != n)){
            return;
        }
        if(currentSum == n && currentNums.size() == k){
            Collections.sort(currentNums);
            if(!result.contains(currentNums)){
                result.add(currentNums);
            }
        }
        else {
            for(int i = 1; i< markArray.length; i++){
                if(markArray[i] == 0){
                    int[] newMarkArray = markArray.clone();
                    newMarkArray[i] = 1;
                    List<Integer> newNums = new ArrayList<>(currentNums);
                    newNums.add(i);
                    addResult(k,n,newMarkArray,result,currentSum + i, newNums);
                }
            }
        }
    }
}
