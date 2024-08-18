package solutions.neetcode.roadmap.heaps;

import solutions.Solution;

import java.util.*;

public class LC_215 implements Solution {

    @Override
    public void solve() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Solution: " + this.findKthLargest(nums, k));
        System.out.println("Solution: " + this.findKthLargestQS(nums, k));
    }

    //Time: O(n log(n)) //Creating a heap is N * log N operations.
    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
        }
        while (k > 1) {
            k--;
            maxHeap.remove();
        }
        return maxHeap.remove();
    }

    private int findKthLargestQS(int[] nums, int k) {
        k = nums.length - k; // k is the index of the element inf nums was sorted;
        return this.quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int l, int r) {
        int pivot = nums[r];
        int p = l;
        for (int i = l; i < r; i++) {
            // partition
            if (nums[i] <= pivot) {
                int tmp = nums[p];
                nums[p] = nums[i];
                nums[i] = tmp;
                p += 1;
            }
        }
        // swap pivot to p
        int tmp = nums[p];
        nums[p] = nums[r];
        nums[r] = tmp;
        if (p > k) {
            // quick select on left portion of array;
            return quickSelect(nums, k, l, p - 1);
        }
        if (p < k) {
            return quickSelect(nums, k, p + 1, r);
        }
        // p==k
        return nums[p];
    }
}

