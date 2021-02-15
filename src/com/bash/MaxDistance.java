package com.bash;

import java.util.Arrays;

public class MaxDistance {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,1000000000};
        System.out.println(maxDistance(arr, 2));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int hi = 1000000000;
        int lo = 1;

        while (lo < hi) {
            int mi = (lo + hi + 1) / 2; // Read comments if you wanna know why +1 is done.
            System.out.println("mi "+ mi);
            if (check(position, mi, m)) {
                lo = mi;
            } else {
                hi = mi - 1;
            }
        }

        return lo;
    }

    private static boolean check(int[] position, int minimumDistance, int m) {
        // Always place first object at position[0]
        int lastBallPosition = position[0];
        int ballsLeftToBePlaced = m - 1;
        for (int i = 1; i < position.length && ballsLeftToBePlaced != 0; ) {
            if (position[i] - lastBallPosition < minimumDistance) {
                // Try to place the next ball, since this ball isn't minimumDistance away from lastBall
                i++;
            } else {
                // Place the ball only if this ball is farther than the previous ball by minimumDistance
                System.out.println("lastBallPosition "+ lastBallPosition);
                lastBallPosition = position[i];
                ballsLeftToBePlaced--;
            }
        }
        return ballsLeftToBePlaced == 0;
    }
}