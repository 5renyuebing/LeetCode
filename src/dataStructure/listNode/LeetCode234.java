package dataStructure.listNode;

import java.util.Stack;

/**
 * 234. Palindrome Linked List
 *
 * @author lcl
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        while (node != null){
            int val1 = node.val;
            int val2 = stack.pop();
            if(val1 != val2){
                return false;
            }
            node = node.next;
        }
        return true;
    }
}
