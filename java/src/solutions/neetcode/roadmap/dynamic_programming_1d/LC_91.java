package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC_91 implements Solution {
    @Override
    public void solve() {

        System.out.println("Solution: " + this.numDecodingsDP("226"));
        System.out.println("Solution: " + this.numDecodingsMemo("226"));
    }
    //Dynamic Programming solution
    // Time: O(n)
    // Space: O(1)

    public int numDecodingsDP(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp.put(i, 0);
            } else {
                dp.put(i, dp.get(i + 1));
            }
            if (i + 1 < s.length() && (s.charAt(i) == '1'
                    || s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                dp.put(i, dp.get(i) + dp.get(i + 2));
            }
        }
        return dp.get(0);
    }

    // Memoization solution
    // Time: O(n)
    // Space: O(n)
    public int numDecodingsMemo(String s) {
        // idx, combinations
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return this.dfs(s, dp, 0);
    }

    private int dfs(String s, Map<Integer, Integer> dp, int i) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int res = dfs(s, dp, i + 1);
        if (i + 1 < s.length() && (s.charAt(i) == '1'
                || s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
            res += dfs(s, dp, i + 2);
        }
        dp.put(i, res);
        return res;
    }
}
