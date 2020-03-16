package com.package1;

public class LC744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length-1;

        while (start <= end){
            int mid = start + (end-start)/2;
            if (letters[mid] <= target)
                start = mid+1;
            else
                end = mid-1;
        }
        while (start>0 && start < letters.length && letters[start] == letters[start-1])
            start++;

        return letters[start % letters.length];

    }
}
