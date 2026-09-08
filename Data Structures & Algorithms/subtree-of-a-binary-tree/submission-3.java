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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null && subRoot != null){
            return false;
        }
        if(root.val == subRoot.val){
            if(isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode node, TreeNode subRootNode){
        if(node == null && subRootNode == null){
            return true;
        }
        if(node == null || subRootNode == null){
            return false;
        }
        if(node.val == subRootNode.val){
            if(isSameTree(node.left, subRootNode.left) && isSameTree(node.right, subRootNode.right)){
                return true;
            }
        }
        return false;
    }
}
