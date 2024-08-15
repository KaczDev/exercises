package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

import java.util.List;

public class LC_21 implements Solution {
    @Override
    public void solve() {
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("Solution: " + this.mergeTwoLists(n1, n2));
        n1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("Solution: " + this.mergeTwoListsCleaner(n1, n2));
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode res = null;
        ListNode newHead = null;
        //Currently the output is empty. Put first element into the list
        if (list1.val <= list2.val) {
            res = list1;
            list1 = list1.next;
        } else {
            res = list2;
            list2 = list2.next;
        }
        newHead = res;
        res.next = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        } else if (list2 != null) {
            res.next = list2;
        }
        return newHead;
    }

    //Time: O(n)
    //Space: O(1)
    private ListNode mergeTwoListsCleaner(ListNode list1, ListNode list2) {
        //To not handle the case where output is empty and we don't know which list should be first
        // just insert them to the next of dummy and remove dummy when returning;
        ListNode dummy = new ListNode();
        ListNode tail = dummy; //Tail to better understand
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1; //list1 was moved in the previous loop so those are the only remained elements
        } else if (list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}
