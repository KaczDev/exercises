package solutions.leetcode.graphs;

import solutions.Solution;

import java.util.*;

public class LC_1905 implements Solution {
    @Override
    public void solve() {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println("Solution: " + this.countSubIslands(grid1, grid2));
        System.out.println("Solution: " + this.countSubIslands2(grid1, grid2));
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // grid1 cord, island number
        Map<Cord, Integer> squareToIsland = new HashMap<>();
        boolean[][] visit1 = new boolean[grid1.length][grid1[0].length];
        // put all squares that belong to island X into the map
        // bfs on grid1
        int island = 0;
        for (int r = 0; r < grid1.length; r++) {
            for (int c = 0; c < grid1[0].length; c++) {
                if (!visit1[r][c] && grid1[r][c] == 1) {
                    this.bfs(grid1, visit1, r, c, island, squareToIsland);
                    island += 1;
                }
            }
        }
        // go over the grid 2 and check if cord is int the map
        // bfs on grid2
        Map<Integer, List<Cord>> islandToSq = new HashMap<>();
        boolean[][] visit2 = new boolean[grid2.length][grid2[0].length];
        island = 0;
        for (int r = 0; r < grid2.length; r++) {
            for (int c = 0; c < grid2[0].length; c++) {
                // fix this!
                // An island in grid2 is considered a sub-island if there is an island in grid1
                // that contains all the cells that make up this island in grid2.
                if (!visit2[r][c] && grid2[r][c] == 1) {
                    islandToSq.putIfAbsent(island, new ArrayList<>());
                    this.bfs2(grid2, visit2, r, c, island, islandToSq);
                    island += 1;
                }
            }
        }
        int islands = 0;
        for (Map.Entry<Integer, List<Cord>> entry : islandToSq.entrySet()) {
            int k = entry.getKey();
            int need = entry.getValue().size();
            int have = 0;
            for (Cord cord : entry.getValue()) {
                if (squareToIsland.containsKey(cord)) {
                    have += 1;
                }
            }
            if (have == need) {
                islands += 1;
            }
        }
        return islands;
    }

    Cord[] directions = {new Cord(1, 0), new Cord(-1, 0), new Cord(0, 1), new Cord(0, -1)};

    private void bfs(int[][] grid, boolean[][] visit, int r, int c, int island, Map<Cord, Integer> sqToIsland) {
        Deque<Cord> q = new ArrayDeque<>();
        Cord start = new Cord(r, c);
        q.add(start);
        visit[r][c] = true;
        sqToIsland.put(start, island);
        while (!q.isEmpty()) {
            Cord cord = q.removeFirst();
            for (Cord dir : directions) {
                int x = cord.x + dir.x;
                int y = cord.y + dir.y;
                Cord newC = new Cord(x, y);
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visit[x][y]
                        && grid[x][y] == 1) {
                    q.addLast(newC);
                    visit[x][y] = true;
                    sqToIsland.put(newC, island);
                }
            }
        }
    }

    private void bfs2(int[][] grid, boolean[][] visit, int r, int c, int island, Map<Integer, List<Cord>> islandToSq) {
        Deque<Cord> q = new ArrayDeque<>();
        Cord start = new Cord(r, c);
        q.add(start);
        visit[r][c] = true;
        islandToSq.get(island).add(start);
        while (!q.isEmpty()) {
            Cord cord = q.removeFirst();
            for (Cord dir : directions) {
                int x = cord.x + dir.x;
                int y = cord.y + dir.y;
                Cord newC = new Cord(x, y);
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visit[x][y]
                        && grid[x][y] == 1) {
                    q.addLast(newC);
                    visit[x][y] = true;
                    islandToSq.get(island).add(newC);
                }
            }
        }
    }

    record Cord(int x, int y) {
    }


    //        **NeetCode Solution**
    //Time: O(m*n)
//Space: O(m*n)
    public int countSubIslands2(int[][] grid1, int[][] grid2) {
        int ROWS = grid2.length;
        int COLS = grid2[0].length;

        Set<Cord2> visit = new HashSet<>();
        int res = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid2[r][c] == 1 && !visit.contains(new Cord2(r, c))
                        && this.dfs2(grid1, grid2, visit, r, c)) {
                    res += 1;
                }
            }
        }
        return res;
    }

    private boolean dfs2(int[][] grid1, int[][] grid2, Set<Cord2> visit, int r, int c) {
        if (r < 0 || c < 0 || r == grid1.length || c == grid1[0].length
                || grid2[r][c] == 0 || visit.contains(new Cord2(r, c))) {
            return true;
        }
        visit.add(new Cord2(r, c));
        boolean res = true;
        if (grid1[r][c] == 0) {
            res = false;
        }
        res = this.dfs2(grid1, grid2, visit, r + 1, c) && res;
        res = this.dfs2(grid1, grid2, visit, r - 1, c) && res;
        res = this.dfs2(grid1, grid2, visit, r, c + 1) && res;
        res = this.dfs2(grid1, grid2, visit, r, c - 1) && res;
        return res;
    }

    record Cord2(int r, int c) {
    }
}
