package com.CK;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        int toFirst = 0, inBetween = 0, lastIdx = seats.length - 1, prevIdx = -1;
        boolean isFirst = true;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) continue;
            if (isFirst) {
                toFirst = i;
                prevIdx = i;
                lastIdx = i;
                isFirst = false;
                continue;
            }

            lastIdx = i;
            inBetween = Math.max(inBetween, (lastIdx - prevIdx) / 2);
            prevIdx = i;
        }
        return Math.max(toFirst, Math.max(inBetween, seats.length - 1 - lastIdx));
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;
    }
}