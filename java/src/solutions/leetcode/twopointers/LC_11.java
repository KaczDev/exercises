package solutions.leetcode.twopointers;

import solutions.Solution;

public class LC_11 implements Solution {
    @Override
    public void solve() {
        int[] height1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = new int[]{1, 1};
        int[] height3 = new int[]{2, 3, 4, 5, 18, 17, 6};
        System.out.println("Solution: " + this.maxArea(height1));
        System.out.println("Solution: " + this.maxArea(height2));
        System.out.println("Solution: " + this.maxArea(height3));

    }

    // Optimal solution
    // Time: O(n)
    // Space: O(1)
    private int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            //Area
            int x = r - l;
            int y = Math.min(height[l], height[r]);
            int area = x * y;
            res = Math.max(area, res);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
