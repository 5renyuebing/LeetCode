package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 *
 * @author lcl
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        addResult(root,result,"");
        return result;
    }
    private static void addResult(TreeNode node, List<String> result, String currentString){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(currentString.equals("")){
                result.add(String.valueOf(node.val));
            }
            else {
                result.add(currentString + "->" + String.valueOf(node.val));
            }
        }
        else {
            if(currentString.equals("")){
                addResult(node.left,result,String.valueOf(node.val));
                addResult(node.right,result,String.valueOf(node.val));
            }
            else {
                addResult(node.left,result,currentString + "->" + String.valueOf(node.val));
                addResult(node.right,result,currentString + "->" + String.valueOf(node.val));
            }
        }
    }
}
