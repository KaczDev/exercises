package solutions.leetcode.trees;

import solutions.Solution;
import solutions.neetcode.roadmap.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class LC_2583 implements Solution {
    @Override
    public void solve() {
        TreeNode t = new TreeNode(5, new TreeNode(8, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(1)), new TreeNode(9, new TreeNode(3), new TreeNode(7)));
        int k = 2;
        System.out.println("Solution: " + this.kthLargestLevelSum(t, k));
    }

    private long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        PriorityQueue<Long> maxH = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<TreeNode> q = new ArrayDeque<>();
        q.push(root);
        while (!q.isEmpty()) {
            int qsize = q.size();
            long levelSum = 0;
            for (int i = 0; i < qsize; i++) {
                TreeNode t = q.removeFirst();
                levelSum += t.val;
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            maxH.add(levelSum);
        }
        for (int i = 0; i < k - 1; i++) {
            maxH.remove();
        }
        return maxH.remove();
    }
}
