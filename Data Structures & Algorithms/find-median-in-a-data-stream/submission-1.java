class MedianFinder {

    PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> b - a);
		maxHeap = new PriorityQueue<>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
		if((minHeap.size() - maxHeap.size() > 1) 
				|| (!maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek())) {
			int number = minHeap.poll();
			maxHeap.add(number);
		}
		if(maxHeap.size() - minHeap.size() > 1) {
			int number = maxHeap.poll();
			minHeap.add(number);
		}
    }
    
    public double findMedian() {
        double median = 0.0;
		if(maxHeap.size() == minHeap.size()) {
			median = (double) (maxHeap.peek() + minHeap.peek())/2;
		}else if (minHeap.size() > maxHeap.size()) {
			median = (double) minHeap.peek();
		}else {
			median = (double) maxHeap.peek();
		}
		return median;
    }
}
