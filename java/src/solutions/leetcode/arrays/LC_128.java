package solutions.leetcode.arrays;

import solutions.Solution;

import java.awt.desktop.AppReopenedEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LC_128 implements Solution {
    @Override
    public void solve() {
        int[] nums1 = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums3 = new int[]{0};
        System.out.println("Solution: " + this.longestConsecutive(nums1));
        System.out.println("Solution: " + this.longestConsecutive(nums2));
        System.out.println("Solution: " + this.longestConsecutive(nums3));
    }

    //Time: O(n)
    //Space: O(n)
    private int longestConsecutive(int[] nums) {
        //<LastInSequence, length>
        Set<Integer> sequences = new HashSet<>();
        int maxLen = 0;
        for (int num : nums) {
            sequences.add(num);
        }
        for (int num : nums) {
            //If it's the start of the sequence
            if (!sequences.contains(num - 1)) {
                int lenOfNum = 0;
                //right because we start the sequence here
                while (sequences.contains(num + lenOfNum)) {
                    lenOfNum++;
                }
                maxLen = Math.max(maxLen, lenOfNum);
            }
        }
        return maxLen;
    }

}
