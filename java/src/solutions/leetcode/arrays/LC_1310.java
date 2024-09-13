package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;

public class LC_1310 implements Solution {
    @Override
    public void solve() {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println("Solution" + Arrays.toString(this.xorQueries(arr, queries)));
        System.out.println("Solution" + Arrays.toString(this.xorQueriesBrute(arr, queries)));
    }

    // Time : O(n+q)
    private int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] prefixXORS = new int[arr.length + 1];
        prefixXORS[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixXORS[i + 1] = prefixXORS[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            res[i] = prefixXORS[right + 1] ^ prefixXORS[left];
        }
        return res;
    }

    //Time: O(q*n)
    private int[] xorQueriesBrute(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int a = 0;
        for (int[] q : queries) {
            int ans = 0;
            for (int i = q[0]; i <= q[1]; i++) {
                ans = ans ^ arr[i];
            }
            res[a] = ans;
            a += 1;
        }
        return res;
    }
}
