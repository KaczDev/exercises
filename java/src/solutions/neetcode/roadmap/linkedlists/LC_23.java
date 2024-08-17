package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class LC_23 implements Solution {
    @Override
    public void solve() {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
//        System.out.println("Solution: " + this.mergeKListsBruteForce(new ListNode[]{l1, l2, l3}));
//        System.out.println("Solution: " + this.mergeKListsBruteForce(new ListNode[]{}));
//        System.out.println("Solution: " + this.mergeKListsBruteForce(new ListNode[]{null}));
//        System.out.println("Solution: " + this.mergeKListsBruteForce(new ListNode[]{null, null}));


        System.out.println("Solution: " + this.mergeKLists(new ListNode[]{l1, l2, l3}));
    }


    //Time: O(n * log(k))
    //Space: O(1)
    private ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) { // +2 because we go in pairs
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
                mergedLists.add(this.mergeLists(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }

    //Time: O(n*k)
    //Space O(n)
    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                map.put(i, lists[i]);
            }
        }
        while (!map.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            // Find the head with smallest value
            for (Map.Entry<Integer, ListNode> entry : map.entrySet()) {
                if (entry.getValue().val < min) {
                    min = entry.getValue().val;
                    idx = entry.getKey();
                }
            }
            tail.next = map.get(idx);
            tail = tail.next;
            map.put(idx, map.get(idx).next);
            if (map.get(idx) == null) {
                map.remove(idx);
            }
        }
        return dummy.next;
    }
}
