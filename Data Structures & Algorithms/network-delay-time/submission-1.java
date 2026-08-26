class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Pair>> adjMap = new HashMap<>();
        for(int[] time : times){
            adjMap.computeIfAbsent(time[0], i -> new ArrayList<>()).add(new Pair(time[1], time[2]));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
        queue.add(new Pair(k, 0));
        int minTime = 0;
        Set<Integer> vis = new HashSet<>();

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int currNode = p.node;
            int currTime = p.time;

            if(vis.contains(currNode)){
                continue;
            }
            vis.add(currNode);
            minTime = currTime;
            for(Pair next : adjMap.getOrDefault(currNode, Collections.emptyList())){
                queue.add(new Pair(next.node, (next.time + currTime)));
            }
            
        }
        return vis.size() == n ? minTime : -1;
    }
}

class Pair{
    int node;
    int time;

    Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}