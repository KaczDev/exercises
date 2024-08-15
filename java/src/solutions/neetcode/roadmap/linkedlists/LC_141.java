package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC_141 implements Solution {
    @Override
    public void solve() {
        ListNode n = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        System.out.println("Solution: " + this.hasCycleSetSolve(n));
        System.out.println("Solution: " + this.hasCycleTurtleHare(n));
    }

    //Time: O(n)
    //Space: O(1)
    private boolean hasCycleTurtleHare(ListNode n) {
        ListNode slow = n;
        ListNode fast = n;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //Time: O(n)
    //Space: O(n)
    private boolean hasCycleSetSolve(ListNode head) {
        Set<ListNode> visited = new HashSet();

        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}
