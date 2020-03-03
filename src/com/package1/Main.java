package com.package1;

import com.package1.Contest178.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC480();


        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 3;

        System.out.println(Arrays.toString(solution.medianSlidingWindow(nums,k)));

        System.out.println("ddd");

    }

}
