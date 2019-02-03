package dataStructure.tree;

/**
 * 110. Balanced Binary Tree
 *
 * @author lcl
 */

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftBalanced = isBalanced(root.left);
        if (!leftBalanced) {
            return false;
        }
        boolean rightBalanced = isBalanced(root.right);
        return rightBalanced && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }
    private static int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(depth(node.left),depth(node.right)) + 1;
    }
}
