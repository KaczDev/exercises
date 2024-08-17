package solutions.neetcode.roadmap.trees;

import solutions.Solution;

public class LC_110 implements Solution {
    @Override
    public void solve() {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Solution: "+this.isBalanced(tree));
    }

    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = root.left != null ? this.height(root.left) : 0;
        int rightH = root.right != null ? this.height(root.right) : 0;
        if (Math.abs(leftH - rightH) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(this.height(root.left), this.height(root.right));
    }
}
