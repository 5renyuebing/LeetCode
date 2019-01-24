package conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * @author lcl
 */

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        List<Integer> depth = depth(root);
        return Math.abs(depth.get(depth.size() - 1) - depth.get(0)) <= 1;
    }
    private static List<Integer> depth(TreeNode node){
        if(node == null){
            return new ArrayList<>(Arrays.asList(0));
        }
        List<Integer> subDepthLeft = depth(node.left);
        List<Integer> subDepthRight = depth(node.right);
        Collections.sort(subDepthLeft);
        int maxLeft = subDepthLeft.get(subDepthLeft.size() - 1);
        Collections.sort(subDepthRight);
        int maxRight = subDepthRight.get(subDepthRight.size() - 1);
        return new ArrayList<>(Arrays.asList(maxLeft + 1, maxRight + 1));
    }
    public static void main(String[] args){
        LeetCode110 leetCode110 = new LeetCode110();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(3);
        node.left.left.right = new TreeNode(3);
        leetCode110.isBalanced(node);
    }
}
