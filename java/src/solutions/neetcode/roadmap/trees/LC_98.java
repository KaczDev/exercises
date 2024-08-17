package solutions.neetcode.roadmap.trees;

import solutions.Solution;

public class LC_98 implements Solution {
    @Override
    public void solve() {
        TreeNode t = new TreeNode(5, new TreeNode(3), new TreeNode(7, new TreeNode(4), new TreeNode(8)));
        System.out.println("Solution: " + this.isValidBST(t));
    }

    private boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return this.validation(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validation(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        boolean isValid = minValue < root.val && root.val < maxValue;
        if (!isValid)
            return false;
        return this.validation(root.left, minValue, root.val)
                && this.validation(root.right, root.val, maxValue);
    }
}
