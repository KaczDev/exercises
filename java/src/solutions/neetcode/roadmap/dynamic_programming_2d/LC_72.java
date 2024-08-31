package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

import java.util.Arrays;

public class LC_72 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.minDistance("horse","ros"));
    }
    public int minDistance(String w1, String w2) {
        int[][] dp = new int[w1.length() + 1][w2.length() + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        for (int j = 0; j < w2.length() + 1; j++) {
            dp[w1.length()][j] = w2.length() - j;
        }
        for (int i = 0; i < w1.length() + 1; i++) {
            dp[i][w2.length()] = w1.length() - i;
        }
        for (int i = w1.length() - 1; i >= 0; i--) {
            for (int j = w2.length() - 1; j >= 0; j--) {
                if (w1.charAt(i) == w2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // insert delete replace
                    dp[i][j] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
        // if w1.charAt(i)==w2.charAt(j)
        // i++, j++
        // else
        // insert => j+=1, i stays
        // delete => i+=1, j stays
        // replace => i+1,j+1
    }
}
