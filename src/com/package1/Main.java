package com.package1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC986();

        int[][] A = {{14,16}};
        int[][] B = {{7,13},{16,20}};

        System.out.println(Arrays.deepToString(solution.intervalIntersection(A,B)));
        System.out.println("ddd");

    }
}
