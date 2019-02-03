package dataStructure.tree;

/**
 * 112. Path Sum
 *
 * @author lcl
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root != null && root.right == null && root.left == null && sum == root.val){
            return true;
        }
        else if(root == null || (root.right == null && root.left == null)){
            return false;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
