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
        int leftMax = maxPath(root.left);
        int rightMax = maxPath(root.right);
        res = Math.max(res, (root.val + leftMax + rightMax));
        maxPathSum(root.left);
        maxPathSum(root.right);
        return res;
    }

    // current node k through parent ko kitna contribution mil sakta and ignoring -ve path
    public int maxPath(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMaxPath = maxPath(node.left);
        int rightMaxPath = maxPath(node.right);
        int maxPath = Math.max(leftMaxPath, rightMaxPath) + node.val;

        return Math.max(0, maxPath);
    }
}
