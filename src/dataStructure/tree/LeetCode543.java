package dataStructure.tree;

/**
 * 543. Diameter of Binary Tree
 *
 * @author lcl
 */

public class LeetCode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLongest = diameterOfBinaryTree(root.left);
        int rightLongest = diameterOfBinaryTree(root.right);
        return Math.max(depth(root.right) + depth(root.left), Math.max(leftLongest, rightLongest));
    }
    private static int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(depth(node.left),depth(node.right)) + 1;
    }
}
