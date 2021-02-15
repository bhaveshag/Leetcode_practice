package com.bash.weekly.contest208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinOperations {
    public static void main(String[] args) {

        String[] logs = new String[]{"d1/","d2/","./","d3/","../","d31/"};

        System.out.println(minOperations(logs));
    }
    public static int minOperations(String[] logs) {
        int count=0;
        for (int i = 0; i < logs.length; i++) {
            if(logs[i].equalsIgnoreCase("../")){
                if(count==0){
                    count=0;
                }else{
                    count--;
                }
            }else if (logs[i].equalsIgnoreCase("./")) {

                    //do nothing
            } else {
                count++;
            }

        }
        return  count;
    }

}
