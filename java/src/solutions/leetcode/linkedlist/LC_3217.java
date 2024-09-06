package solutions.leetcode.linkedlist;

import solutions.Solution;
import solutions.neetcode.roadmap.linkedlists.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC_3217 implements Solution {
    @Override
    public void solve() {

    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numbers =  new HashSet<>();
        for (int n: nums){
            numbers.add(n);
        }
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while (prev.next!=null) {
            if (numbers.contains(prev.next.val)){
                prev.next=prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
