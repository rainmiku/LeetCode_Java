package com.package1;

public class LC171 {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for(int i =0;i<columnTitle.length();i++){
            ans = ans * 26 + (columnTitle.charAt(i)-'A'+1);
        }
        return ans;
    }
}
