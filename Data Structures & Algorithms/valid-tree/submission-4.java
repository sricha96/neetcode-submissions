class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        //boolean[] vis = new boolean[n];
        Set<Integer> vis = new HashSet<>();
        if(!dfs(0, -1, vis, adjList)){
            return false;
        }
        //for(boolean v : vis){
        //    if(!v){
        //        return false;
        //    }
        //}
        return vis.size() == n;
    }

    public boolean dfs(int node, int root, Set<Integer> vis, List<List<Integer>> adjList){
        if(vis.contains(node)){
            return false;
        }
        vis.add(node);

        for(int nextNode : adjList.get(node)){
            if(nextNode == root){
                continue;
            }
            if(!dfs(nextNode, node, vis, adjList)){
                return false;
            }
        }
        return true;
    }
}
