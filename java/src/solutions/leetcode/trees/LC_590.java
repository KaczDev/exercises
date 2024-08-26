package solutions.leetcode.trees;

import solutions.Solution;
import solutions.leetcode.trees.NTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC_590 implements Solution {
    @Override
    public void solve() {
        List<NTreeNode> children3 = List.of(new NTreeNode(5), new NTreeNode(6));
        List<NTreeNode> children1 = List.of(new NTreeNode(3, children3), new NTreeNode(2), new NTreeNode(4));
        NTreeNode n = new NTreeNode(1, children1);
        System.out.println("Solution: " + this.postorderRecurse(n));
        System.out.println("Solution: " + this.postorderIter(n));
    }

    private List<Integer> postorderIter(NTreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<NodeVisited> stack = new Stack<>();
        stack.add(new NodeVisited(root, false));
        while (!stack.isEmpty()) {
            NodeVisited n = stack.pop();
            if (n.visited) {
                res.add(n.node.val);
            } else {
                stack.add(new NodeVisited(n.node, true));
                if (n.node.children != null) {
                    for (int i = n.node.children.size() - 1; i >= 0; i--) {
                        stack.add(new NodeVisited(n.node.children.get(i), false));
                    }
                }
            }
        }
        return res;
    }

    record NodeVisited(NTreeNode node, boolean visited) {
    }

    private List<Integer> postorderRecurse(NTreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        this.construct(root, res);
        return res;
    }

    private void construct(NTreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (root.children != null) {
            for (NTreeNode c : root.children) {
                this.construct(c, res);
            }
        }
        res.add(root.val);
    }
}
