package com.package1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class NestedIterator implements Iterator<Integer> {

    Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> result = new LinkedList<>();

        for (var nested: nestedList) {
            tranverse(result,nested);
        }

        this.it = result.iterator();
    }

    @Override
    public Integer next() {
       return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    private void tranverse(List<Integer> result, NestedInteger nested){
        if (nested.isInteger()){
            result.add(nested.getInteger());
        }
        else if (nested.getList() != null){
            List<NestedInteger> list = nested.getList();
            for (var n : list) {
                tranverse(result,n);
            }
        }
    }

}
