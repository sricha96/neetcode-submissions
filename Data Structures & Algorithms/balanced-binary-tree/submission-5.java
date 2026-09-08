/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        if(Math.abs(leftMaxDepth - rightMaxDepth) <= 1 && 
        isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    public int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
