package com.package1;

import java.util.ArrayList;
import java.util.List;

public class LC901 {

    private class Stock {
        int val;
        int span;
        public Stock(int val,int span){
            this.val = val;
            this.span = span;
        }
    }

    List<Stock> stocks = new ArrayList<>();
//    public LC901() {
//    }

    public int next(int price) {
        Stock lastest = new Stock(price,1);
        stocks.add(lastest);
        if (stocks.size() == 1) return lastest.span;
        int current = stocks.size()-2;
        while (stocks.get(current).val <= price){
            lastest.span += stocks.get(current).span;
            current = current - stocks.get(current).span;
            if (current < 0) break;
        }
        return lastest.span;
    }
}
