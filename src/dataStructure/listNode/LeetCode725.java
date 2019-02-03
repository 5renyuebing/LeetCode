package dataStructure.listNode;

/**
 * 725. Split Linked List in Parts
 *
 * @author lcl
 *
 * 总结：链表问题主要的困难点在于链表的单向性，解决方法有递归和栈
 * 所有需要从后向前遍历的都可以进行递归
 *
 * 递归:
 *      1.把问题转化为规模缩小了的同类问题的子问题
 *      2.有明确的不需要继续进行递归的条件(base case)
 *      3.有当得到了子问题的结果之后的决策过程
 *      4.不记录每一个子问题的解（区别于动态规划2）
 *
 * 在链表中递归的另一种理解方式：
 * 对于链表来说，链表组装完成，相当于将当前结点组装到只差当前结点的子链表上的问题 -> 递归问题
 * 使用ListNode subList = ... 可获取除了当前结点之外，已组装完成的子链表
 * 再对子链表和当前结点进行一些操作（步骤三，决策过程），最后返回新链表的头结点即可
 */

public class LeetCode725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = num(root);
        int subLength = length / k;
        if(subLength == 0){
            ListNode[] result = new ListNode[k];
            int i = 0;
            while (root != null){
                result[i] = root;
                root = root.next;
                result[i].next = null;
                i += 1;
            }
            return result;
        }
        else {
            ListNode[] result = new ListNode[k];
            int i = 0;
            int m = length - subLength * k;
            int n = 0;
            ListNode head = root;
            for(int p = 0;p < k; p++){
                root = head;
                while (i < subLength - 1){
                    root = root.next;
                    i ++;
                }
                if(n < m){
                    root = root.next;
                    n ++;
                }
                result[p] = head;
                i = 0;
                head = root.next;
                root.next = null;
            }
            return result;
        }
    }
    private static int num(ListNode node){
        if(node == null){
            return 0;
        }
        return num(node.next) + 1;
    }
    public static void main(String[] args){
        LeetCode725 leetCode725 = new LeetCode725();
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(1);
        leetCode725.splitListToParts(node,3);
    }
}
