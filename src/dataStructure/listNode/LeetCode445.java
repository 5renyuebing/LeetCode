package dataStructure.listNode;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 *
 * @author lcl
 */
public class LeetCode445 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            Stack<Integer> result = new Stack<>();
            while (l1 != null){
                stack1.push(l1);
                l1 = l1.next;
            }
            while (l2 != null){
                stack2.push(l2);
                l2 = l2.next;
            }
            int add = 0;
            int val;
            while ((!stack1.empty()) || (!stack2.empty())){
                if(stack1.empty()){
                    ListNode node2 = stack2.pop();
                    val = node2.val + add;
                }
                else if(stack2.empty()){
                    ListNode node1 = stack1.pop();
                    val = node1.val + add;
                }
                else {
                    ListNode node1 = stack1.pop();
                    ListNode node2 = stack2.pop();
                    val = node1.val + node2.val + add;
                }
                result.push(val % 10);
                add =  val / 10;
            }
            if(add == 1){
                result.push(1);
            }
            ListNode head = null;
            ListNode node = null;
            while (!result.empty()){
                if(head == null){
                    head = new ListNode(result.pop());
                    node = head;
                }
                else {
                    node.next = new ListNode(result.pop());
                    node = node.next;
                }
            }
            return head;
        }
        public static void main(String[] args){
            LeetCode445 leetCode445 = new LeetCode445();
            ListNode head1 = new ListNode(7);
            head1.next = new ListNode(2);
            head1.next.next = new ListNode(4);
            head1.next.next.next = new ListNode(3);
            ListNode head2 = new ListNode(5);
            head2.next = new ListNode(6);
            head2.next.next = new ListNode(4);
            leetCode445.addTwoNumbers(head1, head2);
        }
}
