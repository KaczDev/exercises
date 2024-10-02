package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC_1331 implements Solution {
    @Override
    public void solve() {
        int[] arr = {40, 10, 20, 30};
        System.out.println("Solution: " + Arrays.toString(this.arrayRankTransform(arr)));
    }

    private int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> numToRank = new HashMap<>();
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int rank = 1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (i > 0 && sortedArr[i] > sortedArr[i - 1]) {
                rank++;
            }
            numToRank.put(sortedArr[i], rank);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numToRank.get(arr[i]);
        }
        return arr;
    }
}
