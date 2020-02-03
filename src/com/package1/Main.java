package com.package1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC105();

        int[] preorder = {1,2,4,5,7,8,3,6};
        int[] inorder = {4,2,7,5,8,1,3,6};

        TreeNode root = solution.buildTree(preorder,inorder);


        System.out.println("ddd");

    }
}
