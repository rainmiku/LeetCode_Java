package com.package1;

public class LC1093 {
    public double[] sampleStats(int[] count) {
        double min=-1,max=0,middle=0,mean,maxcount = 0,mode = 0;
        long sum = 0, amount = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            if (min == -1)
                min = i;
            max = i;
            if (count[i] > maxcount){
                maxcount = count[i];
                mode = i;
            }

            sum += count[i] * i;
            amount += count[i];
        }
        mean = (double)sum / (double)amount;


        int counter = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            counter += count[i];
            if (counter == amount / 2) {
                int k = i+1;
                while (count[k] == 0)
                    k++;
                if (amount % 2 == 0){
                    middle = (k + i) / 2.0;
                    break;
                } else {
                    middle = k;
                }
            }
            if (counter > amount / 2){
                middle = i;
                break;
            }
        }
        return new double[]{min, max, mean, middle,mode};
    }
}
