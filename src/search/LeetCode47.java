package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * @author lcl
 */

public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] markArray = new int[nums.length];
        if(nums.length != 0) {
            addResult(nums, markArray, new ArrayList<>(), result);
        }
        return result;
    }
    private static void addResult(int[] nums, int[] markArray, List<Integer> currentResult, List<List<Integer>> result){
        if(currentResult.size() == nums.length && !result.contains(currentResult)){
            result.add(currentResult);
        }
        else {
            for(int i = 0;i<nums.length;i++){
                if(markArray[i] == 0){
                    int[] newMarkArray = markArray.clone();
                    newMarkArray[i] = 1;
                    List<Integer> newCurrentResult = new ArrayList<>(currentResult);
                    newCurrentResult.add(nums[i]);
                    addResult(nums, newMarkArray, newCurrentResult, result);
                }
            }
        }
    }
}
