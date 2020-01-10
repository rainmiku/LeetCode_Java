package com.package1;

public class LC142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;

        while (fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                hasCycle = true;
                break;
            }
        }

        if (hasCycle){
            slow = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}
