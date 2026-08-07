class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] flight : flights){
            adj.computeIfAbsent(flight[0], i -> new ArrayList<>()).add(new Pair(flight[1], flight[2]));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        int[] dis = new int[n];
        for(int i = 0; i < n; i++){
            dis[i] = Integer.MAX_VALUE;
        }

        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int steps = t.steps;
            int curr = t.node;
            int price = t.distance;

            if(steps > k){
                continue;
            }

            for(Pair p : adj.getOrDefault(curr, Collections.emptyList())){
                int nextNode = p.node;
                int nodeDis = p.dis;
                if(price + nodeDis < dis[nextNode] && steps <= k){
                    dis[nextNode] = price + nodeDis;
                    queue.add(new Tuple(steps + 1, nextNode, dis[nextNode]));
                }
            }
        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}

class Pair{
    int node;
    int dis;

    public Pair(int node, int dis){
        this.node = node;
        this.dis = dis;
    }
}

class Tuple{
    int steps;
    int node;
    int distance;

    public Tuple(int steps, int node, int distance){
        this.steps = steps;
        this.node = node;
        this.distance = distance;
    }
}
