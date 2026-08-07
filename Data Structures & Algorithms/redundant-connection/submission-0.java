class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[] vis = new boolean[n + 1];
            if(dfs(u, -1, vis, adj)){
                return edge;
            }
        }
        return new int[0];
    }

    public boolean dfs(int curr, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        if(vis[curr]){
            return true;
        }
        vis[curr] = true;
        for(int n : adj.get(curr)){
            if(n == parent){
                continue;
            }
            if(dfs(n, curr, vis, adj)){
                return true;
            }
        }
        return false;
    }
}
