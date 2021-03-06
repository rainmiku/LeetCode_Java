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

    public int next(int price) {
        Stock latest = new Stock(price,1);
        stocks.add(latest);
        if (stocks.size() == 1) return latest.span;
        int current = stocks.size()-2;
        while (stocks.get(current).val <= price){
            latest.span += stocks.get(current).span;
            current = current - stocks.get(current).span;
            if (current < 0) break;
        }
        return latest.span;
    }
}
