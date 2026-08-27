class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for(List<String> ticket : tickets){
            adjMap.computeIfAbsent(ticket.get(0), i -> new PriorityQueue<>()).add(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        dfs(res, "JFK", adjMap);

        return res;
        
    }

    public void dfs(List<String> res, String src, Map<String, PriorityQueue<String>> adjMap){
        PriorityQueue<String> queue = adjMap.get(src);

        while(queue != null && !queue.isEmpty()){
            String nextNode = queue.poll();

            dfs(res, nextNode, adjMap);
        }
        res.addFirst(src);
    }
}
