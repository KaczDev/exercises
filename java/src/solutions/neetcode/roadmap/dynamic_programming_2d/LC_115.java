package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

import java.util.Arrays;

public class LC_115 implements Solution {
    @Override
    public void solve() {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println("Solution: " + this.numDistinct(s, t));
    }
    // Space: O(n*m)
    // Time: O(n*m)
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length()][t.length()];
        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return dfs(s, t, 0, 0, cache);
    }

    private int dfs(String s, String t, int i, int j, int[][] cache) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            cache[i][j] = dfs(s, t, i + 1, j + 1, cache) + dfs(s, t, i + 1, j, cache);
        } else {
            cache[i][j] = dfs(s, t, i + 1, j, cache);
        }
        return cache[i][j];
    }


}
