package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class LC_139 implements Solution {
    @Override
    public void solve() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println("Solution: " + this.wordBreak(s, wordDict));
        s = "applepenapple";
        wordDict = List.of("apple", "pen");
        System.out.println("Solution: " + this.wordBreak(s, wordDict));
        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        System.out.println("Solution: " + this.wordBreak(s, wordDict));
    }

    // Time: O(n^2 * m)
    private boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length()
                        && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
