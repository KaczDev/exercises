package solutions.neetcode.roadmap.arrays;

import solutions.Solution;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class LC_347 implements Solution {
    @Override
    public void solve() {
        int[] nums1 = new int[]{1, 1, 1, 2, 2, 3};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{3, 2, 2, 1, 1, 1};
        int k1 = 2;
        int k2 = 1;
        int k3 = 2;
        System.out.println("Solution: " + Arrays.toString(this.topKFrequent(nums1, k1)));
        System.out.println("Solution: " + Arrays.toString(this.topKFrequent(nums2, k2)));
        System.out.println("Solution: " + Arrays.toString(this.topKFrequent(nums3, k3)));
    }

    private int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberFrequency = new HashMap<>();
        List<List<Integer>> frequencies = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; ++i) {
            frequencies.add(i, new ArrayList<>());
        }
        for (int num : nums) {
            //Increase frequency in map
            numberFrequency.put(num, numberFrequency.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numberFrequency.entrySet()) {
            frequencies.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int insertedK = 0;
        for (int i = frequencies.size() - 1; i >= 0; --i) {
            //add to res
            if (!frequencies.get(i).isEmpty()) {
                for (int num : frequencies.get(i)) {
                    res[insertedK] = num;
                    insertedK++;
                    if (insertedK == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
