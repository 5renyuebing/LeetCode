package binarySearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * @author lcl
 *
 * 从小到大 0个元素 -> 1个元素 -> 2个元素 -> 3个元素 -> 更多元素
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = checkStartPointer(nums,target);
        if(start == -1){
            return result;
        }
        else {
            result[0] = start;
            result[1] = checkEndPointer(nums,target);
        }
        return result;
    }
    private static int checkStartPointer(int[] nums, int target){
        int sp = 0;
        int ep = nums.length - 1;
        int result = -1;
        while (sp <= ep){
            if(sp == ep){
                if(nums[sp] == target){
                    result = sp;
                    break;
                }
                else {
                    break;
                }
            }
            else {
                int mid = sp + (ep - sp) / 2;
                if(nums[mid + 1] < target){
                    sp = mid + 1;
                }
                else if(nums[mid + 1] > target){
                    ep = mid;
                }
                else {
                    if(nums[mid] != target){
                        result = mid + 1;
                        break;
                    }
                    else {
                        ep = mid;
                    }
                }
            }
        }
        return result;
    }
    private static int checkEndPointer(int[] nums, int target){
        int sp = 0;
        int ep = nums.length - 1;
        int result = -1;
        while (sp <= ep){
            if(sp == ep){
                if(nums[sp] == target){
                    result = sp;
                    break;
                }
            }
            else {
                int mid = sp + (ep - sp) / 2;
                if(nums[mid] < target){
                    sp = mid + 1;
                }
                else if(nums[mid] > target){
                    ep = mid - 1;
                }
                else {
                    if(nums[mid + 1] != target){
                        result = mid;
                        break;
                    }
                    else {
                        sp = mid + 1;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        LeetCode34 leetCode34 = new LeetCode34();
        leetCode34.searchRange(new int[]{5,7,7,8,8,10},6);
    }
}
