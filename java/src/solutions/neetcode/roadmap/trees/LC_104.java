package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC_104 implements Solution {
    @Override
    public void solve() {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(10, new TreeNode(15), new TreeNode(7)));
        System.out.println("Solution: " + this.maxDepth(tree));
        System.out.println("Solution: " + this.iterativeBfs(tree));
        System.out.println("Solution: " + this.iterativeDfs(tree));
    }

    record Tuple(TreeNode t, int depth) {
    }


    //Pre-order
    private int iterativeDfs(TreeNode root) {
        Stack<Tuple> stack = new Stack<>();
        int d = 0;
        stack.push(new Tuple(root, 1));
        while (!stack.isEmpty()) {
            Tuple cur = stack.pop();
            if (cur.t != null) {
                d = Math.max(d, cur.depth);
                stack.push(new Tuple(cur.t.left, cur.depth + 1));
                stack.push(new Tuple(cur.t.right, cur.depth + 1));
            }
        }
        return d;
    }

    private int iterativeBfs(TreeNode root) {
        int levels = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            //go over the q and remove elements currently in it
            for (int i = 0; i < q.size(); ++i) {
                TreeNode node = q.pop();
                if (node.left != null) {
                    q.push(node.left);
                }
                if (node.right != null) {
                    q.push(node.right);
                }
            }
            levels += 1;
        }
        return levels;
    }

    private int maxDepth(TreeNode root) {
        return this.dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(this.dfs(root.left), this.dfs(root.right));
    }
}


