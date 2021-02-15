package com.bash;

import java.util.ArrayList;
import java.util.List;

public class FindKthBit {

    public static void main(String[] args) {
        String s = "abBAcC";
        System.out.println(findKthBit(20,100));
    }
        public static char findKthBit(int n, int k) {
            List<String> list = new ArrayList<>();
            String s = "0";

            for (int i = 0; i < n; i++) {
               s  = s + '1' + recursive(inverse(s));
            }
            return s.charAt(k-1);
        }

        private static String recursive(String s){
             return new StringBuilder(s).reverse().toString();
        }


    private static String inverse(String s){
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<s.length();i++) {
            if(s.charAt(i) == '1'){
                sb.append('0');
            }else{
                sb.append('1');
            }
        }
        return sb.toString();
    }

}
