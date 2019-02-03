package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 *
 * @author lcl
 */

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] markArray = new int[nums.length];
        if(nums.length != 0) {
            addResult(nums, markArray, new ArrayList<>(), result);
        }
        return result;
    }
    private static void addResult(int[] nums, int[] markArray, List<Integer> currentResult, List<List<Integer>> result){
        if(currentResult.size() == nums.length){
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
