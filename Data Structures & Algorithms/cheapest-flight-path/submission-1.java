class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Pair>> adjMap = new HashMap<>();
        for(int[] flight : flights){
            adjMap.computeIfAbsent(flight[0], i -> new ArrayList<>()).add(new Pair(flight[1], flight[2]));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(src, 0, 0));
        int[] distance = new int[n];
        for(int i = 0; i < n; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int currNode = t.node;
            int currPrice = t.price;
            int currSteps = t.steps;

            if(currSteps > k){
                continue;
            }

            for(Pair p : adjMap.getOrDefault(currNode, Collections.emptyList())){
                int nextNode = p.node;
                int price = p.price;
                if(price + currPrice < distance[nextNode] && currSteps <=k){
                    distance[nextNode] = price + currPrice;
                    queue.add(new Tuple(nextNode, distance[nextNode], currSteps + 1));
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}

class Pair{
    int node;
    int price;

    Pair(int node, int price){
        this.node = node;
        this.price = price;
    }
}

class Tuple{
    int node;
    int price;
    int steps;

    Tuple(int node, int price, int steps){
        this.node = node;
        this.price = price;
        this.steps = steps;
    }
}