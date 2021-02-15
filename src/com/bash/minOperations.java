package com.bash;

public class minOperations {

    public static void main(String[] args) {

        System.out.println(minOperations(6));
    }

    public static int minOperations(int n) {
        if(n==1) return 0;
        if(n==2) return 2;
        int nby2 = n/2;
        if(n%2 == 0) {
            return nby2*nby2;
        }else{
            return nby2*nby2 + nby2;
        }
    }

}
