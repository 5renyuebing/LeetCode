package conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

public class LeetCode111 {
    public int minDepth(TreeNode root) {
        List<Integer> depth = depth(root);
        quickSort(depth,0,depth.size() - 1);
        return depth.get(0);
    }
    private static List<Integer> depth(TreeNode node){
        if(node == null){
            return new ArrayList<>(Arrays.asList(0));
        }
        if(node.left == null && node.right == null){
            return new ArrayList<>(Collections.singletonList(1));
        }
        else if(node.left == null){
            List<Integer> subDepth = depth(node.right);
            for(int i = 0;i<subDepth.size();i++){
                int tmp = subDepth.get(i);
                subDepth.remove(i);
                subDepth.add(i,tmp + 1);
            }
            return subDepth;
        }
        else if(node.right == null){
            List<Integer> subDepth = depth(node.left);
            for(int i = 0;i<subDepth.size();i++){
                int tmp = subDepth.get(i);
                subDepth.remove(i);
                subDepth.add(i,tmp + 1);
            }
            return subDepth;
        }
        else {
            List<Integer> subDepthLeft = depth(node.left);
            List<Integer> subDepthRight = depth(node.right);
            for(int i = 0;i<subDepthLeft.size();i++){
                int tmp = subDepthLeft.get(i);
                subDepthLeft.remove(i);
                subDepthLeft.add(i,tmp + 1);
            }
            for(int i = 0;i<subDepthRight.size();i++){
                int tmp = subDepthRight.get(i);
                subDepthRight.remove(i);
                subDepthRight.add(i,tmp + 1);
            }
            subDepthRight.removeAll(subDepthLeft);
            subDepthLeft.addAll(subDepthRight);
            return subDepthLeft;
        }
        }
        private static void quickSort(List<Integer> nums,int begin, int end){
        if (begin < end){
            int patition = patition(nums,begin, end);
            quickSort(nums,begin,patition - 1);
            quickSort(nums,patition + 1, end);
        }
        }
        private static int patition(List<Integer> nums,int begin, int end){
        int position = begin + 1;
        for(int i = position; i<= end; i++){
            if(nums.get(i) < nums.get(begin)){
                int tmp = nums.get(position);
                nums.remove(position);
                nums.add(position, nums.get(i));
                nums.remove(i);
                nums.add(i, tmp);
                position++;
            }
        }
            int tmp = nums.get(position - 1);
            nums.remove(position - 1);
            nums.add(position - 1,nums.get(begin));
            nums.remove(begin);
            nums.add(begin, tmp);
            return position - 1;
        }

        public static void main(String[] args){
        LeetCode111 leetCode111 = new LeetCode111();
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(17);
        leetCode111.minDepth(null);
        }
    }

