package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_874 implements Solution {
    @Override
    public void solve() {
        int[] commands = new int[]{4, -1, 3};
        int[][] obstacles = new int[0][];
        System.out.println("Solution: " + this.robotSim(commands, obstacles));
        commands = new int[]{4, -1, 4, -2, 4};
        obstacles = new int[][]{{2, 4}};
        System.out.println("Solution: " + this.robotSim(commands, obstacles));
    }

    // Time O(n+m)
    // Space O(m)
    public int robotSim(int[] commands, int[][] obstacles) {
        // N, E, S, W
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int d = 0;
        int res = 0;
        Set<Tuple> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(new Tuple(o[0], o[1]));
        }

        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d + 3) % 4; //so we never go oob
            } else {
                int dx = directions[d][0];
                int dy = directions[d][1];
                for (int i = 0; i < c; i++) {
                    if (obs.contains(new Tuple(x + dx, y + dy))) {
                        break;
                    }
                    x = x + dx;
                    y = y + dy;
                }

            }
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }

    record Tuple(int x, int y) {
    }
}
