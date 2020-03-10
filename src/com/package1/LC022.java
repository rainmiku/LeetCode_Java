package com.package1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class LC022 {
    static class Pair{
        String str;
        int left;
        int right;

        Pair(String str, int left, int right){
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair("", 0, 0));
        while (!queue.isEmpty()){
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                Pair p = queue.poll();
                if (p.left == p.right && p.left == n){
                   result.add(p.str);
                }
                else {
                    if (p.left < n)
                        queue.offer(new Pair(p.str + "(", p.left + 1, p.right));
                    if (p.right < p.left)
                        queue.offer(new Pair(p.str + ")", p.left, p.right + 1));
                }
            }
        }
        return result;
    }
}
