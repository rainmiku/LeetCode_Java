package com.package1;

public class LC234 {
    public ListNode reverse(ListNode head){
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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast!= null && fast.next!= null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        ListNode right = reverse(slow);
        ListNode left = head;

        while (right != null && left!= null){
            if (right.val != left.val) return false;
            right = right.next;
            left = left.next;
        }
        return true;
    }
}
