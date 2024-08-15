package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

public class LC_206 implements Solution {
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
        System.out.println("Solution: " + this.reverseList(n));
        n = new ListNode(1);
        n1 = new ListNode(2);
        n2 = new ListNode(3);
        n3 = new ListNode(4);
        n4 = new ListNode(5);
        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("Solution: " + this.reverseListRecursive(n));
    }

    //Time: O(n)
    //Space: O(1)
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //put on side because we break the link
            ListNode nxt = curr.next;
            // make the detached left element point to the previous (null or the one that was earlier to the left)
            curr.next = prev;
            // update our previous to the current element (so the next iteration updates to the left)
            prev = curr;
            //set current to the head of the list we put on the side
            curr = nxt;
        }
        return prev;
    }

    private ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }


}
