package com.package1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC057();

        int[][] inte = {{1,5},{6,8}};
        int[] insert = {5,6};

        System.out.println(Arrays.deepToString(solution.insert(inte,insert)));
        System.out.println("ddd");

    }
}
