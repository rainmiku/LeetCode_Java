package com.package1;

import java.util.PriorityQueue;

public class LC295 {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public LC295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->(b-a));
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (minHeap.size()==maxHeap.size())
            return (minHeap.peek()+maxHeap.peek()) / 2.0;

        return (double) maxHeap.peek();
    }
}
