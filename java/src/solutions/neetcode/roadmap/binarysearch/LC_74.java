package solutions.neetcode.roadmap.binarysearch;

import solutions.Solution;

public class LC_74 implements Solution {
    @Override
    public void solve() {
        int target1 = 3;
        int[][] nums1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target2 = 13;
        int[][] nums2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] nums3 = {{1}};
        int target3 = 1;
        System.out.println("Solution: " + this.searchMatrix(nums1, target1));
        System.out.println("Solution: " + this.searchMatrix(nums2, target2));
        System.out.println("Solution: " + this.searchMatrix(nums3, target3));
        System.out.println("Solution: " + this.searchMatrix(nums3, 2));
    }

    //%Time: O(log M + log N)
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int lo = 0, hi = ROWS - 1;
        // We <= because we're matching rows here and elements in the array.
        // So we don't want to set mid to the higher boundary as we will be checking it in the array
        // and if mid == matrix.length we go out of bounds
        // That's why hi = ROWS -1;
        while (lo <= hi) {
            int midRow = lo + (hi - lo) / 2;
            if (target > matrix[midRow][COLS - 1]) {
                lo = midRow + 1;
            } else if (target < matrix[midRow][0]) {
                hi = midRow - 1;
            } else {
                break;
            }
        }
        if (!(lo <= hi)) {
            return false;
        }
        int row = (lo + hi) / 2;
        lo = 0;
        hi = COLS - 1;
        // We <= because we're matching rows here and elements in the array.
        // So we don't want to set mid to the higher boundary as we will be checking it in the array
        // and if mid == matrix.length we go out of bounds
        // hi = COLS -1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }
        return false;
    }

    private boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (target > row[row.length - 1]) break;
            if (row[0] <= target && target <= row[row.length - 1]) {
                int lo = 0;
                int hi = row.length;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (row[mid] == target) return true;
                    if (row[mid] < target) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
            }
        }
        return false;
    }
}
