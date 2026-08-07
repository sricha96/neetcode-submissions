class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, List<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            adj.put(ticket.get(0), new ArrayList<>());
        }
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket : tickets){
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        int len = tickets.size();
        res.add("JFK");
        if(dfs(res, adj, "JFK", len + 1)){
            return res;
        }

        return new ArrayList<>();
    }

    public boolean dfs(List<String> res, Map<String, List<String>> adj, String src, int length){
        if(res.size() == length){
            return true;
        }
        if(!adj.containsKey(src)){
            return false;
        }
        List<String> temp = new ArrayList<>(adj.get(src));
        for(int i = 0; i < temp.size(); i++){
            String nei = temp.get(i);
            adj.get(src).remove(i);
            res.add(nei);
            if(dfs(res, adj, nei, length)){
                return true;
            }
            adj.get(src).add(i, nei);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
