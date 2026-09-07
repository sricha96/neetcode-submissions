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
        int leftMin = Integer.MIN_VALUE;
        int rightMax = Integer.MAX_VALUE;
        return isValid(root, leftMin, rightMax);
    }

    public boolean isValid(TreeNode root, int leftMin, int rightMax){
        if(root == null){
            return true;
        }
        if(!(root.val > leftMin && root.val < rightMax)){
            return false;
        }
        return isValid(root.left, leftMin, root.val) && 
            isValid(root.right, root.val, rightMax);
    }
}
