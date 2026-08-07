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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root == null){
            return "N";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                str.append("N,");
            }else{
                str.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        if(str[0].equals("N")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!str[index].equals("N")){
                node.left = new TreeNode(Integer.valueOf(str[index]));
                queue.add(node.left);
            }
            index++;
            if(!str[index].equals("N")){
                node.right = new TreeNode(Integer.valueOf(str[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }
}
