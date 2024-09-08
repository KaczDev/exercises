package solutions.leetcode.linkedlist;

import solutions.Solution;
import solutions.neetcode.roadmap.linkedlists.ListNode;

import java.util.Arrays;

public class LC_725 implements Solution {
    @Override
    public void solve() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        int k = 5;
        System.out.println("Solution: " + Arrays.toString(this.splitListToParts(head, k)));
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        k = 3;
        System.out.println("Solution: " + Arrays.toString(this.splitListToParts(head, k)));
    }

    private ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length += 1;
        }
        int baseLength = length / k;
        //tells us how many lists need more than baseLength elements
        int remainder = length % k;
        cur = head;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            res[i] = cur;
            //go over the elements to find the cutoff point
            for (int j = 0; j < baseLength - 1 + (remainder > 0 ? 1 : 0); j++) {
                if (cur == null)
                    break;
                cur = cur.next;
            }
            remainder -= 1;
            //cut off the list in the result
            if (cur != null) {
                ListNode tmp = cur.next;
                cur.next = null;
                cur = tmp;
            }

        }
        return res;
    }
}
