package dynamicProgramming;

import java.util.Arrays;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount
 * of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
 * have security system connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the
 * maximum amount of money you can rob tonight without alerting the police.
 *
 * @author  lcl
 */

public class LeetCode198 {
    public int rob(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        else {
            return Math.max(nums[nums.length - 1]+ rob(Arrays.copyOfRange(nums, 0, nums.length - 2)),
                    nums[nums.length -2] + rob(Arrays.copyOfRange(nums, 0,nums.length -3)));
        }
    }
    public static void main(String[] args){
        LeetCode198 leetCode198 = new LeetCode198();
        System.out.println(leetCode198.rob(new int[]{2,7,9,3,1,9}));
    }
}
