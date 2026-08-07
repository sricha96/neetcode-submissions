class Solution {
    public int countComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, vis, adj);
                count++;
            }
        }
        return count;
    }

    public void dfs(int curr, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;
        for(int neighbor : adj.get(curr)){
            if(!vis[neighbor]){
                dfs(neighbor, vis, adj);
            }
        }
    }
}
