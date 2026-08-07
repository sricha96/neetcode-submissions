class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Edge>> map = new HashMap<>();
        for(int[] time : times){
            map.computeIfAbsent(time[0], i -> new ArrayList<>()).add(new Edge(time[2],time[1]));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        Set<Integer> vis = new HashSet<>();
        pq.add(new Edge(0, k));
        int minTime = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int curr = e.node;
            int dis = e.dis;
            if(vis.contains(curr)){
                continue;
            }
            vis.add(curr);
            minTime = dis;
            for(Edge eg : map.getOrDefault(curr, Collections.emptyList())){
                int egd = eg.dis;
                int egn = eg.node;
                if(!vis.contains(egn)){
                    pq.add(new Edge(egd + minTime, egn));
                }
            }
        }
        return vis.size() == n ? minTime : -1;
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
