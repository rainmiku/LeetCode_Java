package com.package1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC023 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = new ListNode(0);

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val - b.val));

        for (var list:lists){
            if (list != null) pq.add(list);
        }

        ListNode last = pre;

        while(!pq.isEmpty()){
            ListNode current = pq.poll();
            last.next = current;
            last = last.next;
            if (current.next != null){
                pq.add(current.next);

            }
        }

        return pre.next;
    }
}
