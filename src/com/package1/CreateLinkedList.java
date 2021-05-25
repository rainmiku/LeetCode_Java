package com.package1;

class LinkList {
    static ListNode createLinkedList(int[] a){
        ListNode head = new ListNode(a[0]);
        ListNode pre = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            pre.next = node;
            pre = node;
        }
        return head;
    }

    static void printLinkedList(ListNode head){
        ListNode current = head;
        while (current!=null){
            System.out.print(current.val+"-> ");
            current = current.next;
        }
    }
}
