package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

public class LC_1143 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.longestCommonSubsequence("abcde", "ace"));
        System.out.println("Solution: " + this.longestCommonSubsequence("abc", "def"));
    }

    //Time: O(text1.len * text2.len) => O(n*m)
    //Space: O(n*m)
    private int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // we especiialy initialized dp with +1 lengths
                    // so they return zero if we were to go out of bounds
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
