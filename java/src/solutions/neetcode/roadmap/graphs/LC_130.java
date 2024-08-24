package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.Arrays;

public class LC_130 implements Solution {
    @Override
    public void solve() {
        char[][] board1 = new char[][]{new char[]{'X', 'X', 'X', 'X'}, new char[]{'X', 'O', 'O', 'X'}, new char[]{'X', 'X', 'O', 'X'}, new char[]{'X', 'O', 'X', 'X'}};
        char[][] board3 = new char[][]{
                new char[]{'O', 'O', 'O'}, new char[]{'O', 'O', 'O'}, new char[]{'O', 'O', 'O'}};
        this.solver(board1);
        System.out.println("Solution: " + Arrays.deepToString(board1));
        this.solver(board3);
        System.out.println("Solution: " + Arrays.deepToString(board3));
    }

    //Time: O(m*n)
    private void solver(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        boolean[][] locked = new boolean[ROWS][COLS];
        // 1. (DFS) Capture unsurrounded regions (O->T)
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O' && isBorder(board, r, c)) {
                    this.capture(board, r, c);
                }
            }
        }
        //2. Capture surrounded regions (O->X)
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        //3. Uncapture unsurrounded regions (T->O)
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int r, int c) {
        if (isOOB(board, r, c) || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }

    private boolean isOOB(char[][] board, int r, int c) {
        return r < 0 || c < 0 || r >= board.length || c >= board[0].length;
    }

    private boolean isBorder(char[][] board, int r, int c) {
        return r == 0 || c == 0 || r == board.length - 1 || c == board[0].length - 1;
    }
}
