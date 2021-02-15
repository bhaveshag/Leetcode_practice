package com.bash;

public class KthMissingPositiveInteger {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(findKthPositive(arr, 2));
    }


    public static int findKthPositive(int[] arr, int k){
        int len = arr.length;

        int last = 1;
        for (int i=0;i<len;i++){
            int diff = arr[i]-last;
            if( diff >= k) {
                return last + k -1;
            }
            k = k-diff;
            last = arr[i] + 1;
        }

        return arr[len-1] + k;
    }
}

