package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

public class LC_25 implements Solution {
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
        System.out.println("Solution: " + this.reverseKGroup(n, 2));
    }

    //Time: O(n)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = this.getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;

            //reverse group
            ListNode prev = kth.next, curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        int i = 0;
        while (curr != null && i < k) {
            curr = curr.next;
            i++;
        }
        return curr;
    }
}
