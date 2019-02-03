package dataStructure.listNode;

/**
 * 206. Reverse Linked List
 *
 * 递归法：先得到头结点newHead，再进行操作next.next = head;head.next = null;最后返回newHead
 *
 * 思路：
 *      1.边界条件
 *      2.递归到达链表尾端
 *      3.
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static void main(String[] args){
        LeetCode206 leetCode206 = new LeetCode206();
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        leetCode206.reverseList(node);


    }
}
