package solutions.neetcode.roadmap.slidingwindows;

import solutions.Solution;

import java.util.*;

//https://leetcode.com/problems/sliding-window-maximum/description/
public class LC_239 implements Solution {
    @Override
    public void solve() {
//        System.out.println("Solution: " + Arrays.toString(this.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println("Solution: " + Arrays.toString(this.maxSlidingWindow(new int[]{7,2,4}, 2)));
        System.out.println("Solution: " + Arrays.toString(this.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }

    // Time: O(n)
    private int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        //Left most value will be the highest.
        // but also left most value will represent the left side of the window
        Deque<Integer> q = new ArrayDeque<>(); // indexes
        int l = 0;
        int r = 0;
        int idx = 0;
        while (r < nums.length) {
            // pop smaller values from q
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);
            //remove left dangling index (on the outside of the right edge of the window)
            if (l > q.peekFirst()) {
                q.removeFirst();
            }
            if (r + 1 >= k) {
                res[idx] = nums[q.peekFirst()];
                idx+=1;
                l += 1;
            }
            r += 1;
        }
        return res;
    }

    //Time: O(k * (n-k))  // Brute force kinda
//    private int[] maxSlidingWindow(int[] nums, int k) {
//        int[] res = new int[nums.length - k + 1];
//        int l = 0;
//        int idx =0;
//        for (int r = k - 1; r < nums.length; r++) {
//            l = r - k + 1;
//            int max = nums[l];
//            l+=1;
//            while (l <= r) {
//                max = Math.max(nums[l], max);
//                l+=1;
//            }
//            res[idx] = max;
//            idx+=1;
//        }
//        return res;
//    }
}
