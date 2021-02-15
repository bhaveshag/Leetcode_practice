package com.bash.weekly.contest203;

import java.util.*;

public class MostVisited {
    public static void main(String[] args) {

        int[] rounds = {1,3,5,7};
        System.out.println(mostVisited(7, rounds));
    }
    public static List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int[n+1];

        count[rounds[0]]++;
        for (int i=0;i < rounds.length-1;i++){
            int start = rounds[i]+1;
            int end = rounds[i+1];
            if (end < start){
                end = end + n;
            }
            for (int j = start; j <= end ; j++) {
                if(j>n){
                    count[j-n]++;
                }else{
                    count[j]++;
                }
            }
        }
        int highest=0;
        for (int i = 1; i < n+1; i++) {
            //System.out.println("count[i] "+count[i]);
            if (count[i] > highest){
                highest = count[i];
            }
        }
        List<Integer> list= new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if(count[i] == highest) {
                list.add(i);
            }
        }
        return  list;
    }

}
