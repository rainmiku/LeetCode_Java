package com.package1;

public class LC1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];

        int i = 0,current=0;
        while (true){
            people[i++] = current++;
            if (i == num_people) i = 0;
            candies -= current;
            if (candies <=0){
                people[i] = current;
                break;
            }
        }
        return people;
    }
}
