package com.package1;

public class LC086 {

    public ListNode head;
    private ListNode end;

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode largerPre;
        if (head.val >= x)
        {
            ListNode sp = findFirstSmallerNodePre(head,x);
            if (sp == null)
                return head;
            ListNode sm = sp.next;
            sp.next = sm.next;
            sm.next = head;
            largerPre = head = sm;
        }
        else
            largerPre = findFirstGreaterNodePre(head,x);


        if (largerPre == null)
            return head;
        ListNode larger = largerPre.next;
        ListNode smallerPre = findFirstSmallerNodePre(larger,x);
        if (smallerPre == null)
            return head;
        ListNode smaller = smallerPre.next;

        while (larger.next != null && smallerPre != null){
            smaller = smallerPre.next;
            moveSmallerNodeBefore(largerPre,smallerPre);
            largerPre = smaller;
            smallerPre = findFirstSmallerNodePre(larger,x);
        }

        return head;
    }

    private ListNode findFirstGreaterNodePre(ListNode head, int x){
        if (head == null || head.next == null) return null;
        ListNode current = head;
        while (current.next.val < x){
            current = current.next;
            if (current.next == null)
                return null;
        }


        return current;
    }

    private ListNode findFirstSmallerNodePre(ListNode head, int x){
        if (head == null || head.next == null) return null;
        ListNode current = head;
        while (current.next.val >= x){
            current = current.next;
            if (current.next == null)
                return null;
        }

        return current;
    }

    private void moveSmallerNodeBefore(ListNode largerPre, ListNode smallerPre) {
        ListNode larger = largerPre.next;
        ListNode smaller = smallerPre.next;

        largerPre.next = smaller;
        smallerPre.next = smaller.next;
        smaller.next = larger;
    }

    public void add(int val){
        ListNode node = new ListNode(val);
        if (head == null){
            head = end = node;
            return;
        }
        end.next = node;
        end = node;
    }

}
