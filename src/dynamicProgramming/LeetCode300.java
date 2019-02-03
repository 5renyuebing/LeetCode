package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 300. Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * @author lcl
 */

public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] length = new int[nums.length];
        for(int i = 0;i< length.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = i-1;j > -1;j--){
                if(nums[i] > nums[j]){
                    list.add(length[j] + 1);
                }
            }
            if(list.size() == 0){
                length[i] = 1;
            }
            else {
                Collections.sort(list);
                length[i] = list.get(list.size() - 1);
            }
        }
        Arrays.sort(length);
        return length[length.length - 1];
    }
    public static void main(String[] args){
        LeetCode300 leetCode300 = new LeetCode300();
        leetCode300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
