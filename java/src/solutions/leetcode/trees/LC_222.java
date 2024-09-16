package solutions.leetcode.trees;

import solutions.Solution;
import solutions.neetcode.roadmap.trees.TreeNode;

public class LC_222 implements Solution {
    @Override
    public void solve() {
        TreeNode t = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println("Solution: "+this.countNodes(t));
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
