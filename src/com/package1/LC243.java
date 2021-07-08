package com.package1;

public class LC243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int ans = wordsDict.length+1;
        int lastPos = -1;
        for(int i=0;i<wordsDict.length;i++){
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)){
                if (lastPos != -1 && !wordsDict[i].equals(wordsDict[lastPos])){
                    System.out.println(wordsDict[i]+"," + wordsDict[lastPos]);
                    ans = Math.min(ans, i-lastPos);
                }
                lastPos = i;
            }
        }
        return ans;
    }
}
