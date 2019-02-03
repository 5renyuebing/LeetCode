package dataStructure.tree;

/**
 * 617. Merge Two Binary Trees
 *
 * @author lcl
 */

public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1== null && t2 == null){
            return null;
        }
        else if(t1 == null){
            return t2;
        }
        else if(t2 == null){
            return t1;
        }
        TreeNode leftTree = mergeTrees(t1.left, t2.left);
        TreeNode rightTree = mergeTrees(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        t1.left = leftTree;
        t1.right = rightTree;
        return t1;
    }
}
