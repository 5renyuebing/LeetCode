package greedy;

/**
 * 455. Assign Cookies
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at
 * most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be
 * content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the
 * child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 *
 * @author lcl
 */

public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        quickSort(g,0,g.length -1);
        quickSort(s,0,s.length -1 );
        for(int child : g){
            for(int i = 0;i<s.length;i++){
                if(s[i] >= child){
                    result++;
                    s[i] = -1;
                    break;
                }
            }
        }
        return result;
    }
    private static void quickSort(int[] nums,int begin, int end){
        if(begin < end){
            int partition = partition(nums,begin,end);
            quickSort(nums,begin,partition-1);
            quickSort(nums,partition+1,end);
        }
    }
    private static int partition(int[] nums,int begin, int end){
        int benchmark = begin;
        begin++;
        for(int i = begin;i<=end;i++){
            if(nums[i] < nums[benchmark]){
                int tmp = nums[begin];
                nums[begin] = nums[i];
                nums[i] = tmp;
                begin++;
            }
        }
        int tmp = nums[begin -1];
        nums[begin - 1] = nums[benchmark];
        nums[benchmark] = tmp;
        return begin -1;
    }
    public static void main(String[] aegs){
        LeetCode455 leetCode455 = new LeetCode455();
        int[] a = {1,2,3};
        int[] b = {1,1};
        leetCode455.findContentChildren(a,b);
    }
}
