package com.company;

public class SmallestIntNotInA {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { -1, -3 }));
    }

    // Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
    // For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    // Given A = [1, 2, 3], the function should return 4.
    // Given A = [−1, −3], the function should return 1.

    // Write an efficient algorithm for the following assumptions:
    //  N is an integer within the range [1..100,000];
    //  each element of array A is an integer within the range [−1,000,000..1,000,000].
    public static int solution(int[] A) {
        boolean[] test = new boolean[1_000_000];

        for (int j : A) {
            if (j <= 0 || test[j]) continue;
            test[j] = true;
        }

        for (int i = 1; i < test.length; i++) {
            if (!test[i]) return i;
        }

        return 1;
    }
}
