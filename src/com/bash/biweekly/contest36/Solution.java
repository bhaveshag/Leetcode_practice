package com.bash.biweekly.contest36;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static List<String> alertNames(String[] keyName, String[] keyTime) {

        Map<String, Sub> map = new HashMap<>();
        Set<String> set = new TreeSet<>();

        for (int i=0;i<keyName.length;i++) {
            if(map.containsKey(keyName[i])){
                Sub s = map.get(keyName[i]);
                String currTime = keyTime[i];
                LocalTime time = LocalTime.parse(currTime);
                int lastHour =s.getDateTime().getHour() ;
                int currhour = time.getHour();

                if(lastHour > currhour ){
                    currhour  = currhour + 24;
                }

                if(Duration.between(s.getDateTime(), time).toMinutes() <= 60 ){
                    s.setCount(s.getCount() + 1);
                    if(s.getCount() >= 3){
                        set.add(keyName[i]);
                    }
                }

                //if(currhour - lastHour < 1 || (currhour - lastHour == 1  && time.getMinute() == 0)){

                //}


                else{

                    Sub s1 = new Sub();
                    LocalTime time1 = LocalTime.parse(keyTime[i]);
                    System.out.println("time1 = " + time1);
                    //time1 = time1.minusMinutes(time1.getMinute());
                    s.setDateTime(time1);
                    s.setCount(1);
                    map.put(keyName[i], s);
                }
            }else {
                Sub s = new Sub();
                LocalTime time = LocalTime.parse(keyTime[i]);
                //time = time.minusMinutes(time.getMinute());
                s.setDateTime(time);
                s.setCount(1);
                map.put(keyName[i], s);
            }

        }
        return set.stream().collect(Collectors.toList());
    }


    public static void main(String[] ar){
        String[] keyName = {"leslie","leslie","leslie","clare","clare","clare","clare"};

        String[] keyTime = {"13:00","13:20","14:00","18:00","18:51","19:30","19:49"};

        System.out.println("Solution.alertNames(keyName, keyTime) = " + Solution.alertNames(keyName, keyTime));

    }

    static class Sub{
        LocalTime dateTime;
        int count = 0;

        public LocalTime getDateTime() {
            return dateTime;
        }

        public void setDateTime(LocalTime dateTime) {
            this.dateTime = dateTime;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}