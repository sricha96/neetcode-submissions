/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(Node n : curr.neighbors){
                if(!map.containsKey(n)){
                    map.put(n, new Node(n.val));
                    queue.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        
        return map.get(node);
    }
}