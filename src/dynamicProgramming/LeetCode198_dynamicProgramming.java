package dynamicProgramming;

/**
 * 使用动态规划求解：自下而上求解
 *
 * 递归：自上而下
 *
 * 解法：动态规划自下而上，状态转移公式为：F(n) = max{F(n-1), F(n-2)+nums[n]}，即：
 * a = nums[0]
 * b = max{nums[0], nums[1]}
 * c = max{b, a+nums[2]}
 * d = max{c, b+nums[3]}
 * e = max{d, c+nums[4]}
 * 所以需要记录当前状态的前两个状态，分别用tmp1和tmp2表示，tmp1表示前一个状态，tmp2表示前两个状态
 * 每次迭代开始前，将tmp2与当前position对应的num相加，求max得出tmp，再更新状态
 * 更新状态时，刚刚得出的tmp对于下一状态来说是tmp1，而此前的tmp1再向前推一步，成为tmp2
 *
 * @author lcl
 */
public class LeetCode198_dynamicProgramming {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int tmp2 = nums[0];
        int tmp1 = Math.max(nums[0], nums[1]);
        int tmp = 0;
        for(int i = 2;i< nums.length; i++){
            tmp2 = tmp2 + nums[i];
            tmp = Math.max(tmp1, tmp2);
            tmp2 = tmp1;
            tmp1 = tmp;
        }
        return tmp;
    }
    public static void main(String[] args){
        LeetCode198_dynamicProgramming leetCode198_dynamicProgramming = new LeetCode198_dynamicProgramming();
        int a = leetCode198_dynamicProgramming.rob(new int[] {1,3,1,3,100});
        System.out.println(a);
    }
}
