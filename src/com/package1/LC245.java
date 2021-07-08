package com.package1;

public class LC245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int lastPos = -1;
        int ans = Integer.MAX_VALUE;

        for(int i =0; i< wordsDict.length;i++){
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)){
                if (lastPos !=-1 && (word1.equals(word2) || !wordsDict[i].equals(wordsDict[lastPos]))){
                    ans = Math.min(ans, i-lastPos);
                }
                lastPos = i;
            }
        }
        return ans;
    }
}
