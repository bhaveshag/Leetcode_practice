package com.bash.weekly.contest209;

public class SpecialArray {
    public static int specialArray(int[] nums) {
        for (int i = 1; i < nums.length+1; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] >= i){
                    count++;
                }
            }
            if(count==i){
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] ar){
        int[] keyName = {3,5};

        System.out.println("specialArray(keyName) = " + specialArray(keyName));

    }
}
