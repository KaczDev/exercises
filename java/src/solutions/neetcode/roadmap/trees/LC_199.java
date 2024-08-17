package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC_199 implements Solution {
    @Override
    public void solve() {
        TreeNode t = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println("Solution: " + this.rightSideView(t));
    }

    private List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //BFS remove first from left then insert children to the end
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            res.add(q.peekLast().val);
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.removeFirst();
                if (node.left != null) {
                    q.addLast(node.left);
                }
                if (node.right != null) {
                    q.addLast(node.right);
                }
                size--;
            }
        }
        return res;
    }
}
