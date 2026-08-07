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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p != null && q != null && p.val == q.val){
            boolean leftMatch = isSameTree(p.left, q.left);
            boolean rightMatch = isSameTree(p.right, q.right);
            if(leftMatch && rightMatch){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
