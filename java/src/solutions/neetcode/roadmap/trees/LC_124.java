package solutions.neetcode.roadmap.trees;

import solutions.Solution;

public class LC_124 implements Solution {
    private int res = 0;

    @Override
    public void solve() {
        TreeNode t = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Solution: " + this.maxPathSum(t));
    }

    private int maxPathSum(TreeNode root) {
        this.res = root.val;
        this.dfs(root);
        return res;
    }

    // return max path sum without split
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = this.dfs(root.left);
        int rightMax = this.dfs(root.right);
        //Get rid of negative nodes
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        //compute max path sum WITH split
        this.res = Math.max(res, root.val + leftMax + rightMax);
        //Computer without splitting
        return root.val + Math.max(leftMax, rightMax);
    }
}
