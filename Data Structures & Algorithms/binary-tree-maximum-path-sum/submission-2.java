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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        res = Math.max(res, root.val + leftMax + rightMax);
        maxPathSum(root.left);
        maxPathSum(root.right);
        return res;
    }

    public int getMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        int path = root.val + Math.max(left, right);
        return Math.max(0, path);
    }
}
