package com.bash.contest228;

public class CountHomogenous {
    public static void main(String[] args) {
        CountHomogenous obj = new CountHomogenous();
        System.out.println(obj.countHomogenous("nalfbsdfjnasdkfddddddddddgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggnkdkfnkjdsjjjkndsfkjndjkfnjjndkjfnkdjs"));
    }

    private long substrings(long n){
        long M = 1000000007;
        return (n*(n+1)/2)%M;
    }

    public int countHomogenous(String s) {
        long count = 0;
        long M = 1000000007;
        //Check contiguous strings with same chars of length >=2
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                long countOfSameChar = 2;
                char c = s.charAt(i);
                i++;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == c) {
                        countOfSameChar++;
                    }else{
                        break;
                    }
                }
                count = (count + (substrings(countOfSameChar) - countOfSameChar)%M) % M;
            }

        }
        count = count % M;
        count = (count + s.length()) % M;
        return (int)(count % M);
    }
}
