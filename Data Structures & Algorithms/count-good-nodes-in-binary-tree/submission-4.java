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
        int count = countGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    public int countGoodNodes(TreeNode node, int maxValue){
        if(node == null){
            return 0;
        }
        int count = 0;
        if(node.val >= maxValue){
            count++;
        }

        int newMaxValue = Math.max(node.val, maxValue);
        count = count + countGoodNodes(node.left, newMaxValue);
        count = count + countGoodNodes(node.right, newMaxValue);

        return count;
    }
}
