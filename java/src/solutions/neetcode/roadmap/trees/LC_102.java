package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.*;

public class LC_102 implements Solution {
    @Override
    public void solve() {
        TreeNode t = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Solution: " + this.levelOrder(t));
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.push(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.pollFirst();
                if (curr != null) {
                    tmp.add(curr.val);
                    if (curr.left != null) {
                        q.addLast(curr.left);
                    }
                    if (curr.right != null) {
                        q.addLast(curr.right);
                    }
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
