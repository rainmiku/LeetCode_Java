package com.package1;

public class LC092 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode current = head;
        ListNode durationLeft = p;
        ListNode durationRight = null;
        int index = 1;

        while (current != null){
            if (index  == left-1) durationLeft = current;
            if (index  == right+1) durationRight = current;
            current = current.next;
            index++;
        }
        ListNode pre = durationLeft;
        current = left <= 1 ? head : durationLeft.next;
        ListNode s = current;

        while (current != durationRight){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        durationLeft.next = pre;
        s.next = durationRight;

        return p.next;
    }
    
    //https://labuladong.gitee.io/algo/2/17/16/
    ListNode after = null;
    public ListNode reverseN(ListNode head, int right){
        if (right == 1) {
            after = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,right-1);
        head.next.next = head;
        head.next = after;
        return last;
    }

    public ListNode reverseBetweenRecursion(ListNode head, int left, int right) {
        if (left == 1) return reverseN(head,right);
        head.next = reverseBetweenRecursion(head.next,left-1,right-1);
        return head;
    }
}
