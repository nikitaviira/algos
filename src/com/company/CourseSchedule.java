package com.company;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (adj.containsKey(prerequisite[0])) {
                adj.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                adj.put(prerequisite[0], new ArrayList<>(List.of(prerequisite[1])));
            }
        }

        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visiting, adj)) {
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(int current, Set<Integer> visiting, Map<Integer, List<Integer>> adj) {
        if (visiting.contains(current)) {
            return false;
        }

        if (!adj.containsKey(current) || adj.get(current).isEmpty()) {
            return true;
        }

        visiting.add(current);
        for (Integer i : adj.get(current)) {
            if (!dfs(i, visiting, adj)) {
                return false;
            }
        }
        visiting.remove(current);

        adj.put(current, new ArrayList<>());
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}}));
    }
}
