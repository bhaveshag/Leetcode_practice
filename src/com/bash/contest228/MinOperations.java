package com.bash.contest228;

public class MinOperations {
    public int minOperations(String s) {
        if(s.length() == 1){
            return 0;
        }
        char[] ar = s.toCharArray();
        int count =0;
        //Starting with 0
        for (int i = 0; i < ar.length; i++) {
            if(i%2==0){
                if(ar[i]!= '0'){
                    count++;
                }
            }else{
                if(ar[i] == '0'){
                    count++;
                }
            }
        }
        int preCount = count;
        count=0;
        //Starting with 1
        for (int i = 0; i < ar.length; i++) {
            if(i%2!=0){
                if(ar[i]!= '0'){
                    count++;
                }
            }else{
                if(ar[i] == '0'){
                    count++;
                }
            }
        }
        return Math.min(preCount, count);
    }
    public static void main(String[] args) {
        MinOperations obj = new MinOperations();
        System.out.println(obj.minOperations("10010100"));
    }
}
