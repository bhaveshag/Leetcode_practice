package com.bash.contest230;

import java.util.List;

public class CountMatches {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};
        //System.out.println(countMatches(arr, 0, 0, 1));
    }


    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> list : items) {

            if (ruleKey.equals("type")) {
                if (ruleValue.equals(list.get(0))) {
                    count++;
                }
            } else {
                if (ruleKey.equals("color")) {
                    if (ruleValue.equals(list.get(1))) {
                        count++;
                    }
                } else {
                    if (ruleValue.equals(list.get(2))) {
                        count++;
                    }
                }

            }
        }
        return count;
    }

}

