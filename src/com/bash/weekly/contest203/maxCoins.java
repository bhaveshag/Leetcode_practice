package com.bash.weekly.contest203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxCoins {
    public static void main(String[] args) {

        int[] rounds = {9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins(rounds));
    }
    public static  int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len = piles.length;
        int start = len-2;
        int sum = 0;
        int j=len/3;
        while (j-- > 0){
            System.out.println(piles[start]);
            sum = sum + piles[start];
            start = start - 2;
        }
        return sum;
    }

}
