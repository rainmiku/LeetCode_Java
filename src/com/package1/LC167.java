package com.package1;

public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length-1; i++) {
            int other = binarySearch(numbers, i+1, target-numbers[i]);
            if (other > 0)
                return new int[]{i+1, other+1};
        }
        return null;
    }

    private int binarySearch(int[] numbers, int start, int target){
        int left = start;
        int right = numbers.length-1;
        while (left <= right){
            int middle = (left+right)/2;
            if (numbers[middle] == target) return middle;
            if (target < numbers[middle])
                right = middle-1;
            else
                left = middle+1;
        }
        return -1;
    }
}
