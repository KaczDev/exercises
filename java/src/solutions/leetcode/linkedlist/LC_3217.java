package solutions.leetcode.linkedlist;

import solutions.Solution;
import solutions.neetcode.roadmap.linkedlists.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC_3217 implements Solution {
    @Override
    public void solve() {
        int[] nums = {1};
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, null))))));
//        head = [1,2,1,2,1,2]
        System.out.println("Solution: " + this.modifiedList(nums, head));
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numbers = new HashSet<>();
        for (int n : nums) {
            numbers.add(n);
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (prev.next != null) {
            if (numbers.contains(prev.next.val)) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
