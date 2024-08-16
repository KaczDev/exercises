package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

public class LC_287 implements Solution {

    @Override
    public void solve() {
//        System.out.println("Solution: " + this.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println("Solution: " + this.findDuplicate(new int[]{4, 3, 1, 4, 2}));
    }

    private int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // phase one - first intersection
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        // phase two
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                break;
            }
        }
        return slow;
    }
}
