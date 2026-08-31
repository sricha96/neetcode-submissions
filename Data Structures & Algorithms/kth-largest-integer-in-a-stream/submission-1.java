class KthLargest {

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            queue.add(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if(queue.size() > k){
            queue.poll();
        }
        
        return queue.peek();
    }
}
