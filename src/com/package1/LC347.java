package com.package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LC347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num :
                nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->Integer.compare(map.get(a),map.get(b)));
        for (int num :
                map.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        return new ArrayList<>(minHeap);
    }
}
