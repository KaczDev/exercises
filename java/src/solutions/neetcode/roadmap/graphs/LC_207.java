package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class LC_207 implements Solution {
    @Override
    public void solve() {
        int courses1 = 2;
        int[][] prerequisites1 = new int[][]{new int[]{1, 0}};
        System.out.println("Solution: " + this.canFinish(courses1,prerequisites1));
        int courses2 = 2;
        int[][] prerequisites2 = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
        System.out.println("Solution: " + this.canFinish(courses2,prerequisites2));
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        // Course, List of Its prerequisites
        Set<Integer> visitSet = new HashSet<>(); // To detect cycles during dfs
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.putIfAbsent(i, new HashSet<>());
        }
        // run dfs on 0..numCourses-1 to find a cycle
        for (int[] crsPre : prerequisites) {
            int crs = crsPre[0];
            int pre = crsPre[1];
            preMap.get(crs).add(pre);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!this.dfs(preMap, visitSet, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> preMap, Set<Integer> visitSet, int crs) {
        if (visitSet.contains(crs)) {
            return false;
        }
        if (preMap.get(crs).isEmpty()) {
            return true;
        }
        visitSet.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!this.dfs(preMap, visitSet, pre)) {
                return false;
            }
        }
        preMap.get(crs).clear();
        visitSet.remove(crs);
        return true;
    }
}
