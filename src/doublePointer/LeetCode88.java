package doublePointer;

/**
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * @author lcl
 */

public class LeetCode88 {
    private static int CONS = 2;
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int fp = m - 1;
        int sp = n - 1;
        while (sp != -1){
            if(fp == -1) {
                for (int i = 0; i < m + n - sp - 1; i++) {
                    nums1[m + n - 1 - i] = nums1[m + n - 2 - sp - i];
                }
                if (sp + 1 >= 0) {
                    System.arraycopy(nums2, 0, nums1, 0, sp + 1);
                }
                break;
            }
            else if(nums1[fp] >= nums2[sp]){
                fp--;
            }
            else {
                for(int i = 0;i< m - fp + n - sp - CONS; i++){
                    nums1[m + n - sp - i - 1] = nums1[m  + n - sp - i - 2];
                }
                nums1[fp + 1] = nums2[sp];
                sp--;
            }
        }
    }
}
