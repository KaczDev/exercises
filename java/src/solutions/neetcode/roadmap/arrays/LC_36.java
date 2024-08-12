package solutions.neetcode.roadmap.arrays;

import solutions.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/description/
public class LC_36 implements Solution {
    record Tuple(int x, int y) {
    }


    @Override
    public void solve() {
        char[][] board1 = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = new char[][]
                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("Solution: " + this.isValidSudoku(board1));
        System.out.println("Solution: " + this.isValidSudoku(board2));
    }

    //    Time: O(9^2)
    //    Space: O(9^2)
    private boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Tuple, Set<Character>> squares = new HashMap<>(); // key (row/3,col/3)
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Tuple squaresKey = new Tuple(row / 3, col / 3);
                rows.putIfAbsent(row, new HashSet<>());
                cols.putIfAbsent(col, new HashSet<>());
                squares.putIfAbsent(squaresKey, new HashSet<>());
                if (board[row][col] == '.') continue;
                if (rows.get(row).contains(board[row][col])
                        || cols.get(col).contains(board[row][col])
                        || squares.get(squaresKey).contains(board[row][col])) {
                    return false;
                }
                //add to maps
                cols.get(col).add(board[row][col]);
                rows.get(row).add(board[row][col]);
                squares.get(squaresKey).add(board[row][col]);
            }
        }
        return true;
    }

}
