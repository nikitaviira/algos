package com.company;

import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] A) {
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        int n = A.length;

        for(int i = 1; i < A.length; i++){
            if(A[i][0] <= A[i-1][1]) {
                A[i][1] = Math.max(A[i-1][1], A[i][1]);
                A[i][0] = A[i-1][0];
                A[i-1][0] = A[i-1][1] = -1;
                n--;
            }
        }

        int[][] ans = new int[n][2];
        int i = 0;

        for(int[] a : A){
            if(a[0] != -1){
                ans[i][0] = a[0];
                ans[i][1] = a[1];
                i++;
            }
        }

        return ans;
    }
}
