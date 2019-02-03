package dataStructure.listNode;

/**
 * 24. Swap Nodes in Pairs
 *
 * @author lcl
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode subList = swapPairs(head.next.next);
        ListNode newHead = head.next;
        head.next = subList;
        newHead.next = head;
        return newHead;
    }
}
