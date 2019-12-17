package com.package1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC729();

        int[][] input = {{47,50},{33,41},{39,45},{33,42},{25,32},{26,35},{19,25},{3,8},{8,13},{18,27}};

        for (int[] time:input) {
            System.out.println(solution.book(time[0],time[1]));
        }

        System.out.println("ddd");

    }
}
