package com.package1;

import com.package1.Contest179.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC297();
        var s = new LC993();

       String a = "1,2,5,3,null,null,6,4,";


       TreeNode root = solution.deserializeLevel(a);

       boolean r = s.isCousins(root,3,6);

       System.out.println(r);

    }

}
