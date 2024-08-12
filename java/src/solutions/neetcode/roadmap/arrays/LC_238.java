package solutions.neetcode.roadmap.arrays;

import solutions.Solution;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/description/
public class LC_238 implements Solution {

    @Override
    public void solve() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Solution: " + Arrays.toString(this.productExceptSelf(nums1)));
        System.out.println("Solution: " + Arrays.toString(this.productExceptSelf(nums2)));
    }

    // Time: O(n)
    // Space: O(1) // Exercise says output doesn't count
    private int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
//        Arrays.fill(res, 1);
        res[0] = 1;
        res[nums.length - 1] = 1;

        int pre = 1;
        for (int i = 0; i < nums.length; ++i) {
            res[i] = pre;
            pre = pre * nums[i];
        }
        int post = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            res[i] *= post;
            post = nums[i] * post;
        }
        return res;
    }
}
