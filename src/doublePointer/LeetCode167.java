package doublePointer;

/**
  167. Two Sum II - Input array is sorted
  Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
  Note:
  Your returned answers (both index1 and index2) are not zero-based.
  You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * @author lcl
 */

public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        int lp = 0;
        int rp = numbers.length - 1;
        while (lp != rp){
            if(numbers[lp] + numbers[rp] == target){
                result[0] = lp + 1;
                result[1] = rp + 1;
                break;
            }
            else if(numbers[lp] + numbers[rp] < target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return result;
    }
}
