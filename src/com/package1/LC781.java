package com.package1;

import java.util.HashMap;

public class LC781 {
    public int numRabbits(int[] answers) {
        if (answers.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int answer:answers) {
            map.put(answer,map.getOrDefault(answer,0)+1);
        }

        for (int ans : map.keySet()) {
            int count = map.get(ans);
            if (ans >= count)
                result += ans+1;
            else {
                int pair = count / (ans+1);
                if (count % (ans+1) != 0) pair++;
                result += pair*(ans+1);
            }
        }
        return result;
    }
}
