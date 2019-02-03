package search;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author lcl
 */

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        addResult(candidates,target,new ArrayList<>(), 0, result);
        return result;
    }
    private static void addResult(int[] candidates, int target, List<Integer> currentNums, int currentResult, List<List<Integer>> result){
        if(currentResult > target){
            return;
        }
        else if(currentResult == target){
            Collections.sort(currentNums);
            if(!result.contains(currentNums)){
                result.add(currentNums);
            }
        }
        else {
            for(int num : candidates){
                List<Integer> newCurrentNums = new ArrayList<>(currentNums);
                newCurrentNums.add(num);
                int newResult = currentResult + num;
                addResult(candidates, target, newCurrentNums, newResult, result);
            }
        }
    }
    public static void main(String[] args){
        LeetCode39 leetCode39 = new LeetCode39();
        leetCode39.combinationSum(new int[]{2,3,7},7);
    }
}
