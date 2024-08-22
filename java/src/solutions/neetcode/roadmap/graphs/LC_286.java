package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.Arrays;
import java.util.Stack;

public class LC_286 implements Solution {
    @Override
    public void solve() {

        int[][] grid = new int[][]{
                new int[]{2147483647, -1, 0, 2147483647},
                new int[]{2147483647, 2147483647, 2147483647, -1},
                new int[]{2147483647, -1, 2147483647, -1},
                new int[]{0, -1, 2147483647, 2147483647}
        };
        this.islandsAndTreasure(grid);
        System.out.println("Solution: " + Arrays.deepToString(grid));
        int[][] grid2 = new int[][]{{0, -1}, {2147483647, 2147483647}};
        this.islandsAndTreasure(grid2);
        System.out.println("Solution: " + Arrays.deepToString(grid2));
    }

    record Cord(int r, int c) {
    }

    private void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (!visited[r][c] && isLand(grid, r, c)) {
                    Stack<Cord> path = new Stack<>();
                    path.push(new Cord(r, c));
                    visited[r][c] = true;
                    this.dfs(grid, visited, path, r, c);
                }
            }
        }
    }

    private void dfs(int[][] grid, boolean[][] visited, Stack<Cord> path, int r, int c) {
        //TODO

        //Walk the graph

        //When found chest
        //backtrack using path and update grid values with the distance to chest.
    }


    private boolean isLand(int[][] g, int r, int c) {
        return g[r][c] == Integer.MAX_VALUE;
    }

    private boolean isWater(int[][] g, int r, int c) {
        return g[r][c] == -1;
    }

    private boolean isChest(int[][] g, int r, int c) {
        return g[r][c] == 0;
    }
}
