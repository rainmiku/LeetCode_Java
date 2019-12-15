package com.package1;

import java.util.HashMap;

public class LC138 {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node headCopy = new Node(head.val,null,null);
        Node current = head;
        Node currentCopy = headCopy;

        HashMap<Node,Node> map = new HashMap<>();

        while (current.next!=null)
        {
             currentCopy.next = new Node(current.next.val, null, null);
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
