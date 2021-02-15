package com.bash;

import java.util.ArrayList;
import java.util.List;

public class ThreeConsecutiveOdds {

    public static void main(String[] args) {
        int[] arr = {1,2,34,3,4,5,7,23,12};
        System.out.println(threeConsecutiveOdds(arr));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        int odd = 0;
        for (int i = 0; i < arr.length; i++) {
                if(arr[i]%2 == 1){
                    odd++;
                }else{
                    odd=0;
                }
                if(odd == 3){
                    return true;
                }

        }
        return false;
        }


}
