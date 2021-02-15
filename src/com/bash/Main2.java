package com.bash;

public class Main2 {

    public static void main(String[] args) {
        int[] arr = {1,9,8,2,3,7,6,4,5};
        System.out.println(getWinner(arr, 7));
    }


    public static int getWinner(int[] arr, int k) {
        int len = arr.length;
        int max = arr[0];
        int count = 0;
        for (int i=1;i<len;i++){
            if(arr[i]>max){
                count=1;
                max=arr[i];
            }else if(arr[i]<max){
                count++;
            }

            if(count==k){
                break;
            }
        }
        return max;
    }
}

