package com.package1;

import com.package1.Contest179.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC297();
        var s = new LC257();

       String a = "1,2,3,null,5";


       TreeNode root = solution.deserializeLevel(a);

       s.binaryTreePaths(root);

       System.out.println("complete");

    }

}
