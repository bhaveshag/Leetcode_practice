package com.bash.contest204;

public class maxCoins {
    public static void main(String[] args) {

        int[] arr = {2,2};
        System.out.println(containsPattern(arr, 1, 2));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length;
        if (m * k > len) return false;
        int count = 0;
        for (int i = 0; i < len; i++) {
            count = 1;
            int start = i;
            int end = i + m;
            if (end >len) {
                break;
            }

            for (int x = 1; x < k; x++) {
                boolean flag = true;
                int st = start;
                int en = end;
                int sti = st + m*x;
                int eni = en + m*x;
                if(eni >len ){
                    break;
                }
                System.out.println("i,  x, st, en" + " ," + i + " ," + x + " ," + st + " ," + en);
                for (int j = sti; j < eni && j<len && st < en; j++, st++) {
                    if (arr[st] != arr[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                } else {
                    break;
                }
            }
            if (count >= k) {
                break;
            }
        }
        if (count >= k) {
            return true;
        }
        return false;
    }

}
