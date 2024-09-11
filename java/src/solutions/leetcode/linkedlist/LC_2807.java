package solutions.leetcode.linkedlist;

import solutions.Solution;
import solutions.neetcode.roadmap.linkedlists.ListNode;

public class LC_2807 implements Solution {
    @Override
    public void solve() {

    }
    private ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            ListNode next = cur.next;
            int gcd = this.gcd(cur.val, next.val);
            ListNode gcdNode = new ListNode(gcd,next);
            cur.next = gcdNode;
            cur = cur.next.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
