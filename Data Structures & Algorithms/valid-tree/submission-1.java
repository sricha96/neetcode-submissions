class Solution {
    public boolean validTree(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> vis = new HashSet<>();
            if(!dfs(0, -1, vis, adj)){
                return false;
            }
        return vis.size() == n;
    }

    public boolean dfs(int curr, int parent, Set<Integer> vis, ArrayList<ArrayList<Integer>> adj){
        if(vis.contains(curr)){
            return false;
        }
        vis.add(curr);
        for(int neighbor : adj.get(curr)){
            if(neighbor == parent){
                continue;
            }
            if(!dfs(neighbor, curr, vis, adj)){
                return false;
            }
        }
        return true;
    }
}
