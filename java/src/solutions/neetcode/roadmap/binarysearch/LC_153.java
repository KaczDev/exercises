package solutions.neetcode.roadmap.binarysearch;

import solutions.Solution;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class LC_153 implements Solution {


    @Override
    public void solve() {
        int[] nums1 = {3,4,5,1,2};
        int[] nums2 = {4,5,6,7,0,1,2};
        int[] nums3 = {11,13,15,17};
        System.out.println("Solution: "+this.findMin(nums1));
        System.out.println("Solution: "+this.findMin(nums2));
        System.out.println("Solution: "+this.findMin(nums3));
    }

    //My solution
    //Time: O(log n)
    //Space: O(1)
    private int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (nums[l] > nums[r]) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[l]) {
                r = mid;
            } else if (nums[r] < nums[mid] && nums[mid] < nums[l]) {
                return mid;
            }
        }
        return nums[l];
    }
}
