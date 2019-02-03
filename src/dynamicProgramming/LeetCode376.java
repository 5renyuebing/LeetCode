package dynamicProgramming;

import java.util.*;

/**
 * 376. Wiggle Subsequence
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate
 * between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence
 * with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and
 * negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences
 * are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is
 * obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining
 * elements in their original order.
 *
 * @author lcl
 */

public class LeetCode376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] wiggleLength = new int[nums.length];
        int[] lastIndex = new int[nums.length];
        wiggleLength[0] = 1;
        lastIndex[0] = -1;
        for(int i = 1;i< nums.length;i++){
            Map<Integer,Integer> resultMap = new HashMap<>();
            for(int j = i - 1;j>= 0;j--){
                if(lastIndex[j] == -1 && nums[i] != nums[j]){
                    resultMap.put(j, 2);
                }
                else if(lastIndex[j] == -1){
                    resultMap.put(-1, 1);
                }
                else {
                    int index = lastIndex[j];
                    if((nums[i] - nums[j]) * ( nums[j] - nums[index]) < 0){
                        resultMap.put(j, wiggleLength[j] + 1);
                    }
                }
            }
            int bestIndex = -1;
            int maxValue = -1;
            for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
                if(entry.getValue() > maxValue){
                    bestIndex = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            wiggleLength[i] = maxValue;
            lastIndex[i] = bestIndex;

        }
        Arrays.sort(wiggleLength);
        return wiggleLength[wiggleLength.length - 1];

    }
}
