class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {

        // Smaller half (Max Heap)
        maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Larger half (Min Heap)
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {

        // Always insert into maxHeap first
        maxHeap.add(num);

        // Ensure every element in maxHeap <= every element in minHeap
        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.add(maxHeap.poll());
        }

        // Balance the heaps
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }

        if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {

        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.size() > minHeap.size()
                ? maxHeap.peek()
                : minHeap.peek();
    }
}