package com.package1;

public class LC977 {
    public int[] sortedSquares(int[] A) {
        int[] squares = new int[A.length];

        int i = A.length-1;
        int left = 0, right = A.length-1;

        while (i >= 0){
            int leftSqr = A[left] * A[left];
            int rightSqr = A[right] * A[right];

            if (leftSqr > rightSqr){
                squares[i--] = leftSqr;
                left++;
            }
            else {
                squares[i--] = rightSqr;
                right--;
            }

        }

        return squares;
    }
}
