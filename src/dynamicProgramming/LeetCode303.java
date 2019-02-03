package dynamicProgramming;

/**
 * 303. Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * @author lcl
 */

public class LeetCode303 {
    private int[] step;
    public LeetCode303(int[] nums) {
        int[] step = new int[nums.length];
        for(int i=0;i< nums.length; i++){
            int preStep = 0;
            if(i != 0){
                preStep = step[i - 1];
            }
            step[i] = preStep + nums[i];
        }
        this.step = step;
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return step[j];
        }
        else {
            return step[j] - step[i - 1];
        }
    }
}
