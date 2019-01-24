package binarySearch;

/**
 * 540. Single Element in a Sorted Array
 * Given a sorted array consisting of only integers where every element appears twice except for one
 * element which appears once. Find this single element that appears only once.
 *
 * @author lcl
 */

public class LeetCode540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
