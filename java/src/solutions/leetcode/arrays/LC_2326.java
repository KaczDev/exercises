package solutions.leetcode.arrays;

import solutions.Solution;
import solutions.neetcode.roadmap.linkedlists.ListNode;

import java.util.Arrays;

public class LC_2326 implements Solution {
    @Override
    public void solve() {
        ListNode head = new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(6, new ListNode(8, new ListNode(1, new ListNode(7, new ListNode(9, new ListNode(4, new ListNode(2, new ListNode(5, new ListNode(5, new ListNode(0)))))))))))));
        int m = 3;
        int n = 5;
        System.out.println("Solution: " + Arrays.deepToString(this.spiralMatrix(m, n, head)));
        System.out.println("Solution: " + Arrays.deepToString(this.spiralMatrixCleaner(m, n, head)));
    }

    private int[][] spiralMatrix(int m, int n, ListNode head) {
        int left = 0, right = n;
        int top = 0, bottom = m;
        int[][] grid = new int[m][n];
        for (int[] sub : grid) {
            Arrays.fill(sub, -1);
        }
        while (head != null) {
            // 1. left to right
            for (int i = left; i < right; i++) {
                if (head == null) {
                    return grid;
                }
                grid[top][i] = head.val;
                head = head.next;
            }
            top += 1;
            // 2. top to bottom
            for (int i = top; i < bottom; i++) {
                if (head == null) {
                    return grid;
                }
                grid[i][right - 1] = head.val;
                head = head.next;
            }
            right -= 1;
            // 3. right to left
            for (int i = right - 1; i >= left; i--) {
                if (head == null) {
                    return grid;
                }
                grid[bottom - 1][i] = head.val;
                head = head.next;
            }
            bottom -= 1;
            // 4. bottom to top
            for (int i = bottom - 1; i >= top; i--) {
                if (head == null) {
                    return grid;
                }
                grid[i][left] = head.val;
                head = head.next;
            }
            left += 1;
        }
        return grid;
    }

    private int[][] spiralMatrixCleaner(int m, int n, ListNode head) {
        int left = 0, right = n;
        int top = 0, bottom = m;
        int[][] grid = new int[m][n];
        for (int[] sub : grid) {
            Arrays.fill(sub, -1);
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0;
        int c = 0;
        int d = 0;
        while (head != null) {
            int dr = directions[d][0];
            int dc = directions[d][1];
            // if grid[r][c] != -1 it means it was already visited
            while (head != null
                    && left <= c && c < right
                    && top <= r && r < bottom
                    && grid[r][c] == -1) {
                grid[r][c] = head.val;
                head = head.next;
                r += dr;
                c += dc;
            }
            // undo the last iteration of the while loop which moves
            // the r and c oob
            r -= dr;
            c -= dc;
            // update direction
            d = (d + 1) % 4;
            // move the r and c by directions otherwise we will overwrite
            // current cell
            dr = directions[d][0];
            dc = directions[d][1];
            r += dr;
            c += dc;
        }
        return grid;
    }
}
