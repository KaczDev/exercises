package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_51 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.solveNQueens(4));
    }

    Set<Integer> posDiag; // (r+c)
    Set<Integer> negDiag; // (r-c)
    Set<Integer> cols;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.posDiag = new HashSet<>();
        this.negDiag = new HashSet<>();
        this.cols = new HashSet<>();
        // for (int row =0;row<n;row++){
        // for(int col=0;col<0;col++){
        // this.recurse(boolean[][] negDiag, boolean[][]posDiag);
        // }
        // }
        this.res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        this.backtrack(n, 0, board);
        return this.res;
    }

    private void backtrack(int n, int r, char[][] board) {
        if (r == n) {
            // valid solution
            List<String> s = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                s.add(sb.toString());
            }
            this.res.add(s);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';
            backtrack(n, r + 1, board);
            // cleanup | backtrack
            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
}
