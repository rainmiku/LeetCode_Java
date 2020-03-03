package com.package1;

import java.util.PriorityQueue;

public class LC480 {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //have to use comparator because (a,b)->(b-a) may cause over limit of Integer such as Integer.MaxValue - Integer.MinValue
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length-k+1];

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        int right = k-1;
        result[0] = getMedian();

        for (int left = 1; left < nums.length - k + 1; left++) {
            removeNum(nums[left-1]);
            addNum(nums[++right]);
            result[left] = getMedian();
        }
        return result;
    }

    private void addNum(int num){
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        balanceHeap();
    }

    private void removeNum(int num){
        if (num <= maxHeap.peek())
            maxHeap.remove(num);
        else
            minHeap.remove(num);
        balanceHeap();
    }

    private void balanceHeap(){
        if (maxHeap.size() > minHeap.size()+1)
            minHeap.offer(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    private double getMedian(){
        if (maxHeap.size() == minHeap.size())
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        return maxHeap.peek();
    }


}
