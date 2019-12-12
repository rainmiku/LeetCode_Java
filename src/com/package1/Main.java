package com.package1;

public class Main {

    public static void main(String[] args) {

        var solution = new LC086();
        int[] nums = {1,3,-1,5,2,1};

        for (var num: nums) {
            solution.add(num);
        }


        var result = solution.partition(solution.head,3);

        System.out.println("done");




    }
}
