//package com.bash;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class akjsn {
//
//    public static void main(String[] args) {
//        int[] s = {1,1,1,1,1};
//        System.out.println(maxNonOverlapping(s,2));
//    }
//
//    public int maxNonOverlapping(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int res = 0;
//        int n = nums.length;
//
//        int[] suma = new int[n];
//        suma[0]=nums[0];
//        for (int i = 1; i < n; i++) {
//            suma[i] = suma[i-1]+nums[i];
//        }
//        for (int i = 0; i < n; i++) {
//            if(nums[i] == target){
//                map.put(i,i);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j=0;j<i;j++){
//                if(suma[i] - suma[j] == target){
//                    map.put(j, i);
//                }
//            }
//        }
//        HashMap<Integer, Integer> sortedmap = map.entrySet().stream().sorted();
//        return map.size()-1;
//    }
//}
