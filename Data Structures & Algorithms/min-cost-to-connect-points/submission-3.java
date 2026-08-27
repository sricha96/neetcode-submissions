class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<Pair>> adjMap = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjMap.computeIfAbsent(i, k -> new ArrayList<>()).add(new Pair(j, distance));
                adjMap.computeIfAbsent(j, k -> new ArrayList<>()).add(new Pair(i, distance));
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        queue.add(new Pair(0, 0));
        int minCost = 0;

        Set<Integer> vis = new HashSet<>();
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int currNode = p.node;
            int dis = p.dis;

            if(vis.contains(currNode)){
                continue;
            }
            vis.add(currNode);
            minCost = minCost + dis;
            for(Pair next : adjMap.getOrDefault(currNode, Collections.emptyList())){
                queue.add(new Pair(next.node, next.dis));
            }
        }
        return vis.size() == points.length ? minCost : -1;
    }
}

class Pair{
    int node;
    int dis;

    Pair(int node, int dis){
        this.node = node;
        this.dis = dis;
    }
}