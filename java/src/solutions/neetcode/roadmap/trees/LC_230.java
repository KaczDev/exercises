package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_230 implements Solution {
    @Override
    public void solve() {
        TreeNode t = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println("Solution: " + this.kthSmallestIterative(t, 1));
        System.out.println("Solution: " + this.kthSmallestRecursive(t, 1));
    }

    public int kthSmallestIterative(TreeNode root, int k) {
        // DFS InOrder Iteratively
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int pops = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            pops += 1;
            if (pops == k) {
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }
    int kthSmallestRecursive(TreeNode root, int k) {
        // DFS InOrder
        List<Integer> order = new ArrayList<>();
        this.dfsInOrder(root, order,k);
        return order.get(k-1);
    }

    private void dfsInOrder(TreeNode root, List<Integer> order, int k) {
        if (root == null || order.size()==k) {
            return;
        }
        this.dfsInOrder(root.left, order,k);
        order.add(root.val);
        this.dfsInOrder(root.right, order,k);
    }
}
