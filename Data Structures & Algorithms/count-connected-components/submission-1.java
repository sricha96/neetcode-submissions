class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, vis, adjList);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, boolean[] vis, List<List<Integer>> adjList){
        vis[node] = true;

        for(int nextNode : adjList.get(node)){
            if(!vis[nextNode]){
                dfs(nextNode, vis, adjList);
            }
        }
    }
}
