package dynamicProgramming;

/**
 * 213. House Robber II
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the
 * last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 * @author lcl
 *
 * 动态规划：当数组的最后一个元素position为n时，要想带上nums[n]，则不能带上nums[0]
 * 因此，F[n] = max{K[0,n-1], K[1, n]}，其中K表示无环的情况
 * 要分别保存去掉nums[0]和去掉nums[n]的tmp
 *
 * TODO: 检查测试用例为何出错，当前思路为分别使用动态规划计算K[0,n-1]和K[1,n]
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length == 3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }
        int tmpWithoutN2 = Math.max(nums[0], nums[1]);
        int tmpWithoutN1 = Math.max(nums[0] + nums[2], nums[1]);
        int tmpWithoutN = -1;
        int tmpWithoutZero1 = Math.max(nums[1],nums[2]);
        int tmpWithoutZero2 = nums[1];
        int tmpWithoutZero = -1;
        int tmp = -1;
        for(int i = 3;i< nums.length; i++){
            tmpWithoutZero2 += nums[i];
            tmpWithoutZero = Math.max(tmpWithoutZero1,tmpWithoutZero2);
            tmpWithoutN = tmpWithoutN1;
            tmp = Math.max(tmpWithoutN, tmpWithoutZero);
            tmpWithoutN2 += nums[i];
            tmpWithoutN1 = Math.max(tmpWithoutN1, tmpWithoutN2);
            tmpWithoutN2 = tmpWithoutN;
            tmpWithoutZero2 = tmpWithoutZero1;
            tmpWithoutZero1 = tmpWithoutZero;
        }
        return tmp;
    }
    public static void main(String[] args){
        LeetCode213 leetCode213 = new LeetCode213();
        System.out.println(leetCode213.rob(new int[]{4,1,2,7,5,3,1}));
    }
}
