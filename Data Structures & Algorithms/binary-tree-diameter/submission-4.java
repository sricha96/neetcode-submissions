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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int diam1 = diameterOfBinaryTree(root.left);
        int diam2 = diameterOfBinaryTree(root.right);
        int diam3 = maxDepth(root.left) + maxDepth(root.right);
        int res = Math.max(diam3, Math.max(diam1, diam2));
        return res;
    }

    public int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);
        int res = Math.max(leftMax, rightMax) + 1;
        return res;
    }
}
