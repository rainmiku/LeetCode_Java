package com.package1;

import com.package1.Contest179.*;
import com.package1.Contest245.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] list = {node1,node2,node3};

        var solution = new LC023();


       ListNode head = solution.mergeKLists(list);

    }

}
