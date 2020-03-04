package com.package1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC436 {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        Arrays.fill(result,-1);
        PriorityQueue<int[]> startHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> endHeap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        HashMap<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            startHeap.offer(intervals[i]);
            endHeap.offer(intervals[i]);
            map.put(intervals[i],i);
        }

        while (!endHeap.isEmpty()){
            int[] current = endHeap.poll();
            while (!startHeap.isEmpty() && current[1] > startHeap.peek()[0])
                startHeap.poll();
            if (startHeap.isEmpty())
                break;
            int[] next = startHeap.peek();
            result[map.get(current)] = map.get(next);
        }

        return result;

    }
}
