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

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    // maxVal = root se current node ke parent tak ka maximum
    public int dfs(TreeNode node, int maxVal) {

        // Node nahi hai
        if(node == null){
            return 0;
        }

        int count = 0;

        // Current node path ka maximum hai?
        if(node.val >= maxVal){
            count = 1;
        }

        // Current node ko include karke new maximum
        int newMax = Math.max(maxVal, node.val);

        // Left aur right subtree ke good nodes count karo
        count += dfs(node.left, newMax);
        count += dfs(node.right, newMax);

        return count;
    }
}
