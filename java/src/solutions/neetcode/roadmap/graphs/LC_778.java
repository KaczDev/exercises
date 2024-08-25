package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC_778 implements Solution {
    @Override
    public void solve() {
        int[][] grid  = new int[][]{new int[]{0,2},new int[]{1,3}};
        System.out.println("Solution: "+this.swimInWater(grid));
    }

    // Time: O(n^2 * log n)
    public int swimInWater(int[][] grid) {
        Set<Cord> visit = new HashSet<>();
        PriorityQueue<Square> minH = new PriorityQueue<>(Comparator.comparing(Square::h));
        minH.add(new Square(grid[0][0], new Cord(0, 0)));
        while (!minH.isEmpty()) {
            Square s = minH.remove();
            visit.add(s.c);
            if (s.c.r == grid.length - 1 && s.c.c == grid[0].length - 1) {
                return s.h;
            }
            for (Cord dir : directions) {
                int r = s.c.r + dir.r;
                int c = s.c.c + dir.c;
                if (r < 0 || r >= grid.length || c < 0
                        || c >= grid[0].length
                        || visit.contains(new Cord(r, c))) {
                    continue;
                }
                minH.add(new Square(Math.max(s.h, grid[r][c]), new Cord(r, c)));
            }
        }
        return -1;
    }

    record Cord(int r, int c) {
    }

    record Square(int h, Cord c) {
    }

    Cord[] directions = new Cord[]{new Cord(-1, 0), new Cord(1, 0), new Cord(0, 1), new Cord(0, -1)};
}
