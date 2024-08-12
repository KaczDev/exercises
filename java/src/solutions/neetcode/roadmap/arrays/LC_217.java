package solutions.neetcode.roadmap.arrays;

import solutions.Solution;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/description/
public class LC_217 implements Solution {
    @Override
    public void solve() {
        int[] nums1 = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] nums3 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Solution: " + this.solution(nums1));
        System.out.println("Solution: " + this.solution(nums2));
        System.out.println("Solution: " + this.solution(nums3));
    }

    private boolean solution(int[] nums) {
        // # First attempt // Space: O(n) Time: O(n? (not sure how collections work))
//        Set<Integer> set = Arrays
//                .stream(nums)
//                .boxed()
//                .collect(Collectors.toSet());
//        return set.size() != nums.length;

        // # Second attempt // Space: O(n) Time: O(n)
        Set<Integer> list = new HashSet<>();
        for (int num : nums) {
            if (list.contains(num)) {
                return true;
            }
            list.add(num);
        }
        return false;
    }

}
