package com.package1;

import java.util.HashMap;

public class LC138 {
    public TNode copyRandomList(TNode head) {

        if (head == null) return null;

        TNode headCopy = new TNode(head.val,null,null);
        TNode current = head;
        TNode currentCopy = headCopy;

        HashMap<TNode, TNode> map = new HashMap<>();

        while (current.next!=null)
        {
             currentCopy.next = new TNode(current.next.val, null, null);
             map.put(current,currentCopy);
             current = current.next;
             currentCopy = currentCopy.next;
        }
        map.put(current,currentCopy);

        current = head;
        currentCopy = headCopy;

        while (current != null){
            if (current.random == null){
                current = current.next;
                currentCopy = currentCopy.next;
                continue;
            }

            currentCopy.random = map.get(current.random);

            current = current.next;
            currentCopy = currentCopy.next;

        }

        return headCopy;
    }
}
