package sort;

/**
 * 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the
 * sorted order, not the kth distinct element.
 *
 * @author lcl
 */

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length - k];
    }

    private static void quickSort(int[] nums, int begin, int end){
        if(begin <= end){
            int partition = partition(nums,begin,end);
            quickSort(nums,begin,partition-1);
            quickSort(nums,partition+1,end);
        }
    }

    private static int partition(int[] nums, int begin, int end){
        int determine = begin + 1;
        for(int i = determine; i<= end; i++){
            if(nums[begin] > nums[i]){
                int tmp = nums[determine];
                nums[determine] = nums[i];
                nums[i] = tmp;
                determine++;
            }
        }
        int tmp = nums[begin];
        nums[begin] = nums[determine -1];
        nums[determine -1 ] = tmp;
        return determine - 1;
    }
}
