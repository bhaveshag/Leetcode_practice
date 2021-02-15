package com.bash;

import java.util.ArrayList;
import java.util.List;

public class MakeGoodString {

    public static void main(String[] args) {
        String s = "abBAcC";
        System.out.println(makeGood(s));
    }
        public static String makeGood(String s) {
            List<String> list = new ArrayList<>();
            for (int i=0; i<s.length();i++){
                list.add( String.valueOf(s.charAt(i)));
            }
            recursive(list);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
            return sb.toString();
        }

        private static void recursive(List<String> list){
            boolean flag=true;
            if(list.size() == 1) return;

            for (int i=1;i<list.size();i++) {
                if(!list.get(i).equals(list.get(i-1)) && list.get(i).toUpperCase().equals(list.get(i-1).toUpperCase())){
                    list.remove(i-1);
                    list.remove(i-1);
                    flag = false;
                    break;
                }
            }
            if(flag == false) {
                recursive(list);
            }
        }

}
