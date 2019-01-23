package sort;

/**
 * 75. Sort Colors
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the
 * same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * @author lcl
 */

public class LeetCode75 {
    public void sortColors(int[] nums) {
        int one = 0;
        int two = nums.length-1;
        int check = 0;
        while (check <= two){
            if(nums[check] == 0){
                int tmp = nums[one];
                nums[one] = nums[check];
                nums[check] = tmp;
                one++;
                check++;
            }
            else if(nums[check] == 2){
                int tmp = nums[two];
                nums[two] = nums[check];
                nums[check] = tmp;
                two--;
            }
            else if(nums[check] == 1){
                check++;
            }
        }
    }
    public static void main(String[] args){
        LeetCode75 leetCode75 = new LeetCode75();
        int[] a = {2,0,1};
        leetCode75.sortColors(a);
    }
}
