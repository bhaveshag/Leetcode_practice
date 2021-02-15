package com.bash.contest217;

import java.util.HashMap;
import java.util.Map;

public class MinMoves {
    public static void main(String[] args) {

        int[] arr = {1,2,4,3};
        System.out.println(minMoves(arr, 4));
    }

    public static int minMoves(int[] nums, int limit) {
        int most = 0;
        int n= nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i] + nums[n-1-i];
            if (map.containsKey(sum)){
                int count =map.get(sum);
                map.put(sum, count+1);
            }else{
                map.put(sum, 1);
            }

        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > most){
                most = entry.getValue();
            }
            
        }
        return most;
    }

}
