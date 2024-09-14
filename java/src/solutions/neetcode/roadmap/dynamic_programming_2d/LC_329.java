package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

public class LC_329 implements Solution {
    @Override
    public void solve() {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println("Solution: "+this.longestIncreasingPath(matrix));
    }
    // Space: O(m*n)
    // Time: O(m*n)
    private int longestIncreasingPath(int[][] matrix) {
        int[][] lip = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.dfs(matrix, lip, i, j, -1);
            }
        }
        int max = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, lip[i][j]);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] lip, int r, int c, int prevVal) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length
                || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (lip[r][c] != 0) {
            return lip[r][c];
        }
        int res = 1;
        res = Math.max(res, 1 + dfs(matrix, lip, r + 1, c, matrix[r][c]));
        res = Math.max(res, 1 + dfs(matrix, lip, r - 1, c, matrix[r][c]));
        res = Math.max(res, 1 + dfs(matrix, lip, r, c + 1, matrix[r][c]));
        res = Math.max(res, 1 + dfs(matrix, lip, r, c - 1, matrix[r][c]));
        lip[r][c] = res;
        return res;
    }
}
