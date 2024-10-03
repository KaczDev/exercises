package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_1590 implements Solution {
    @Override
    public void solve() {
        int[] arr = {3, 1, 4, 2};
        int p = 6;
        System.out.println("Solution: " + this.minSubarray(arr, p));
        arr = new int[]{6, 3, 5, 2};
        p = 9;
        System.out.println("Solution: " + this.minSubarray(arr, p));
        p = 3;
        arr = new int[]{1, 2, 3};
        System.out.println("Solution: " + this.minSubarray(arr, p));
        p = 3;
        arr = new int[]{1000000000, 1000000000, 1000000000};
        System.out.println("Solution: " + this.minSubarray(arr, p));
    }

    public int minSubarray(int[] nums, int p) {
        Map<Long, Integer> remainderToIndex = new HashMap<>();
        long total = 0;
        for (int n : nums) {
            total += n;
        }
        long remainder = total % p;
        if (remainder == 0) {
            return 0;
        }
        int res = nums.length;
        long cur_sum = 0;
        remainderToIndex.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            // x = cur_sum - remain
            cur_sum = (cur_sum + nums[i]) % p;
            long prefix = (cur_sum - remainder + p) % p;
            if (remainderToIndex.containsKey(prefix)) {
                int length = i - remainderToIndex.get(prefix);
                res = Math.min(res, length);
            }
            remainderToIndex.put(cur_sum, i);
        }
        return res == nums.length ? -1 : res;
    }
}
