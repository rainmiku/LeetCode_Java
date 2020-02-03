package com.package1;

public class LC1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];

        int i = 0,current=1;
        while (true){
            people[i++] += current++;
            if (i == num_people) i = 0;
            candies -= current;
            if (candies <=0){
                people[i] += candies+current-1;
                break;
            }
        }
        return people;
    }
}
