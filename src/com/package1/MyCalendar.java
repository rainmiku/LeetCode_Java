package com.package1;


import java.util.LinkedList;
import java.util.List;

//This is for LC729
//using linked list but can also solved by binary search tree;
public class MyCalendar {

    class timePeriod{
        private int start;
        private int end;
        timePeriod next;
        timePeriod pre;

        public timePeriod(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    private timePeriod head;
    private timePeriod tail;

    public MyCalendar() {
        head = new timePeriod(-1,0);
        tail = new timePeriod(Integer.MAX_VALUE,-1);
        head.next = tail;
        tail.pre = head;
    }


    public boolean book(int start, int end) {

        if (head.next == tail) {
            insertAfter(head,new timePeriod(start,end));
            return true;
        }

        timePeriod current = head;
        timePeriod after = current.next;
        while (after!=null) {
            if (current.end <= start && after.start >= end){
                insertAfter(current,new timePeriod(start,end));
                return true;
            }
            current = current.next;
            after = current.next;
        }
        return false;
    }

    private void insertAfter(timePeriod head, timePeriod node){
        timePeriod tail = head.next;
        node.next = tail;
        head.next = node;
        tail.pre = node;
        node.pre = head;
    }

}
