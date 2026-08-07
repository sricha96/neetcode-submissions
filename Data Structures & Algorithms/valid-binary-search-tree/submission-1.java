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
    public boolean isValidBST(TreeNode root) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        return isValid(root, left, right);
    }

    public boolean isValid(TreeNode root, int left, int right){
        if(root == null){
            return true;
        }
        if(!(root.val > left && root.val < right)){
            return false;
        }
        return isValid(root.left, left, root.val) && 
            isValid(root.right, root.val, right);
    }
}
