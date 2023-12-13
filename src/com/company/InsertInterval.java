package com.company;

import java.util.Arrays;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        newIntervals[newIntervals.length - 1] = new int[] { newInterval[0], newInterval[1] };
        Arrays.sort(newIntervals, (a, b) -> a[0] - b[0]);

        int n = newIntervals.length;

        for(int i = 1; i < newIntervals.length; i++){
            if(newIntervals[i][0] <= newIntervals[i-1][1]) {
                newIntervals[i][1] = Math.max(newIntervals[i-1][1], newIntervals[i][1]);
                newIntervals[i][0] = newIntervals[i-1][0];
                newIntervals[i-1][0] = newIntervals[i-1][1] = -1;
                n--;
            }
        }

        int[][] ans = new int[n][2];
        int i = 0;

        for(int[] a : newIntervals){
            if(a[0] != -1){
                ans[i][0] = a[0];
                ans[i][1] = a[1];
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][] { new int[]{1, 3}, new int[]{6,9} }, new int[]{2,5})));
    }
}
