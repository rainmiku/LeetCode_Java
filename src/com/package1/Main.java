package com.package1;

import com.package1.Contest179.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC297();
        var s = new LC958();

       String a = "1,2,3,5,null,7";


       TreeNode root = solution.deserializeLevel(a);

       s.isCompleteTree(root);

       System.out.println("complete");

    }

}
