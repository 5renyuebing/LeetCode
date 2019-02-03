package dataStructure.listNode;

/**
 * 思路：
 *      1.确定边界条件
 *      2.通过递归到达链表尾端进行对子链表的操作：
 *                        到达底端->deleteDuplicates(head.next);并获取子链表头结点
 *                        操作->令当前头结点的next指向子链表的头结点
 *      3.返回当前链表的头结点
 */
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
    public static void main(String[] args) {
        LeetCode83 leetCode83 = new LeetCode83();
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        ListNode t = leetCode83.deleteDuplicates(node);
        System.out.println(t.next);
    }
}
