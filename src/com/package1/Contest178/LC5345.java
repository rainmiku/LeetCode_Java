package com.package1.Contest178;


import java.util.HashMap;

public class LC5345 {
    public String rankTeams(String[] votes) {
        HashMap<Character,int[]> map = new HashMap<>();

        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length(); j++) {
                char ch = votes[i].charAt(j);
                if (!map.containsKey(ch)){
                    map.put(ch, new int[votes[i].length()]);
                }
                map.get(ch)[j]++;
            }
        }

        char[] res = votes[0].toCharArray();

        for (int i = 0; i < res.length - 1; i++) {
            for (int j = i+1; j < res.length; j++) {
                if (!compare(res[i],res[j],map)){
                    char t = res[i];
                    res[i] = res[j];
                    res[j] = t;
                }
            }
        }

        return String.copyValueOf(res);
    }

    private boolean compare(char a, char b, HashMap<Character,int[]> map){
        int[] voteA = map.get(a);
        int[] voteB = map.get(b);

        for (int i = 0; i < voteA.length; i++) {
            if (voteA[i] > voteB[i]) return true;
            if (voteA[i] < voteB[i]) return false;
        }
        return a < b;
    }
}
