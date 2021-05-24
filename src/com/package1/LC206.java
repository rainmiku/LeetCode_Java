package com.package1;


public class LC206 {
    //https://labuladong.gitee.io/algo/2/17/16/
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public  ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode pre = null;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
