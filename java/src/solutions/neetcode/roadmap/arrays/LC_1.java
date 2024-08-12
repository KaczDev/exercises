package solutions.neetcode.roadmap.arrays;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/
public class LC_1 implements Solution {
    @Override
    public void solve() {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        int[] nums4 = {3, 2, 3};
        int target1 = 9;
        int target2 = 6;
        int target3 = 9;
        int target4 = 6;
        System.out.println("Solution: " + Arrays.toString(this.solution(nums1, target1)));
        System.out.println("Solution: " + Arrays.toString(this.solution(nums2, target2)));
        System.out.println("Solution: " + Arrays.toString(this.solution(nums3, target3)));
        System.out.println("Solution: " + Arrays.toString(this.solution(nums4, target4)));
    }

    //Time: O(n)
    //Space: O(n)
    private int[] solution(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        Map<Integer, Integer> valueIdxMap = new HashMap<>(nums.length);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; ++i) {
            int needed = target - nums[i];
            if (valueIdxMap.containsKey(needed)) {
                return new int[]{valueIdxMap.get(needed), i};
            }
            valueIdxMap.put(nums[i], i);
        }
        return nums;
    }
}
