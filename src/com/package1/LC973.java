package com.package1;


import java.util.PriorityQueue;

public class LC973 {
    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dis(){
            return x*x+y*y;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b.dis(),a.dis()));
        for (int[] point : points) {
            maxHeap.add(new Point(point[0],point[1]));
            if (maxHeap.size() > K)
                maxHeap.poll();
        }

        int[][] result = new int[K][2];
        int k = 0;
        while (!maxHeap.isEmpty()){
            result[k][0] = maxHeap.peek().x;
            result[k++][1] = maxHeap.poll().y;
        }

        return result;
    }
}
