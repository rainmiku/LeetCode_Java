package com.package1;

public class LC025 {
    //https://labuladong.gitee.io/algo/2/17/17/
    public ListNode reverse(ListNode a, ListNode b){
        if (a == null || b == null || a == b) return a;
        ListNode current = a;
        ListNode pre = null;

        while (current != b){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return  null;
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }
}
