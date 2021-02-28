package com.bash.contest230;

import java.util.ArrayList;
import java.util.List;

public class ClosestCost {

    public static void main(String[] args) {
        int[] baseCosts = {3};
        int[] toppingCosts = {4, 5, 100};

        System.out.println(closestCost(baseCosts, toppingCosts, 18));
    }


    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int sum = 0;
        int max_so = -34567845;
        List<Integer> sms = new ArrayList<>();
        for (int i = 0; i < baseCosts.length; i++) {
            sum = baseCosts[i];
            sms.add(sum);
            recur(toppingCosts, 0, target * 2, sum, sms);
        }
        for (Integer in :
                sms) {
            if (Math.abs(max_so - target) <= Math.abs(in - target)) {
                max_so = max_so;
            } else {
                max_so = in;
            }
        }
        return max_so;
    }

    private static void recur(int[] toppingCosts, int j, int target, int sum, List<Integer> sms) {

        if (sum > target) {
            return;
        }
        //System.out.println("sum = " + sum);
        sms.add(sum);
        int curr = sum;
        for (int i = j; i < toppingCosts.length; i++) {
            recur(toppingCosts, i + 1, target, curr + toppingCosts[i], sms);
            recur(toppingCosts, i + 1, target, curr + 2 * toppingCosts[i], sms);
        }
    }
}

