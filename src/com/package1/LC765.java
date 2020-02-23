package com.package1;

import java.util.Arrays;
import java.util.HashMap;

public class LC765 {
    public int minSwapsCouples(int[] row) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            map.put(row[i],i);
        }
        int swaps = 0;
        for (int j = 0; j < row.length /2; j++) {
            int i = j*2;
            int coup = (row[i] % 2 == 0) ? row[i]+1 : row[i]-1;
            if (row[i+1] != coup) {
                swaps++;
                map.put(row[i + 1], map.get(coup));
                swap(row, i + 1, map.get(coup));
            }
        }
        System.out.println(Arrays.toString(row));

        return swaps;
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
