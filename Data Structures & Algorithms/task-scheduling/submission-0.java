class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] counts = new int[26];
        for(char task : tasks){
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : counts){
            if(i > 0){
                maxHeap.add(i);
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){
                Pair p = queue.peek();
                time = p.time;
            }else{
                int count = maxHeap.poll() - 1;
                if(count > 0){
                    queue.add(new Pair(count, time + n));
                }
            }
            if(!queue.isEmpty() && queue.peek().time == time){
                Pair pair = queue.poll();
                int cnt = pair.cnt;
                maxHeap.add(cnt);
            }
        }
        return time;
    }
}

class Pair{
    int cnt;
    int time;

    public Pair(int cnt, int time){
        this.cnt = cnt;
        this.time = time;
    }
}
