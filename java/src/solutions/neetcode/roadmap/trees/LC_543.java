package solutions.neetcode.roadmap.trees;

import solutions.Solution;

public class LC_543 implements Solution {
    private int res = 0;

    @Override
    public void solve() {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println("Solution: " + this.diameterOfBinaryTree(tree));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        this.dfs(root);
        return res;
    }

    //returns height
    private int dfs(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int left = this.dfs(curr.left);
        int right = this.dfs(curr.right);
        this.res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
