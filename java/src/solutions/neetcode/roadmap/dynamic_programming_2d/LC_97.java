package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

public class LC_97 implements Solution {
    @Override
    public void solve() {
        String s1 = "dbbca";
        String s2 = "aabcc";
        String s3 = "aadbbcbcac";
        System.out.println("Solution: " + this.isInterleave(s1, s2, s3));
        s3 = "aadbbbaccc";
        System.out.println("Solution: " + this.isInterleave(s1, s2, s3));
    }

    private boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

}
