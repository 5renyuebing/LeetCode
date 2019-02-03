package dataStructure.tree;

/**
 * 226. Invert Binary Tree
 *
 * @author lcl
 */

public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode leftSubTree = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = leftSubTree;
        return root;
    }
}
