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

    public int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMaxPathSum = calculateMaxPathSum(root.left);
        int rightMaxPathSum = calculateMaxPathSum(root.right);
        res = Math.max(res, (root.val + leftMaxPathSum + rightMaxPathSum));
        maxPathSum(root.left);
        maxPathSum(root.right);

        return res;
    }

    public int calculateMaxPathSum(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMaxPath = calculateMaxPathSum(node.left);
        int rightMaxPath = calculateMaxPathSum(node.right);
        int maxPath = Math.max(leftMaxPath, rightMaxPath) + node.val;

        return Math.max(0, maxPath);
    }
}
