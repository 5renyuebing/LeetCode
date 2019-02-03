package dataStructure.listNode;

/**
 * 21. Merge Two Sorted Lists
 *
 * 思路：
 *      1.返回边界条件：if (l1 == null) return l2; if (l2 == null) return l1;
 *      2.通过递归到达链表的尾端：mergeTwoLists(l1.next, l2); 或  mergeTwoLists(l1, l2.next); 并获取返回的子链表的头部
 *      3.在尾端对链表进行一些处理：令当前结点的next等于返回值 -> 当前结点的next为子链表的头部
 *      4.返回当前链表头 -> 链表头可能是原先的头部，也可能是尾部（在题目链表反转中就是尾部）
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
