package solutions.neetcode.roadmap.bitmanipulation;

import solutions.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC_268 implements Solution {
    @Override
    public void solve() {
        int[] nums = {3, 0, 1};
        System.out.println("Solution: " + this.missingNumberXtraSpace(nums));
        System.out.println("Solution: " + this.missingNumberSumming(nums));
        System.out.println("Solution: " + this.missingNumberXOR(nums));
    }

    private int missingNumberXtraSpace(int[] nums) {
        Set<Integer> allNumbers = new HashSet<>(nums.length);
        for (int i : nums) {
            allNumbers.add(i);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!allNumbers.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private int missingNumberXOR(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    private int missingNumberSumming(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += (i - nums[i]);
        }
        return res;
    }
}
