package solutions.leetcode.algorithms;

import solutions.Solution;

//https://leetcode.com/problems/binary-search/
public class LC_704 implements Solution {

    @Override
    public void solve() {
        int[] nums1 = new int[]{-1, 0, 3, 5, 9, 12};
        int[] nums2 = new int[]{-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int target2 = 2;

        System.out.println("Solution: " + this.search(nums1, target1));
        System.out.println("Solution: " + this.search(nums2, target2));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length;

        do {
            int mid = lo + ((hi - lo) / 2);
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (lo < hi);
        return -1;
    }
}
