package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

import java.awt.*;

public class LC_2 implements Solution {
    @Override
    public void solve() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        System.out.println("Solution: " + this.addTwoNumbers(l1, l2));
        System.out.println("Solution: " + this.addTwoNumbersNeetCode(l1, l2));
    }

    private ListNode addTwoNumbersNeetCode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int carryOver = 0;
        while (l1 != null || l2 != null || carryOver > 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            // new digit
            int val = v1 + v2 + carryOver;
            carryOver = val / 10;
            val = val % 10;
            tail.next = new ListNode(val);
            tail = tail.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Go through the lists and if sum>0 the next node's has to get this carried over
        // only single digit is allowed
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carryOver = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryOver;
            if (sum >= 10) {
                carryOver = sum / 10;
                sum = sum % 10;

            } else {
                carryOver = 0;
            }
            ListNode digit = new ListNode(sum);
            tail.next = digit;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carryOver;
            if (sum >= 10) {
                carryOver = 1;
                sum = sum % 10;
            } else {
                carryOver = 0;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carryOver;
            if (sum >= 10) {
                carryOver = 1;
                sum = sum % 10;
            } else {
                carryOver = 0;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
            l2 = l2.next;
        }
        //last number still added to >=10 just insert 1
        if (carryOver > 0) {
            tail.next = new ListNode(carryOver);
        }
        return dummy.next;
    }
}


