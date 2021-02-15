package com.bash.contest204;

public class asd {
    public static void main(String[] args) {

        int[] arr = {1,2,3,5,-6,4,0,10};
        System.out.println(getMaxLen(arr));
    }

    public static int getMaxLen(int[] nums) {
        int max_so_far = 0;
        int max_curr = 0;
        boolean neg = false;
        int start = -1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                
                neg = neg == false ? true : false;
            }
            if (start == -1) {
                
                start = i;
                end = i;
            }
            if (nums[i] == 0) {
                
                max_curr = 0;
                if (neg == true) {
                    max_so_far = Math.max(checkLeftAndRight(nums, start, end), max_so_far);
                }
                start = -1;
                neg = false;
            }else {
                max_curr++;
                end = i;
            }
            if(neg == false) {
                max_so_far = Math.max(max_curr, max_so_far);
                
            }

            
            
        }
        if (neg == true) {
            max_so_far = Math.max(max_so_far,checkLeftAndRight(nums, start, end));
        }
        return max_so_far;
    }

    public static int checkLeftAndRight(int[] nums, int st, int en) {
        int start = st;
        int end = en;
        while (start <= end) {
            if (nums[start] < 0) {
                break;
            }
            start++;
        }
        int max = end - start;
        start = st;
        end = en;
        while (start <= end) {
            if (nums[end] < 0) {
                break;
            }
            end--;
        }
        int new_max = end - start;
        
        return Math.max(max, new_max);
    }

}
