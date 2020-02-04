package com.package1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC733();

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};


        System.out.println(Arrays.deepToString(solution.floodFill(image, 1, 1, 2)));


        System.out.println("ddd");

    }
}
