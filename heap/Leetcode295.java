class MedianFinder {

    /** initialize your data structure here. */
    
    Queue<Integer> minHeap,maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty()){
            minHeap.offer(num);
            return;
        }
        if(minHeap.size() == maxHeap.size()){
            if(minHeap.peek() < num){
                minHeap.offer(num);
            }
            else {
                maxHeap.offer(num);
            }
        }
        else if(minHeap.size() > maxHeap.size()) {
            if(minHeap.peek() < num) {
                maxHeap.offer(minHeap.peek());
                minHeap.poll();
                minHeap.offer(num);
            }
            else {
                maxHeap.offer(num);
            }
        }
        else {
            if(maxHeap.peek() > num){
                minHeap.offer(maxHeap.peek());
                maxHeap.poll();
                maxHeap.offer(num);
            }
            else {
                minHeap.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek())/2.0;
        if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */