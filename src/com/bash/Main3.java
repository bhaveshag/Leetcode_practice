//package com.bash;
//
//public class Main3 {
//
//    public static void main(String[] args) {
//        int[][] arr = {{0,0,1},{1,1,0},{1,0,0}};
//        System.out.println(getWinner(arr));
//    }
//
//    public static int getWinner(int[][] arr) {
//        int len = arr[0].length;
//        int swap = 0;
//        if (checkDiagonal(arr)){
//            return 0;
//        }
//        int[] rows = new int[];
//        int req = len-1;
//
//        for(int i = 0; i < req; i++){
//            int row = -1;
//            for (int j=0; j<len; j++){
//                int zeros = 0;
//                boolean flag = true;
//                for (int k=i+1;k<len;k++){
//                    if(arr[j][k] != 0){
//                        flag=false;
//                        break;
//                    }
//                }
//                if(flag == true){
//                    if(row > )
//                }
//            }
//        }
//    }
//
//    public static boolean checkDiagonal(int[][] arr) {
//        int len = arr[0].length;
//        for (int i=0;i<len;i++){
//            for (int j=i+1;j<len;j++){
//                if(arr[i][j] != 0){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//}
//
