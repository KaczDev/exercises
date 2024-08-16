package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/reorder-list/description/
public class LC_143 implements Solution {
    @Override
    public void solve() {
        ListNode n = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        this.reorderList(n);
        System.out.println("Solution: " + n);
    }

    //Time: O(n)
//Space: O(1)
    public void reorderList(ListNode head) {
        //Find middle of the list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //We found middle, slow.next is the beginning of it
        ListNode second = slow.next;
        slow.next = null; // We have taken the second part into second
        // let's make sure the first part has an end
        //Reverse second part of the list (middle+1 ... n)
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        //we know that either first and second are even
        // or second is shorter so it's first going to be null
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    //Time: O(n)
//Space: O(n)
    public void reorderListMoreSpace(ListNode head) {
        int idx = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode tmp = head; //we take a copy of  head to not drop it when iterating
        while (tmp != null) {
            map.put(idx, tmp);
            idx += 1;
            tmp = tmp.next;
        }
        int left = 1;
        int right = map.size() - 1;
        ListNode tail = head;
        while (left <= right) {
            tail.next = map.get(right);
            tail = tail.next;
            tail.next = map.get(left);
            tail.next.next = null;
            tail = tail.next;
            left += 1;
            right -= 1;
        }
    }
}
