class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<Edge>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + 
                    Math.abs(points[i][1] - points[j][1]);
                map.computeIfAbsent(i, k -> new ArrayList<>()).add(new Edge(distance, j));
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(new Edge(distance, i));
            }
        }

        int minCost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        pq.add(new Edge(0, 0));
        boolean[] vis = new boolean[n];
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int dis = e.dis;
            int curr = e.node;

            if(vis[curr]){
                continue;
            }
            vis[curr] = true;
            minCost = minCost + dis;
            for(Edge eg : map.getOrDefault(curr, Collections.emptyList())){
                int egdistance = eg.dis;
                int edgNode = eg.node;
                if(!vis[edgNode]){
                    pq.add(new Edge(egdistance, edgNode));
                }
            }
        }
        return minCost;
    }
}

class Edge{
    int dis;
    int node;

    public Edge(int dis, int node){
        this.dis = dis;
        this.node = node;
    }
}
