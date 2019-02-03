package dataStructure.listNode;

/**
 * 19. Remove Nth Node From End of List (Medium)
 *
 * 思路：
 *      1.当head为null时为边界条件 -> 边界条件不再是head和head的next为null，因为head不为null且n为1时不应返回head
 *        边界条件其实就是递归的终止条件，需要根据问题具体情况具体分析
 *        例如LeetCode21中边界条件为：
 *                if (l1 == null) return l2;
 *                if (l2 == null) return l1;
 *        递归的目的是到达链表的尾端，需要通过边界条件进行终止
 *      2.利用递归到达链表尾段，ListNode subNode = removeNthFromEnd(head.next, n);返回的是子链表的头结点，也取决于边界条件
 *      3.按照题目要求执行相应操作：
 *                使用一个计数方法判断当前结点是第几个结点
 *                在递归到达尾端后可以进行丰富的操作：一般而言是将当前结点与子链表的头结点进行组装-> head.next = subNode;
 *                                                  在链表转置中，操作为将当前结点连接到子链表的尾端-> head.next.next = head; head.next = null;
 *                                                  在本问题中，操作为判断当前结点是否为待删除的结点-> int length = sumNode(head);
 *      4.返回当前结点与子链表组合之后的新链表的头结点，如果当前结点已被删除，则新链表与子链表相同，因此直接返回子链表的头结点即可-> if(length == n) return subNode;
 *        否则将当前结点与子链表组装之后返回新链表
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode subNode = removeNthFromEnd(head.next, n);
        int length = sumNode(head);
        if(length == n){
            return subNode;
        }
        head.next = subNode;
        return head;
    }
    private static int sumNode(ListNode node){
        if(node == null){
            return 0;
        }
        if(node.next == null){
            return 1;
        }
        return 1+sumNode(node.next);
    }
    public static void main(String[] args){
        LeetCode19 leetCode19 = new LeetCode19();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        leetCode19.removeNthFromEnd(node, 2);


    }
}
