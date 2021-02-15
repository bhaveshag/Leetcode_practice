package com.bash.contest217;

public class MaximumWealth {
    public static void main(String[] args) {

        int[][] arr = {{1,5},{7,3},{3,5}};
        System.out.println(maximumWealth(arr));
    }

    public static int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int max = -1;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + accounts[i][j];
            }
            max = max < sum ? sum : max;
        }
        return  max;
    }

}
