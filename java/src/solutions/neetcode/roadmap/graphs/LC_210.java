package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.*;

public class LC_210 implements Solution {
    @Override
    public void solve() {
        int num = 4;
        int[][] prerequisites = new int[][]{
                new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 1}, new int[]{3, 2}
        };
        System.out.println("Solution: " + Arrays.toString(this.findOrder(num, prerequisites)));
    }

    private int[] findOrder(int numCourses, int[][] prerequisites) {
        // Course, List of Its prerequisites
        // build adjacency list of prereqs
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.putIfAbsent(i, new HashSet<>());
        }
        for (int[] crsPre : prerequisites) {
            int crs = crsPre[0];
            int pre = crsPre[1];
            preMap.get(crs).add(pre);
        }
        // a course has 3 possible states:
        // visited -> crs is in the output
        // visitng -> crs not added to output but added to cycle
        // unvisited -> crs not added to output or cycle
        List<Integer> output = new ArrayList<>();
        Set<Integer> cycleSet = new HashSet<>(); // To detect cycles during dfs
        Set<Integer> visitSet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!this.dfs(preMap, output, visitSet, cycleSet, i)) {
                return new int[0];
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(Map<Integer, Set<Integer>> preMap, List<Integer> output, Set<Integer> visitSet,
                        Set<Integer> cycleSet, int crs) {
        if (cycleSet.contains(crs)) {
            return false;
        }
        if (visitSet.contains(crs)) {
            return true;
        }
        cycleSet.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!this.dfs(preMap, output, visitSet, cycleSet, pre)) {
                return false;
            }
        }
        visitSet.add(crs);
        cycleSet.remove(crs);
        output.add(crs);
        return true;
    }
}