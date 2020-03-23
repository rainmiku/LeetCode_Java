package com.package1;

import java.util.PriorityQueue;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        for (int i = k; i <nums.length ; i++) {
            if (nums[i] > heap.peek()){
                heap.poll();
                heap.add(nums[i]);
            }
        }

        return heap.peek();
    }
}
