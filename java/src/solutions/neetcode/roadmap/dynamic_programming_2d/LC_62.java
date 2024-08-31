package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_62 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.uniquePaths(3, 7));
        System.out.println("Solution: " + this.uniquePaths(3, 2));
        System.out.println("Solution: " + this.uniquePaths(23, 12));

        System.out.println("Solution: " + this.uniquePathsOptimizedSpace(3, 7));
        System.out.println("Solution: " + this.uniquePathsOptimizedSpace(3, 2));
        System.out.println("Solution: " + this.uniquePathsOptimizedSpace(23, 12));
    }

    private int uniquePaths(int m, int n) {
        Map<List<Integer>, Integer> cache = new HashMap<>();
        cache.put(List.of(m - 1, n - 1), 1);
        return this.dfs(m, n, 0, 0, cache);
    }

    private int dfs(int m, int n, int r, int c, Map<List<Integer>, Integer> cache) {
        if (r >= m || c >= n || r < 0 || c < 0) {
            return 0;
        }
        if (cache.containsKey(List.of(r, c))) {
            return cache.get(List.of(r, c));
        }
        int endRow = m - 1;
        int endCol = n - 1;
        if (r == endRow && c == endCol) {
            return 1;
        }
        int paths = this.dfs(m, n, r + 1, c, cache) + this.dfs(m, n, r, c + 1, cache);
        cache.put(List.of(r, c), paths);
        return paths;
    }

    public int uniquePathsOptimizedSpace(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);
        // m-1 => they're all 1s
        // n-1 => they're all 1s
        for (int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for (int j = n - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        return row[0];
    }
}
