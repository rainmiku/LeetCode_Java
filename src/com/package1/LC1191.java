package com.package1;

public class LC1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {

        int[] doubleArr = new int[arr.length*2];
        long arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            doubleArr[i] = arr[i];
            doubleArr[i+arr.length] = arr[i];
            arrSum += arr[i];
        }

        long sum = 0;
        long preMax = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            preMax = Math.max(preMax,sum);
        }

        sum = 0;
        long afterMax = 0;
        for (int i = arr.length-1; i>=0; i--){
            sum += arr[i];
            afterMax = Math.max(afterMax,sum);
        }

        long max = 0;
        sum = 0;
        for (int num : doubleArr) {
            sum += num;
            sum = Math.max(sum, 0);
            max = Math.max(max, sum);
        }

        if (max <= arrSum*(k-2)+preMax+afterMax || max == arrSum*2) return mod(arrSum*(k-2)+preMax+afterMax);
        return mod(max);
    }

    private int mod(long num){
        return (int) (num % (Math.pow(10,9)+7));
    }
}
