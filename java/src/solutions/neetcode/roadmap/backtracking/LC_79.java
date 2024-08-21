package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

public class LC_79 implements Solution {
    @Override
    public void solve() {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        String word2 = "SEE";
        System.out.println("Solution: " + this.exist(board, word));
        System.out.println("Solution: " + this.exist(board, word2));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (this.recurse(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // dfs recursion, i = idx of word[i] to look at
    private boolean recurse(char[][] board, String word, int i, int row, int col, boolean[][] visited) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                visited[row][col] || word.charAt(i) != board[row][col]) {
            return false;
        }
        visited[row][col] = true;

        boolean down = this.recurse(board, word, i + 1, row + 1, col, visited);
        boolean up = this.recurse(board, word, i + 1, row - 1, col, visited);
        boolean right = this.recurse(board, word, i + 1, row, col + 1, visited);
        boolean left = this.recurse(board, word, i + 1, row, col - 1, visited);
        boolean res = left || right || up || down;
        visited[row][col] = false;
        return res;
    }}
