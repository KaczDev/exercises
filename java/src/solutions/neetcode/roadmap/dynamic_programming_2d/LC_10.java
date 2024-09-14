package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC_10 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.isMatch("aa", "a"));
        System.out.println("Solution: " + this.isMatch("aa", "a*"));
        System.out.println("Solution: " + this.isMatch("ab", ".*"));
    }

    // Top-Down Memoization
    // Time: O(mn)
    // Space: O(mn)
    private boolean isMatch(String s, String p) {
        Map<Cord, Boolean> dp = new HashMap<>();
        return dfs(s, p, dp, 0, 0);
    }

    private boolean dfs(String s, String p, Map<Cord, Boolean> dp, int i, int j) {
        Cord c = new Cord(i, j);
        if (dp.containsKey(c)) {
            return dp.get(c);
        }
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        boolean match = i < s.length() ? (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') : false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean res = dfs(s, p, dp, i, j + 2) || // don't use *
                    (match && dfs(s, p, dp, i + 1, j));// use *
            dp.put(c, res);
            return dp.get(c);
        }
        if (match) {
            dp.put(c, dfs(s, p, dp, i + 1, j + 1));
            return dp.get(c);
        }
        dp.put(c, false);
        return false;
    }

    record Cord(int i, int j) {
    }

}
