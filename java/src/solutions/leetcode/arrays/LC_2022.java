package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;

public class LC_2022 implements Solution {

    @Override
    public void solve() {
        System.out.println("Solution: "+ Arrays.deepToString(this.construct2DArray(new int[]{1,2,3,4},2,2)));
        System.out.println("Solution: "+ Arrays.deepToString(this.construct2DArray(new int[]{1,2,3},1,3)));
        System.out.println("Solution: "+ Arrays.deepToString(this.construct2DArray(new int[]{1,2},1,1)));
        System.out.println("Solution: "+ Arrays.deepToString(this.construct2DArray(new int[]{3},1,2)));
    }
    private int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length)
            return new int[0][];
        int[][] res = new int[m][n];
        int r = 0;
        int c = 0;
        for (int num : original) {
            if (c == n) {
                c = 0;
                r += 1;
            }
            res[r][c] = num;
            c += 1;
        }
        return res;
    }

}
