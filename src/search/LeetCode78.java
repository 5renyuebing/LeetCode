package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * @author lcl
 */

public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        addResult(nums,0,result,new ArrayList<>());
        return result;
    }
    private static void addResult(int[] nums, int position, List<List<Integer>> result,List<Integer> currentNums){
        if(position == nums.length){
            return;
        }
        List<Integer> numsAddCurrentNum = new ArrayList<>(currentNums);
        List<Integer> numsWithoutCurrentNum = new ArrayList<>(currentNums);
        numsAddCurrentNum.add(nums[position]);
        if(!result.contains(numsAddCurrentNum)){
            result.add(numsAddCurrentNum);
        }
        if(!result.contains(numsWithoutCurrentNum)){
            result.add(numsWithoutCurrentNum);
        }
        addResult(nums,position+1,result,numsAddCurrentNum);
        addResult(nums,position+1,result,numsWithoutCurrentNum);
    }
}
