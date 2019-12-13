package com.package1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC832();
        int[][] nums = {{1,1,0},{1,0,1},{0,0,0}};



        System.out.println(Arrays.deepToString(solution.flipAndInvertImage(nums)));

        System.out.println("done");




    }
}
