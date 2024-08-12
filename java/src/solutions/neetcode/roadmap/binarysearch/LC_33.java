package solutions.neetcode.roadmap.binarysearch;

import solutions.Solution;

public class LC_33 implements Solution {
    @Override
    public void solve() {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Solution: " + this.search(nums1, target1));
    }

    private int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[l]) {
                //Left sorted portion
                if (target > nums[mid] || target < nums[l]) {
                    //search right
                    l = mid + 1;
                } else {
                    //search left
                    r = mid - 1;
                }
            } else {
                //Right sorted portion
                if (target < nums[mid] || target > nums[r]) {
                    //search left
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
