package solutions.leetcode.twopointers;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15 implements Solution {
    @Override
    public void solve() {
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{0, 1, 1};
        int[] nums3 = new int[]{0, 0, 0};
        System.out.println("Solution: " + this.threeSum(nums1));
        System.out.println("Solution: " + this.threeSum(nums2));
        System.out.println("Solution: " + this.threeSum(nums3));
    }

    //Time: O(n log n) + O(n^2) = O(n^2)
    //Space: O(1) (Also depends if java sorting does take memory)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Sort the array
        Arrays.sort(nums); //TODO do quicksort just for my own practice
        //Go over the sorted array
        // If value is the same skip
        int prevValue =

        //Take the first available value and then to TwoPointer TwoSum on all of the elements to the right
        //Then take next available value and do the TwoSum again

        return res;
    }
}
