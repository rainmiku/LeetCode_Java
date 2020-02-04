package com.package1;

import java.util.ArrayDeque;

public class LC733 {
    private class Pos{
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x, y;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        ArrayDeque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(sr,sc));

        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!deque.isEmpty()){
            Pos current = deque.pop();
            int x = current.x;
            int y = current.y;

            int color = image[x][y];

            for (int[] dir: dirs) {
                int i = x+dir[0];
                int j = y+dir[1];
                if (isValid(image,i,j,color,newColor))
                    deque.add(new Pos(i,j));
            }

            image[x][y] = newColor;
        }
        return image;
    }

    private boolean isValid(int[][] image, int x, int y, int color, int newColor){
        return x>=0 && x < image.length && y >= 0 && y < image[0].length
                && image[x][y] == color
                && image[x][y]!=newColor;
    }


    public int[][] floodFillDfs(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
