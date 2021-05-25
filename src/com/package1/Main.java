package com.package1;

import com.package1.Contest179.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var solution = new LC234();

       int[] a = {1,2};

       ListNode head = LinkList.createLinkedList(a);
       System.out.println(solution.isPalindrome(head));

        //LinkList.printLinkedList(head);


       System.out.println("null");

    }

}
