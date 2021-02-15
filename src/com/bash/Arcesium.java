package com.bash;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Solution {

    /*
     * Complete the 'getSelectionStatus' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY applications as parameter.
     */

    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
        applications.removeIf(appl -> (Double.valueOf(appl.get(1)) < 5.8));
        System.out.println("application.size()"+applications.size());
        return null;
    }

}


class Player{
    String name;
    Double height;
    Double bmi;
    int scores;
    int defends;


}

public class Arcesium {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int applicationsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int applicationsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> applications = new ArrayList<>();

        IntStream.range(0, applicationsRows).forEach(i -> {
            try {
                applications.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<String>> result = Solution.getSelectionStatus(applications);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}