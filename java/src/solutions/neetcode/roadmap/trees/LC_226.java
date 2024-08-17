package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.Stack;

public class LC_226 implements Solution {
    @Override
    public void solve() {
        TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Solution: " + this.invertTree(tree));
    }

    public TreeNode invertTree(TreeNode root) {
        //dfs in-order
        this.dfs(root);
        return root;
    }

    private void invertIteratively(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t == null)
                continue;
            TreeNode tmp = t.left;
            t.left = t.right;
            t.right = tmp;
            stack.push(t.right);
            stack.push(t.left);
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        //pre
        //go left
        dfs(root.left);
        //mid/
        //visitNode - switch here
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //post
        //go right (it's switched to left now)
        dfs(root.left);
    }

}
