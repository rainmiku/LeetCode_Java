package com.package1;

import java.util.HashSet;

public class LC753 {

    public String crackSafe(int n, int k) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sequence.append('0');
        }
        HashSet<String> nodes = new HashSet<>();
        nodes.add(sequence.toString());
        int maxSize = (int) Math.pow(k,n);
        dfs(n,k,nodes, sequence,maxSize);
        return sequence.toString();
    }

    private boolean dfs(int n, int k, HashSet<String> nodes,  StringBuilder sequence, int maxSize){
        if (nodes.size() == maxSize){
            return true;
        }

        String temp = sequence.substring(sequence.length()-n+1);
        for (char i = '0'; i < '0'+k; i++) {
            String suffix = temp + i;
            if (!nodes.contains(suffix))
            {
                sequence.append(i);
                nodes.add(suffix);
                if (dfs(n,k,nodes,sequence,maxSize))
                    return true;  // jump outside as soon as possible or it will TLE
                sequence.deleteCharAt(sequence.length()-1);
                nodes.remove(suffix);
            }
        }
        return false;
    }
}
