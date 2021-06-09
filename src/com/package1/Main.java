package com.package1;

import com.package1.Contest179.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC297();
        var s = new LC617();

       String a = "1,2,3,5";
       String b = "2,1,3,null,4,null,7";


       TreeNode root1 = solution.deserializeLevel(a);
       TreeNode root2 = solution.deserializeLevel(b);

       s.mergeTrees(root1,root2);

       System.out.println("complete");

    }

}
