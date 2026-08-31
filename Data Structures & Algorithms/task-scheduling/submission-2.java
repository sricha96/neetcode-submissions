class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                maxHeap.add(count[i]);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                Pair p = queue.peek();
                time = p.processAtTime;
            }else{
                int remainingCount = maxHeap.poll();
                remainingCount--;

                if(remainingCount > 0){
                    queue.add(new Pair(remainingCount, time + n));
                }
            }

            if(!queue.isEmpty() && queue.peek().processAtTime == time){
                Pair p = queue.poll();

                maxHeap.add(p.remainingCnt);
            }
        }
        return time;
    }
}

class Pair{
    int remainingCnt;
    int processAtTime;

    Pair(int remainingCnt, int processAtTime){
        this.remainingCnt = remainingCnt;
        this.processAtTime = processAtTime;
    }
}
