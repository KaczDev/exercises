package solutions.leetcode.bitmanipulation;

import solutions.Solution;

import java.util.Arrays;

public class LC_2419 implements Solution {
    @Override
    public void solve() {
        int[] nums = {1, 2, 3, 3, 2, 2};
        System.out.println("Solution: " + this.longestSubarrayTwoPass(nums));
        System.out.println("Solution: " + this.longestSubarray(nums));
    }
    private int longestSubarray(int[] nums) {
        int size = 0;
        int res = 0;
        int curMax = 0;
        for (int n : nums) {
            if (n > curMax) {
                curMax = n;
                size = 1;
                res = 0;
            } else if (n == curMax) {
                size += 1;
            }
            // n < cur_max
            else {
                size = 0;
            }
            res = Math.max(res, size);
        }
        return res;
    }

    private int longestSubarrayTwoPass(int[] nums) {
        int target = Arrays.stream(nums).max().getAsInt();
        int size=0;
        int res=0;
        for ( int n:nums){
            if (n==target){
                size+=1;
            }else {
                size =0;
            }
            res = Math.max(res,size);
        }
        return res;
    }
}
