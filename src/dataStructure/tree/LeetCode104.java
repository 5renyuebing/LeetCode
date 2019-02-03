package dataStructure.tree;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * @author lcl
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        return currentDepth(root,0);
    }
    private static int currentDepth(TreeNode node, int depth){
        if(node == null){
            return depth;
        }
        else return Math.max(currentDepth(node.left, depth+1),currentDepth(node.right, depth+1));
    }
}
