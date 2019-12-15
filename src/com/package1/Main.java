package com.package1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC138();
       // int[] nums = {1,2};

        var head = new Node(1,null,null);
        var second = new Node (2, null,null);
        head.next = second;
        head.random = second;
        second.random = second;

        var node = solution.copyRandomList(head);


        System.out.println("done");




    }
}
