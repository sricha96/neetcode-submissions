class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Frequency of each task (A-Z)
        int[] counts = new int[26];
        for(char task : tasks){
            counts[task - 'A']++;
        }

        // Max Heap: Always execute the task having the highest remaining frequency
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all task frequencies to the max heap
        for(int count : counts){
            if(count > 0){
                maxHeap.offer(count);
            }
        }

        // Queue stores tasks that are in cooldown.
        // Pair(cnt, time)
        // cnt  -> remaining occurrences of the task
        // time -> earliest time when this task can be executed again
        Queue<Pair> queue = new LinkedList<>();

        // Current CPU time
        int time = 0;

        // Continue until there are no executable tasks
        // and no tasks waiting in cooldown.
        while(!maxHeap.isEmpty() || !queue.isEmpty()){

            // One CPU interval passes
            time++;

            if(maxHeap.isEmpty()){

                // No task can be executed now.
                // Jump directly to the next available time
                // instead of simulating idle intervals one by one.
                Pair p = queue.peek();
                time = p.time;

            }else{

                // Execute the task with the highest remaining frequency
                int count = maxHeap.poll();

                // One occurrence is completed
                count--;

                // If this task still has remaining occurrences,
                // put it into cooldown.
                if(count > 0){

                    // It can be executed again after n intervals.
                    queue.offer(new Pair(count, time + n));
                }
            }

            // If the task at the front of the cooldown queue
            // has finished cooling down,
            // move it back into the max heap.
            if(!queue.isEmpty() && queue.peek().time == time){

                Pair pair = queue.poll();

                // Task becomes available again
                maxHeap.offer(pair.cnt);
            }
        }

        return time;
    }
}

class Pair{

    int cnt;   // Remaining frequency
    int time;  // Time when task becomes available again

    public Pair(int cnt, int time){
        this.cnt = cnt;
        this.time = time;
    }
}