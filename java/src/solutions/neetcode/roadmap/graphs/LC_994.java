package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_994 implements Solution {
    @Override
    public void solve() {
        int[][] grid = new int[][]{new int[]{2, 1, 1}, new int[]{1, 1, 0}, new int[]{0, 1, 1}};
        System.out.println("Solution: "+ this.orangesRottingNeetCode(grid));
    }

    public int orangesRottingNeetCode(int[][] grid) {
        // BFS for each rotten orange
        // find neigbhours
        // add them to Queue and go like this.
        // how many iterations over Q, this many minutes?
        Deque<Cord> q = new ArrayDeque<>();
        int freshOranges = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.addLast(new Cord(r, c));
                } else if (grid[r][c] == 1) {
                    freshOranges += 1;
                    // keep track of how many oranges should we rotten
                    // if we don't have it ==0 it means
                    // there must be an orange we didn't reach
                }
            }
        }
        int minutes = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Cord rotten = q.removeFirst();
                for (Cord dir : directions) {
                    int r = rotten.r + dir.r;
                    int c = rotten.c + dir.c;
                    if (r < 0 || r == grid.length
                            || c < 0 || c == grid[0].length
                            || grid[r][c] != 1) {
                        continue;
                    }
                    grid[r][c]=2;
                    q.addLast(new Cord(r, c));
                    freshOranges -= 1;
                }
            }
            minutes += 1;
        }
        if (freshOranges != 0) {
            return -1;
        }
        return minutes;
    }

    Cord[] directions = new Cord[]{new Cord(1, 0), new Cord(-1, 0), new Cord(0, 1), new Cord(0, -1)};

    private int orangesRotting(int[][] grid) {
        // BFS for each rotten orange
        // find neigbhours
        // add them to Queue and go like this.
        // how many iterations over Q, this many minutes?
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<Cord> q = new ArrayDeque<>();
        int freshOranges = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.addLast(new Cord(r, c));
                    visited[r][c] = true;
                    freshOranges += 1; //we add it as a regular orange
                    //that rots in let's say minute -1;
                    // when we pop it we decrement this value
                } else if (grid[r][c] == 1) {
                    freshOranges += 1;
                    //keep track of how many oranges should we rotten
                    // if we don't have it ==0 it means
                    // there must be an orange we didn't reach
                }
            }
        }
        int minutes = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Cord rotten = q.removeFirst();
                freshOranges -= 1;
                int r = rotten.r;
                int c = rotten.c;
                this.addCord(grid, visited, q, r + 1, c);
                this.addCord(grid, visited, q, r - 1, c);
                this.addCord(grid, visited, q, r, c + 1);
                this.addCord(grid, visited, q, r, c - 1);
            }
            if (!q.isEmpty()) {
                minutes += 1;
            }
        }
        if (freshOranges != 0) {
            return -1;
        }
        return minutes;
    }

    private void addCord(int[][] grid, boolean[][] visited, Deque<Cord> q, int r, int c) {
        if (r < 0 || r == grid.length || c < 0
                || c == grid[0].length
                || visited[r][c]
                || grid[r][c] != 1) {
            return;
        }
        q.addLast(new Cord(r, c));
        visited[r][c] = true;
    }

    record Cord(int r, int c) {
    }
}
