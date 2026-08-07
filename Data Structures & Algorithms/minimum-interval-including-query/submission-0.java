class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] query = Arrays.stream(queries).sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[queries.length];
        int i = 0;
        for(int q : query){
            while(i < intervals.length && intervals[i][0] <= q){
                int start = intervals[i][0];
                int end = intervals[i][1];
                minHeap.add(new int[]{end - start + 1, end});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }
            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        for(int j = 0; j < queries.length; j++){
            res[j] = map.get(queries[j]);
        }
        return res;
    }
}
