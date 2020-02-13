package com.package1;

import java.util.PriorityQueue;

public class KthLargest {
    private int k;
    private PriorityQueue<Integer> queue;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num :
                nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k)
            queue.offer(val);
        else if (queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();
    }


}
