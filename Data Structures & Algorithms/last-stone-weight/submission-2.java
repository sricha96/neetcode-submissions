class Solution {

    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int stone : stones){
            queue.add(stone);
        }
        while(!queue.isEmpty() && queue.size() > 1){
            int y = queue.poll();
            int x = queue.poll();

            if(x < y){
                y = y - x;
                queue.add(y);
            }
        }
        return queue.size() == 0 ? 0 : queue.peek();
    }
}
