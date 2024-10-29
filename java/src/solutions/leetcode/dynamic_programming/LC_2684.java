package solutions.leetcode.dynamic_programming;

import solutions.Solution;

public class LC_2684 implements Solution {
    @Override
    public void solve() {
        int[][] grid = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        System.out.println("Solution: " + this.maxMoves(grid));
        int[][] grid2 = {{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};
        System.out.println("Solution: " + this.maxMoves(grid2));
    }

    int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};

    private int maxMoves(int[][] grid) {
        int max = 0;
        if (grid.length == 0) {
            return max;
        }
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] dp = new int[ROWS][COLS];
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            int res = dfs(grid, dp, visited, i, 0);
            max = Math.max(max, res);
        }

        return max;
    }

    private int dfs(int[][] grid, int[][] dp, boolean[][] visited, int r, int c) {
        if (visited[r][c]) {
            return dp[r][c];
        }
        visited[r][c] = true;
        int maxMoves = 0;
        for (int[] dir : dirs) {
            int r2 = r + dir[0];
            int c2 = c + dir[1];
            if (r2 < 0 || r2 >= grid.length || c2 < 0 || c2 >= grid[0].length || grid[r2][c2] <= grid[r][c]) {
                continue;
            }
            maxMoves = Math.max(1 + dfs(grid, dp, visited, r2, c2), maxMoves);
        }
        dp[r][c] = maxMoves;
        return maxMoves;
    }
}

