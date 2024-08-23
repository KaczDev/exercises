package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.*;

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

    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<Cord> q = new ArrayDeque<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (isChest(grid, r, c)) {
                    q.add(new Cord(r, c));
                    visited[r][c] = true;
                }
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Cord c = q.removeFirst();
                grid[c.r][c.c] = dist;

                addRoom(visited, grid, q, c.r + 1, c.c);
                addRoom(visited, grid, q, c.r - 1, c.c);
                addRoom(visited, grid, q, c.r, c.c + 1);
                addRoom(visited, grid, q, c.r, c.c - 1);
            }
            dist += 1;
        }
    }

    private void addRoom(boolean[][] visited, int[][] grid, Deque<Cord> q, int r, int c) {
        if (r < 0 || r >= grid.length
                || c < 0 || c >= grid[0].length || visited[r][c] || isWater(grid, r, c)) {
            return;
        }
        visited[r][c] = true;
        q.addLast(new Cord(r, c));
    }

    private boolean isWater(int[][] g, int r, int c) {
        return g[r][c] == -1;
    }

    private boolean isChest(int[][] g, int r, int c) {
        return g[r][c] == 0;
    }
}
