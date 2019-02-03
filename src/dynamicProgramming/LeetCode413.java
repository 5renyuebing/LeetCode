package dynamicProgramming;

/**
 * 413. Arithmetic Slices
 * A sequence of number is called arithmetic if it consists of at least three elements and if the
 * difference between any two consecutive elements is the same.
 *
 * @author lcl
 *
 * 动态规划： F[n] 与 F[n-1] 和 F[n-m] 相关, F[n-m] 可以通过两个相同元素查找
 */

public class LeetCode413 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3){
            return 0;
        }
        int[] step = new int[A.length];
        for(int i = 2; i< A.length; i++){
            step[i] = step[i-1];
            if(A[i] - A[i - 1] == A[i-1] -A[i-2]){
                int begin = 0;
                for(int j = i-1; j>=0 ; j--){
                    if(step[j] == step[j-1]){
                        begin = j;
                        break;
                    }
                }
                int length = i - begin + 2;
                step[i] += (length - 2);
            }
        }
        return step[A.length - 1];
    }
    public static void main(String[] args){
        LeetCode413 leetCode413 = new LeetCode413();
        leetCode413.numberOfArithmeticSlices(new int[]{1,2,3,5,7,8,9,10});
    }
}
