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
        //Take the first available value and then to TwoPointer TwoSum on all of the elements to the right
        for (int i = 0; i < nums.length; i++) {
            int curValue = nums[i];
            if (i > 0 && curValue == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = curValue + nums[l] + nums[r];
                if (threeSum > 0) {
                    r -= 1;
                }
                if (threeSum < 0) {
                    l += 1;
                }
                if (threeSum == 0) {
                    res.add(List.of(curValue, nums[l], nums[r]));
                    l++;
                    //Update one of the pointer as if statements above will update the other.
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
            //Then take next available value and do the TwoSum again
        }
        return res;
    }
}
