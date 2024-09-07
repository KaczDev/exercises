package solutions.leetcode.linkedlist;

import solutions.Solution;
import solutions.neetcode.roadmap.linkedlists.ListNode;
import solutions.neetcode.roadmap.trees.TreeNode;

public class LC_1367 implements Solution {
    @Override
    public void solve() {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(8)));
        TreeNode root = new TreeNode(1, new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null)),
                new TreeNode(4, new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))), null));
        System.out.println("Solution: " + this.isSubPath(head, root));
    }

    private boolean isSubPath(ListNode head, TreeNode root) {
        if (this.validate(head, root)) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean validate(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return this.validate(head.next, root.left) || this.validate(head.next, root.right);
    }
}
