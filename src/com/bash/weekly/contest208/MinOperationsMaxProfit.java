package com.bash.weekly.contest208;

public class MinOperationsMaxProfit {

    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        long sum = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += (long)customers[i];
        }

        long wholeIterations = (sum/4);
        long partialIterations = sum%4>0?1:0;
        long totalIterations  = wholeIterations + partialIterations ;
        long partialNum = sum%4;

        long ans = 0;


            long ans1 = (sum*boardingCost - totalIterations*runningCost);

            long ans2 = (sum-partialNum)*boardingCost - wholeIterations*runningCost;

            if(ans < 0){
                return -1;
            }
        if(ans1>ans2){
            return (int)totalIterations;
        }
        else {
            return (int)totalIterations-1;
        }




    }

    public static void main(String[] args) {

        int[] logs = new int[]{10,10,6,4,7};


        System.out.println(minOperationsMaxProfit(logs, 3, 8));
    }
}
