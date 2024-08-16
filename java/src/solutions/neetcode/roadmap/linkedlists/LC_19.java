package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class LC_19 implements Solution {
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
        System.out.println("Solution: " + this.removeNthFromEnd(n, 2));
    }

    //Time: O(n)
    //Space: O(1)
    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy;
        ListNode right = head;
        int i = 0;
        while (i < n) {
            right = right.next;
            i++;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        //delete the node
        left.next = left.next.next;
        return dummy.next;
    }
}
