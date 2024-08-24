package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC_417 implements Solution {
    @Override
    public void solve() {
        int[][] heights = new int[][]{
                new int[]{1, 2, 2, 3, 5},
                new int[]{3, 2, 3, 4, 4},
                new int[]{2, 4, 5, 3, 1},
                new int[]{6, 7, 1, 4, 5},
                new int[]{5, 1, 1, 2, 4}
        };
        System.out.println("Solution: " + this.pacificAtlantic(heights));
    }

    private List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] visitedPac = new boolean[ROWS][COLS];
        boolean[][] visitedAtl = new boolean[ROWS][COLS];
        //Those 2 loops will mark all the cells that can reach Pacific or Atlantic ocean
        for (int c = 0; c < COLS; c++) {
            //go through first row that connects to Pacific
            dfs(0, c, heights, visitedPac, heights[0][c]);
            //go through the last row that connects to Atlantic
            dfs(ROWS - 1, c, heights, visitedAtl, heights[ROWS - 1][c]);
        }

        for (int r = 0; r < ROWS; r++) {
            //for each row get the left most column
            dfs(r, 0, heights, visitedPac, heights[r][0]);
            //for each row get the right most column
            dfs(r, COLS - 1, heights, visitedAtl, heights[r][COLS - 1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (visitedPac[r][c] && visitedAtl[r][c]) {
                    List<Integer> t = new ArrayList<>(2);
                    t.add(r);
                    t.add(c);
                    res.add(t);
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] visited, int prevHeight) {
        if (r < 0 || r == heights.length || c < 0 || c == heights[0].length
                || heights[r][c] < prevHeight || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        this.dfs(r + 1, c, heights, visited, heights[r][c]);
        this.dfs(r - 1, c, heights, visited, heights[r][c]);
        this.dfs(r, c + 1, heights, visited, heights[r][c]);
        this.dfs(r, c - 1, heights, visited, heights[r][c]);
    }
}
