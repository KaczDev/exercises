package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_200 implements Solution {

    @Override
    public void solve() {
        char[][] grid = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        System.out.println("Solution: " + this.numIslands(grid));
    }

    // BFS
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int islands = 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isLand(grid, r, c) && !visited[r][c]) {
                    islands += 1;
                    bfs(grid, visited, r, c);
                }
            }
        }
        return islands;
    }

    record Cords(int r, int c) {
    }

    Cords[] directions = new Cords[]{new Cords(1, 0), new Cords(-1, 0), new Cords(0, 1), new Cords(0, -1)};

    private void bfs(char[][] grid, boolean[][] visited, int r, int c) {
        Deque<Cords> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.push(new Cords(r, c));
        while (!q.isEmpty()) {
            //If you do popLast() it's dfs.
            Cords cord = q.removeFirst();
            for (Cords d : directions) {
                r = cord.r + d.r;
                c = cord.c + d.c;
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
                        && isLand(grid, r, c) && !visited[r][c]) {
                    q.push(new Cords(r, c));
                    visited[r][c] = true;
                }
            }
        }
    }

    private boolean isLand(char[][] grid, int r, int c) {
        return grid[r][c] == '1';
    }
}
