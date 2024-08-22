package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_695 implements Solution {
    @Override
    public void solve() {
        int[][] grid = new int[][]
                {
                        new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                };
        System.out.println("Solution: " + this.maxAreaOfIslandBFS(grid));
        System.out.println("Solution: " + this.maxAreaOfIslandDFS(grid));
    }

    private int maxAreaOfIslandBFS(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && isLand(grid, r, c)) {
                    int area = this.bfs(grid, visited, r, c);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    record Cords(int r, int c) {
    }

    Cords[] directions = new Cords[]{new Cords(1, 0), new Cords(-1, 0), new Cords(0, 1), new Cords(0, -1)};

    private int bfs(int[][] grid, boolean[][] visited, int r, int c) {
        int area = 1;
        Deque<Cords> q = new ArrayDeque<>();
        q.push(new Cords(r, c));
        visited[r][c] = true;
        while (!q.isEmpty()) {
            Cords cord = q.removeFirst();
            for (Cords d : directions) {
                r = cord.r + d.r;
                c = cord.c + d.c;
                if (r >= 0 && r < grid.length &&
                        c >= 0 && c < grid[0].length &&
                        isLand(grid, r, c) && !visited[r][c]) {
                    area += 1;
                    q.push(new Cords(r, c));
                    visited[r][c] = true;
                }
            }
        }

        return area;
    }

    private boolean isLand(int[][] g, int r, int c) {
        return g[r][c] == 1;
    }
    private int maxAreaOfIslandDFS(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && isLand(grid, r, c)) {
                    int area = this.dfs(grid, visited, r, c);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || isWater(grid, r, c)) {
            return 0;
        }
        visited[r][c] = true;
        return 1
                + dfs(grid, visited, r + 1, c)
                + dfs(grid, visited, r - 1, c)
                + dfs(grid, visited, r, c + 1)
                + dfs(grid, visited, r, c - 1);
    }

    private boolean isWater(int[][] g, int r, int c) {
        return g[r][c] == 0;
    }

}
